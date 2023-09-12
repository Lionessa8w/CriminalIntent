package com.bignerdranch.android.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*запрос фрагмета с идентификатором контейнерного представления*/
        val currentFragment=supportFragmentManager.findFragmentById(R.id.fragment_container)
        //если фрагмент отсутствует, создаем новый фрагмент и добавляем его в список
        if (currentFragment==null){
            val fragment=CrimeListFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container,fragment)
                .commit()
        }
    }
}