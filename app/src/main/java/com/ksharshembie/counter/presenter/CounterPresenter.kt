package com.ksharshembie.counter.presenter

import android.app.Application
import com.ksharshembie.counter.MainActivity
import com.ksharshembie.counter.R
import com.ksharshembie.counter.model.CounterModel
import com.ksharshembie.counter.view.CounterView

class CounterPresenter : Application() {

    var model = CounterModel()
    lateinit var view: CounterView

    fun increment() {
        model.increment()
        textLogic()
        view.showNewCount(model.count)
    }

    fun attachView(view: CounterView) {
        this.view = view
    }

    fun decrement() {
        model.decrement()
        textLogic()
        view.showNewCount(model.count)
    }

    fun textLogic(){
        if (model.count == 10) view.showToast()
        if (model.count == 15) view.changeColor(R.color.green) else view.changeColor(R.color.purple_500)
    }

}