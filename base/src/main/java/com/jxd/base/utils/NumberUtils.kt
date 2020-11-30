package com.jxd.base.utils

inline fun <reified T : Number> T?.default(def: T = (0 as T)): T = this ?: def
