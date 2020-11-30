@file:Suppress("IMPLICIT_CAST_TO_ANY")

package com.jxd.base.utils

import org.json.JSONArray
import org.json.JSONObject

/*
getBoolean()
getInt()
getDouble()
getJSONArray()
getJSONObject()
getLong()
getString()
get()
 */
inline fun <reified T> JSONObject.getValueOrNull(key: String): T? {
    if (!has(key)) return null
    return try {
        when (T::class) {
            Int::class -> getInt(key)
            Boolean::class -> getBoolean(key)
            Double::class -> getDouble(key)
            JSONArray::class -> getJSONArray(key)
            JSONObject::class -> getJSONObject(key)
            Long::class -> getLong(key)
            String::class -> getString(key)
            else -> get(key)
        } as T
    } catch (e: Exception) {
        null
    }
}