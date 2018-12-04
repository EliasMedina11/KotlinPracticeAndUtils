package database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by emedina on 12/4/18.
 */
@Database(entities = arrayOf(TaskEntity::class),version = 1)

abstract class TaskDatabase : RoomDatabase () {
    abstract fun taskDao(): TaskDao
}