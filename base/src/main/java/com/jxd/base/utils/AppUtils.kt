package com.jxd.base.utils

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

/**
 * 获取资源系统颜色值
 */
fun Context.getMyColor(@ColorRes cid: Int) = ContextCompat.getColor(this, cid)

/**
 * 获取设备高度
 */
val Context.heightPx: Int
    get() {
        val height = applicationContext.resources.displayMetrics.heightPixels
        if (height <= 0) return 1080
        return height
    }

/**
 * 获取设备宽度
 */
val Context.widthPx: Int
    get() {
        val widthPixels = applicationContext.resources.displayMetrics.widthPixels
        if (widthPixels <= 0) return 1080
        return widthPixels
    }


/**
 * 转为Float类型dp值
 */
val Number.dpf
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )

/**
 * 转为Int 类型 dp值
 */
val Number.dpi
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).toInt()

/**
 * 转为Float类型 sp值
 */
val Number.spf
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )

/**
 * 转为Int类型Sp值
 */
val Number.spi
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).toInt()

