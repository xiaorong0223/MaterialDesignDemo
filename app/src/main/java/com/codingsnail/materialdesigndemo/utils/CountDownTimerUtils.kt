package com.codingsnail.materialdesigndemo.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.CountDownTimer
import android.support.v4.content.ContextCompat
import android.widget.TextView

import com.codingsnail.materialdesigndemo.R

/**
 * Created by Snail on 3/1/2018 3:41 PM
 * Contact with slowsnail0223@gmail.com
 */
class CountDownTimerUtils(private val mTextView: TextView,private val mContext: Context, millisInFuture: Long, countDownInterval: Long) : CountDownTimer(millisInFuture, countDownInterval) {

    @SuppressLint("SetTextI18n")
    override fun onTick(millisUntilFinished: Long) {
        mTextView.isClickable = false //设置不可点击
        mTextView.text = "已发送(${ millisUntilFinished / 1000}秒)" //设置倒计时时间
        mTextView.setTextColor(ContextCompat.getColor(mContext, R.color.color_C3C3C3))
    }

    /**
     * 倒计时完成后调用
     */
    override fun onFinish() {
        mTextView.setTextColor(ContextCompat.getColor(mContext, R.color.main_blue))
        mTextView.text = "重新获取验证码"
        mTextView.isClickable = true//重新获得点击
    }
}