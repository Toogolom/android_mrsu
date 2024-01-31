package com.example.mrsu_finish.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.mrsu_finish.R
import com.example.mrsu_finish.databinding.FragmentMainBinding
import com.example.mrsu_finish.presentation.ViewModels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivityFragment : AppCompatActivity() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModel<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.bNav.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.calendar -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.TBFragment)
                    true
                }
                R.id.lk -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.LK_Fragment)
                    true
                }
                else -> false
            }
        }

    }
}