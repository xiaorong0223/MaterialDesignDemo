package com.codingsnail.materialdesigndemo.view

import CommonUtils
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.codingsnail.materialdesigndemo.R
import kotlinx.android.synthetic.main.activity_text_input_login.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by Snail on 3/1/2018 11:31 AM
 * Contact with slowsnail0223@gmail.com
 */
class TextInputLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_input_login)
        initView()
    }

    private fun initView() {

         et_phone.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                text_input_layout_phone.isErrorEnabled = false
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        et_pwd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                text_input_layout_pwd.isErrorEnabled = false
            }

            override fun afterTextChanged(s: Editable) {
            }
        })

        btn_login.onClick {
            invalidLogin()
        }
    }


    private fun invalidLogin() {


        if (!CommonUtils.verifyMobile(et_phone!!.text.toString().trim())) {
            text_input_layout_phone.error = getString(R.string.error_field_phone)
            return
        }
        if (!CommonUtils.verifyLoginPwd(et_pwd!!.text.toString().trim())) {
            text_input_layout_pwd.error = getString(R.string.error_incorrect_password)
            return
        }
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
    }

    companion object {

        fun startActivity(context: Context) {
            context.startActivity(Intent(context, TextInputLoginActivity::class.java))
        }
    }
}

