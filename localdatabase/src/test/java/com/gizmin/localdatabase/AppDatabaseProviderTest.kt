package com.gizmin.localdatabase

import androidx.room.Room
import org.robolectric.RuntimeEnvironment

private val database = Room.inMemoryDatabaseBuilder(
    RuntimeEnvironment.application.applicationContext,
    AppDatabase::class.java)
    .allowMainThreadQueries()
    .build()

fun provideDataBaseTest() = database