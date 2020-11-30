package com.jxd.base.utils

fun String?.default(def: String = "") = if (this.isNullOrEmpty()) def else this