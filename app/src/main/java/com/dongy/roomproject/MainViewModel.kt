package com.dongy.roomproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) { //Context 가 필요한 경우는 AndroidViewModel 을 사용해준다.
                                                                                // 생성자로 application 을 받아 넘기도록 한다.
    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "appDatabase"
    )//.allowMainThreadQueries() //임시로 사용
    .build()
    //DB는 file I/O이기 때문에 Android OS 정책 상 Background에서 처리해주어야한다.
    //db객체를 통해 아래 메소드들을 호출하는 부분에서 Coroutine을 사용해야 한다.

    var todos : LiveData<List<Todo>>
    var newTodo : String = "" //todo_edit와 양방향 binding

    init {
        todos = getAll()
    }

    private fun getAll() : LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    fun insert(todo: String) {
        viewModelScope.launch(Dispatchers.IO) {
            db.todoDao().insert(Todo(todo))
        }
    }

    fun delete() {
        viewModelScope.launch(Dispatchers.IO) {
            db.todoDao().delete(db.todoDao().getLast())
        }
    }
}