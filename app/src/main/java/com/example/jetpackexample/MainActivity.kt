package com.example.jetpackexample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpackexample.lifcyleawarecomponent.MainActivityObserver
import com.example.jetpackexample.livedata.MainActivityLiveData
import com.example.jetpackexample.roomdatabase.MainActivityRoom
import com.example.jetpackexample.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_lifecycle_aware.setOnClickListener {

            val intent = Intent(this, MainActivityObserver::class.java)
            startActivity(intent)
        }

        btn_view_model.setOnClickListener {
            val intent = Intent(this, MainActivityViewModel::class.java)
            startActivity(intent)
        }

        btn_live_data.setOnClickListener {
            val intent = Intent(this, MainActivityLiveData::class.java)
            startActivity(intent)
        }

        btn_room.setOnClickListener {
            val intent = Intent(this, MainActivityRoom::class.java)
            startActivity(intent)
        }
    }


}
