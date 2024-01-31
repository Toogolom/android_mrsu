package com.example.mrsu_finish.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mrsu_finish.databinding.FragmentTbBinding
import com.example.mrsu_finish.presentation.ViewModels.MainViewModel
import com.example.mrsu_finish.presentation.adapters.SheduleAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class TBFragment : Fragment() {
    private val adapter = SheduleAdapter()
    private val adapterYMY = SheduleAdapter()
    private lateinit var binding: FragmentTbBinding
    private val viewModel: MainViewModel by viewModel<MainViewModel>()
    private var isCalendarViewVisible = false
    val currentDate = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val dateFormatText = SimpleDateFormat("dd MMMM", Locale("ru", "RU"))
    var selectedDate = dateFormat.format(currentDate.time)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTbBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.Calendar.visibility = View.GONE
        var date =  dateFormatText.format(currentDate.time)
        binding.buttCalendar.text = date

        binding.Calendar.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDateCalendar = Calendar.getInstance().apply {
                set(year, month, dayOfMonth)
            }
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            selectedDate = dateFormat.format(selectedDateCalendar.time)
            viewModel.getShedule(selectedDate)
            viewModel.getGroupInfo(selectedDate)
            binding.Calendar.visibility = View.GONE
            isCalendarViewVisible = false

            date =  dateFormatText.format(selectedDateCalendar.time)
            binding.buttCalendar.text = date
        }

        viewModel.getShedule(selectedDate)
        viewModel.shedule.observe(viewLifecycleOwner, Observer { shedule ->
            if (shedule.isNotEmpty()) {
                binding.RWCalendar.layoutManager = LinearLayoutManager(requireContext())
                binding.RWCalendar.adapter = adapter
                binding.RWCalendar.setHasFixedSize(true)
                adapter.addTB(shedule[0])


                binding.RWYMY.layoutManager = LinearLayoutManager(requireContext())
                binding.RWYMY.adapter = adapterYMY
                binding.RWYMY.setHasFixedSize(true)
                adapterYMY.addTB(shedule[1])

            }
        })

        viewModel.getGroupInfo(selectedDate)
        viewModel.groupInfo.observe(viewLifecycleOwner, Observer { pair ->
            val facInfoValue = pair.first
            val YMYValue = pair.second

            binding.facInfo.text = facInfoValue
            binding.YMY.text = YMYValue
        })

        binding.buttCalendar.setOnClickListener {
            if (isCalendarViewVisible) {
                binding.Calendar.visibility = View.GONE
                isCalendarViewVisible = false
            } else {
                binding.Calendar.visibility = View.VISIBLE
                isCalendarViewVisible = true
            }
        }

    }
}