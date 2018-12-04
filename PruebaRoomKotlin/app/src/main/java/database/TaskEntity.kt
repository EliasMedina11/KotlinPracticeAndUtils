package database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by emedina on 11/4/18.
 */
@Entity(tableName = "task_entity")

data class TaskEntity(
        @PrimaryKey(autoGenerate = true)
        var id:Int = 0,
        var name:String = "",
        var isDone:Boolean = false
)