package com.jxd.base.utils

fun String?.default(def: String = "") = if (this.isNullOrEmpty()) def else this
fun String?.isNotNullOrEmpty(): Boolean {
    if (this == null) return false
    if (isEmpty()) return false
    return true
}
