package com.ksharshembie.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ksharshembie.counter.databinding.ActivityMainBinding
import com.ksharshembie.counter.presenter.CounterPresenter
import com.ksharshembie.counter.view.CounterView
import kotlinx.coroutines.processNextEventInCurrentThread

class MainActivity : AppCompatActivity(), CounterView {
    lateinit var binding: ActivityMainBinding
    var counter = 0
    private val presenter = CounterPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClickers()
    }

    private fun initClickers() {
        with(binding){
            btnIncrement.setOnClickListener {
                presenter.increment()
            }
            btnDecrement.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun showNewCount(count: Int) {
        binding.tvResult.text = count.toString()
    }


}