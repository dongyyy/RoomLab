package com.dongy.roomproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.dongy.roomproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this //liveData 활용하기 위한 작업. liveData 관찰 시 마다 xml이 refresh 하도록 설

        val viewModel: MainViewModel by viewModels()
        binding.viewmodel = viewModel

//        //UI 갱신
//        viewModel.getAll().observe(this, Observer { todos ->
//            result_text.text = todos.toString()
//        })
//
//        add_button.setOnClickListener {
//            lifecycleScope.launch(Dispatchers.IO) {
//                viewModel.insert(Todo(todo_edit.text.toString()))
//            }
//        }
//
//        delete_button.setOnClickListener {
//            lifecycleScope.launch(Dispatchers.IO) {
//                viewModel.delete()
//            }
//        }
    }
}