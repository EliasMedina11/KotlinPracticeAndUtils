package database

import android.app.Application
import android.arch.persistence.room.Room

/**
 * Created by emedina on 12/4/18.
 */

class MisNotasApp: Application(){



    companion object {
        lateinit var database: TaskDatabase
    }

    override fun onCreate() {
        super.onCreate()
        MisNotasApp.database = Room.databaseBuilder(this,TaskDatabase::class.java,"tasks-db").build()
    }

}