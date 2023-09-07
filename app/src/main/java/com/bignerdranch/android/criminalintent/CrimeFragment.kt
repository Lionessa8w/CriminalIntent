package com.bignerdranch.android.criminalintent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class CrimeFragment : Fragment() {
    private lateinit var crime: Crime
    private lateinit var titleField: EditText
    private lateinit var dateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()
    }

    //Здесь добавляем все виджеты
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_crime, container, false)

        titleField=view.findViewById(R.id.crime_title) as EditText//'as' небезопасное приведение типов

        dateButton=view.findViewById(R.id.crime_data) as Button
        dateButton.apply {
            text=crime.date.toString()
            isEnabled=false
        }

        return view
    }

    override fun onStart() {
        /*Установка слушателя в onStart() позволяет избежать такого поведения,
         так как слушатель подключается после восстановления состояния виджета.*/
        super.onStart()
        val titleWatcher=object : TextWatcher{

            override fun beforeTextChanged(sequence: CharSequence?,
                                           start: Int,
                                           count: Int,
                                           after: Int) {


            }
            //функция для создания заголовка, то что вводит пользователь преобразовывается в стринг
            override fun onTextChanged(sequence: CharSequence?,
                                       start: Int,
                                       before: Int,
                                       count: Int) {
                crime.title=sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) {

            }
        }
        titleField.addTextChangedListener(titleWatcher)
    }
}