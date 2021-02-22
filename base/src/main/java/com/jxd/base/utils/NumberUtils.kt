package com.jxd.base.utils

import java.text.DecimalFormat

/**
 * 数字默认值
 */
inline fun <reified T : Number> T?.default(def: T = (0 as T)): T = this ?: def

/**
 * 格式化数字
 * 默认使用3位分割的计数法，999,999,999
 * ,###,##0.00 三位分割，保留两位小数，不足两位，补0
 */
fun Number.format(pattern: String = ",###,###"): String = DecimalFormat(pattern).format(this)
