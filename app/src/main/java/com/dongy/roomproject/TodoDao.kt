package com.dongy.roomproject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
    @Query("SELECT * FROM Todo")
    fun getAll(): LiveData<List<Todo>>

    @Query("SELECT * FROM Todo ORDER BY id DESC LIMIT 1")
    fun getLast(): Todo

    @Insert
    fun insert(todo: Todo)

    @Delete
    fun delete(todo: Todo)
}
    