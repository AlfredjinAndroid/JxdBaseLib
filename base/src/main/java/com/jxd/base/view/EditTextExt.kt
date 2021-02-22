package com.jxd.base.utils

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText


/**
 * 隐藏软键盘
 */
fun EditText.hideInputSoft() {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    inputManager?.hideSoftInputFromWindow(windowToken, 0)
}

/**
 * 展示软键盘
 */
fun EditText.showInputSoft() {
    requestFocus()
    postDelayed({
        val inputManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        inputManager?.showSoftInput(this, 0)
    }, 500)
}
