package com.codingsnail.materialdesigndemo.view

import CommonUtils
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import com.codingsnail.materialdesigndemo.R
import com.codingsnail.materialdesigndemo.utils.CountDownTimerUtils
import kotlinx.android.synthetic.main.activity_text_input_register.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by Snail on 3/1/2018 11:31 AM
 * Contact with slowsnail0223@gmail.com
 */
class TextInputRegisterActivity : AppCompatActivity() {

    private var countDownTimer: CountDownTimerUtils? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_input_register)
        initView()
    }

    private fun initView() {

        et_user_phone.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                text_input_layout_phone.isErrorEnabled = false
            }

            override fun afterTextChanged(editable: Editable) {
                if (!TextUtils.isEmpty(et_user_phone.text.toString().trim())) {
                    tv_get_code.setTextColor(ContextCompat.getColor(applicationContext, R.color.main_blue))
                } else {
                    tv_get_code.setTextColor(ContextCompat.getColor(applicationContext, R.color.color_C3C3C3))
                }
            }
        })

        et_auth_code.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                text_input_layout_code.isErrorEnabled = false
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        et_user_paw.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                text_input_layout_pwd.isErrorEnabled = false
            }

            override fun afterTextChanged(s: Editable) {
            }
        })

        countDownTimer = CountDownTimerUtils(tv_get_code, 60000, 1000)

        tv_get_code.onClick {
            clickGetCode()
        }

        btn_commit.onClick {
            clickRegister()
        }
    }

    private fun clickGetCode() {

        if (!CommonUtils.verifyMobile(et_user_phone.getText().toString().trim({ it <= ' ' }))) {
            text_input_layout_phone.error = getString(R.string.error_field_phone)
            return
        }
        countDownTimer!!.start()
    }

    private fun clickRegister() {

        if (!CommonUtils.verifyMobile(et_user_phone.text.toString().trim())) {
            text_input_layout_phone.error = getString(R.string.error_field_phone)
            return
        }
        if (et_auth_code.text.toString().trim().length != 4) {
            text_input_layout_code.error = getString(R.string.error_incorrect_code)
            return
        }
        if (!CommonUtils.verifyLoginPwd(et_user_paw.text.toString().trim())) {
            text_input_layout_pwd.error = getString(R.string.error_incorrect_password)
            return
        }
    }

    companion object {

        fun startActivity(context: Context) {
            context.startActivity(Intent(context, TextInputRegisterActivity::class.java))
        }
    }
}
