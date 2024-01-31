package com.example.mrsu_finish.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mrsu_finish.databinding.FragmentLkBinding
import com.example.mrsu_finish.presentation.ViewModels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LK_Fragment : Fragment() {

    private lateinit var binding: FragmentLkBinding

    private val viewModel: MainViewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLkBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUserLastName()
        viewModel.getUserName()
        viewModel.getUserId()

        viewModel.lastName.observe(viewLifecycleOwner, Observer { lastName ->
            binding.fam.text = lastName
        })

        viewModel.name.observe(viewLifecycleOwner, Observer { name ->
            binding.name.text = name
        })
        viewModel.id.observe(viewLifecycleOwner, Observer { id ->
            binding.userId.text = id
        })
    }
}