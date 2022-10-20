package com.ksharshembie.counter.model

import android.widget.Toast
import com.ksharshembie.counter.view.CounterView

class CounterModel {
    var count = 0

    fun increment(){
        count++
    }

    fun decrement(){
        count--
    }
}