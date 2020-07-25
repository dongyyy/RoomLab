package com.dongy.roomproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class MainViewModel(application: Application) : AndroidViewModel(application) { //Context 가 필요한 경우는 AndroidViewModel 을 사용해준다.
                                                                                // 생성자로 application 을 받아 넘기도록 한다.
    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "appDatabase"
    ).build()

    fun getAll() : LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    fun insert(todo: Todo) {
        db.todoDao().insert(todo)
    }

    fun delete() {
        db.todoDao().delete(db.todoDao().getLast())
    }
}