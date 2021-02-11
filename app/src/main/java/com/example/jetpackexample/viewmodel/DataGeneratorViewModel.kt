package com.example.jetpackexample.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import java.util.*

//Remove override class viewMode and also uncomment the MainActivityViewModel commented part
//Rotate the screen the number display is change
//If we use ViewModel we retain same number after the screen configuration change
class DataGeneratorViewModel : ViewModel() {

    private var myRandomNumber: String? = null

    fun getNumber(): String? {
        if (myRandomNumber == null) {
            createNumber()
        }
        return myRandomNumber
    }

    private fun createNumber() {

        myRandomNumber = "Number: " + Random().nextInt(1000 - 1) + 1
    }

    // onCleared is called to clear resources and freeup memory task
    override fun onCleared() {
        super.onCleared()
        Log.i("Main", "Cleared")
    }
}