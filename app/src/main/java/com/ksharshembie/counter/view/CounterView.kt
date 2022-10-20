package com.ksharshembie.counter.view

import android.widget.Toast




interface CounterView {
    fun showNewCount(count: Int)
    fun showToast()
    fun changeColor(color: Int)
}