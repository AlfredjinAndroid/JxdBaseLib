package com.jxd.base.view

import android.view.View

/**
 * 根据[bool]确定是否要展示View,true 展示，false 不展示
 * 根据[reserve]确定是否要完全隐藏，true表示占位[View.INVISIBLE]，不完全隐藏，false 表示完全隐藏[View.GONE]
 */
fun View.show(bool: Boolean, reserve: Boolean = false) =
    if (bool) {
        visible()
    } else {
        if (reserve) inVisible()
        else gone()
    }

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.inVisible() {
    visibility = View.INVISIBLE
}
