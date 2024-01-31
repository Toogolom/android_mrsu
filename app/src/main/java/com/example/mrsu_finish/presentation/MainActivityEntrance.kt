package com.example.mrsu_finish.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mrsu_finish.databinding.FragmentRegBinding
import com.example.mrsu_finish.presentation.ViewModels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivityEntrance : AppCompatActivity() {
    lateinit var binding: FragmentRegBinding
    private val viewModel: MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentRegBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.buttReg.setOnClickListener {
            //viewModel.login(binding.username.text.toString(), binding.userPassword.text.toString())
            viewModel.login("toogolom@gmail.com", "waesrdtf")

        }

        viewModel.token.observe(this, Observer { token ->
            if (!token.isNullOrBlank()) {
                val intent = Intent(this, MainActivityFragment::class.java)
                startActivity(intent)
            }
        })
        viewModel.error.observe(this, Observer { error ->
            binding.errLog.text = error
        })
    }
}
