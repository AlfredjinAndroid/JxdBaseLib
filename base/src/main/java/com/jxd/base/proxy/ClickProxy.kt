package com.jxd.base.proxy

import android.view.View

/**
 * 点击代理
 * 防止重复点击
 */
class ClickProxy(private val delay: Long, private val l: ((View) -> Unit)) : View.OnClickListener {
    private var mLastClick = 0L

    override fun onClick(v: View) {
        val mCurrentTime = System.currentTimeMillis()
        if (mCurrentTime - mLastClick >= delay) {
            l.invoke(v)
            mLastClick = mCurrentTime
        }
    }
}

fun View.clickProxy(delay: Long = 500L, l: ((View) -> Unit)) {
    this.setOnClickListener(ClickProxy(delay, l))
}