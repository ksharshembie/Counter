package com.ksharshembie.counter.presenter

import com.ksharshembie.counter.model.CounterModel
import com.ksharshembie.counter.view.CounterView

class CounterPresenter {

    var model = CounterModel()
    lateinit var view: CounterView

    fun increment(){
        model.increment()
        view.showNewCount(model.count)
    }

    fun attachView(view: CounterView){
        this.view = view
    }

    fun decrement(){
        model.decrement()
        view.showNewCount(model.count)
    }
}