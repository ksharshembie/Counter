package com.ksharshembie.counter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ksharshembie.counter.databinding.ActivityMainBinding
import com.ksharshembie.counter.presenter.CounterPresenter
import com.ksharshembie.counter.view.CounterView

class MainActivity : AppCompatActivity(), CounterView {
    lateinit var binding: ActivityMainBinding
    var counter = 0
    private val presenter = CounterPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnIncrement.setOnClickListener {
                presenter.increment()
            }
            btnDecrement.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun showNewCount(count: Int) {

        if (count == 10) {
            binding.tvResult.text = count.toString()
            Toast.makeText(
                applicationContext,
                getString(R.string.congragulations),
                Toast.LENGTH_SHORT
            ).show()
        } else if (count == 15) {
            binding.tvResult.setTextColor(getColor(R.color.green))
            binding.tvResult.text = count.toString()
        } else {
            binding.tvResult.setTextColor(getColor(R.color.purple_500))
            binding.tvResult.text = count.toString()
        }

    }


}