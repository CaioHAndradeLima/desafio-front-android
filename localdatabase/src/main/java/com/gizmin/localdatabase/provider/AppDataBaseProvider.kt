package com.gizmin.localdatabase.provider

import android.content.Context
import androidx.room.Room
import com.gizmin.localdatabase.AppDatabase

object AppDataBaseProvider {

    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, DB_NAME
        ).fallbackToDestructiveMigration()
         .build()
    }

    private const val DB_NAME = "pokemon"
}