package com.example.jetpackexample.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.jetpackexample.R
import kotlinx.android.synthetic.main.activity_main_live_data.*

class MainActivityLiveData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_live_data)

        val model = ViewModelProviders.of(this).get(DataGeneratorViewModel::class.java)

        model.getNumber()?.observe(this, Observer {
            tv_number.setText(it)
        })

        btn_update.setOnClickListener {
            model.createNumber()
        }

    }
}
