package com.list.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_remove.setOnClickListener {
            viewModel.setWord(edt_word.text.toString())
        }

        viewModel.list.observe(this, Observer {
            tv_list.text = ""
            it.map {  word ->
                tv_list.append("$word ")
            }
            edt_word.text.clear()
        })
    }
}
