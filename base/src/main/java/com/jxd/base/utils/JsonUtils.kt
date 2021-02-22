@file:Suppress("IMPLICIT_CAST_TO_ANY")

package com.jxd.base.utils

import org.json.JSONArray
import org.json.JSONObject

/**
 * 根据key 直接获取 JSONObject 值
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


/**
 * JSONArray 每个元素遍历到[action],并返回元素
 */
inline fun <reified T> JSONArray.forEach(action: (T) -> Unit) {
    for (i in 0 until length()) {
        action.invoke(get(i) as T)
    }
}

/**
 * JSONArray 每个元素遍历到[action],并返回元素和元素的位置
 */
inline fun <reified T> JSONArray.forEachIndexed(action: (index: Int, T) -> Unit) {
    for (i in 0 until length()) {
        action.invoke(i, get(i) as T)
    }
}

inline fun <reified T> List<T>.toJsonArray(): JSONArray {
    val ja = JSONArray()
    forEach { e ->
        ja.put(e)
    }
    return ja
}