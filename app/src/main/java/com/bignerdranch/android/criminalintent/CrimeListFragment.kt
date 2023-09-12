package com.bignerdranch.android.criminalintent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

private const val TAG="CrimeListFragment"

class CrimeListFragment: Fragment() {

    private val crimeListViewModel:CrimeListViewModel by lazy {
        ViewModelProviders.of(this)[CrimeListViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total crimes: ${crimeListViewModel.crimes.size}")
    }
    companion object{
        //для activity, для получения экземпляра фрагмента
        fun newInstance():CrimeListFragment{
            return CrimeListFragment()
        }
    }
}