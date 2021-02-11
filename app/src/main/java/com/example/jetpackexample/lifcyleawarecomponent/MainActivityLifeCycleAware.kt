package com.example.jetpackexample.lifcyleawarecomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.jetpackexample.R

class MainActivityLifeCycleAware : AppCompatActivity() {

    private val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_life_cycle_aware)
        Log.i(TAG,"OnCreateOwner")
        lifecycle.addObserver(MainActivityObserver(this))
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG,"OnStartOwner")


    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG,"OnResumeOwner")

    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG,"OnPauseOwner")

    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG,"OnStopOwner")

    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG,"OnRestartOwner")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"OnDestroyOwner")

    }
}
