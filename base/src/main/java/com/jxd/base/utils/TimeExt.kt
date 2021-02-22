package com.jxd.base.utils

import java.util.*

/**
 * 日期默认值[default]
 * 若不传，则默认是当前日期
 */
fun Date?.default(default: Date = Date(System.currentTimeMillis())): Date = this ?: default

