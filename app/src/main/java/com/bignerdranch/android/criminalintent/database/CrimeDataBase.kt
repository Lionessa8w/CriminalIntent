package com.bignerdranch.android.criminalintent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bignerdranch.android.criminalintent.Crime

@Database(entities = [Crime::class], version = 1)//указываем сущность БД
@TypeConverters(CrimeTypeConverters::class)// указываем конвертер БД
abstract class CrimeDataBase : RoomDatabase() {
    abstract fun crimeDao(): CrimeDao
}