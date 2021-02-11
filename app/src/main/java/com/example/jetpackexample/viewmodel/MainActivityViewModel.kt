package com.example.jetpackexample.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.jetpackexample.R
import kotlinx.android.synthetic.main.activity_main_view_model.*

class MainActivityViewModel : AppCompatActivity() {

    //ViewModel is not same as
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view_model)

        //val myNumber = DataGenerator().getNumber()
        val dataGenerator=ViewModelProviders.of(this).get(DataGeneratorViewModel::class.java)
        tv_number.setText(dataGenerator.getNumber())
    }
}
