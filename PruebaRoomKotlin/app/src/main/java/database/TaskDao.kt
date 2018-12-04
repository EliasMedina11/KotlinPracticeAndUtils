package database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Created by emedina on 11/4/18.
 */
@Dao
interface TaskDao {
    @Query("SELECT * FROM task_entity")
    fun getAllTasks(): MutableList<TaskEntity>

    @Insert
    fun addTask(taskEntity: TaskEntity):Long

    @Query("SELECT * FROM task_entity where id like :arg0")
    fun getTaskById(id: Long): TaskEntity
}