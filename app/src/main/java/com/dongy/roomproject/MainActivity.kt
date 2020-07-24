package com.dongy.roomproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "appDatabase"
        )
            .build()

        db.todoDao().getAll().observe(this, Observer { todos ->
            result_text.text = todos.toString()
        })

        add_button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                db.todoDao().insert(Todo(todo_edit.text.toString()))
            }
        }

        delete_button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                db.todoDao().delete(db.todoDao().getLast())
            }
        }
    }

}