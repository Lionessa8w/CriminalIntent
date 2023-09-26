package com.bignerdranch.android.criminalintent

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.bignerdranch.android.criminalintent.database.CrimeDao
import com.bignerdranch.android.criminalintent.database.CrimeDataBase
import java.util.UUID

private const val DATABASE_NAME="crime-database"
class CrimeRepository private constructor(context: Context) {

    /*Функция Room.databaseBuilder()
    создает конкретную реализацию вашего абстрактного класса CrimeDatabase
     с использованием трех параметров. Сначала ему нужен объект Context,
      так как база данных обращается к файловой системе.
       Контекст приложения нужно передавать,
        так как синглтон, скорее всего, существует дольше,
         чем любой из ваших классов activity.
         Второй параметр — это класс базы данных,
         которую Room должен создать. Третий — имя файла базы данных, которую создаст Room.
     */
    private val database: CrimeDataBase=
        Room.databaseBuilder(
            context.applicationContext,
            CrimeDataBase::class.java,
            DATABASE_NAME
        ).build()
    private val crimeDao= database.crimeDao()

    fun getCrimes():List<Crime> =crimeDao.getCrime()
    fun getCrime(id:UUID): Crime?=crimeDao.getCrime(id)

    //синглтон, сущ только один экземпляр класса
    companion object {
        private var INSTANCE: CrimeRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }

        fun get(): CrimeRepository {
            return INSTANCE ?: throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}