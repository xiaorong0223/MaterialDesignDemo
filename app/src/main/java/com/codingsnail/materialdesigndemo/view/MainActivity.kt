package com.codingsnail.materialdesigndemo.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.codingsnail.materialdesigndemo.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        tv_text_input_login.onClick {
            TextInputLoginActivity.Companion.startActivity(this@MainActivity)
        }

        tv_text_input_register.onClick {
            TextInputRegisterActivity.Companion.startActivity(this@MainActivity)
        }
    }
}
