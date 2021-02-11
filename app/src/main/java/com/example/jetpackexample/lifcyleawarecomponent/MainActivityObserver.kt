package com.example.jetpackexample.lifcyleawarecomponent

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MainActivityObserver(private val mContext: Context) : LifecycleObserver {
    private val TAG = "MainActivityObserver"

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun OnCreateEvent() {
        Log.i(TAG,"OnCreateEventCalled")
      //  Toast.makeText(mContext, "OnCreateEventCalled", Toast.LENGTH_SHORT).show()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun OnStartEvent() {
        Log.i(TAG,"OnStartEventCalled")

       // Toast.makeText(mContext, "OnStartEventCalled", Toast.LENGTH_SHORT).show()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun OnResumeEvent() {
        Log.i(TAG,"OnResumeEventCalled")

       // Toast.makeText(mContext, "OnResumeEventCalled", Toast.LENGTH_SHORT).show()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun OnPauseEvent() {
        Log.i(TAG,"OnPauseEventCalled")

       // Toast.makeText(mContext, "OnPauseEventCalled", Toast.LENGTH_SHORT).show()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun OnStopEvent() {
        Log.i(TAG,"OnStopEventCalled")

        //Toast.makeText(mContext, "OnStopEventCalled", Toast.LENGTH_SHORT).show()
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun OnDestroyEvent() {
        Log.i(TAG,"OnDestroyEventCalled")

       // Toast.makeText(mContext, "OnDestroyEventCalled", Toast.LENGTH_SHORT).show()
    }

}