package com.dongy.roomproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "appDatabase"
        )
            .allowMainThreadQueries()
            .build()

        result_text.text = db.todoDao().getAll().toString()

        add_button.setOnClickListener {
            db.todoDao().insert(Todo(todo_edit.text.toString()))
            result_text.text = db.todoDao().getAll().toString()
        }

        delete_button.setOnClickListener {
            val list = db.todoDao().getAll()
            if(list.isNotEmpty()){
                db.todoDao().delete(db.todoDao().getLast())
            }
            result_text.text = list.toString()
        }
    }
}