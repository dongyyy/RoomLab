package com.dongy.roomproject

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
    @Query("SELECT * FROM Todo")
    fun getAll(): List<Todo>

    @Query("SELECT * FROM Todo ORDER BY id DESC LIMIT 1")
    fun getLast(): Todo

//    @Query(
//        "SELECT * FROM user WHERE first_name LIKE :first AND " +
//                "last_name LIKE :last LIMIT 1"
//    )
//    fun findByName(first: String, last: String): User

    @Insert
    fun insert(todo: Todo)

    @Delete
    fun delete(todo: Todo)
}
    