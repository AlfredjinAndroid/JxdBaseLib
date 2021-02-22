package com.jxd.base.storage.sp

import android.content.Context
import android.content.SharedPreferences

/**
 * SP 工具类 适用于SP扩展 本地key-value存储
 *
 */
object SpUtils {
    object SpUtils {
        private var CONFIG_NAME = "Lit_Live_Client"
        lateinit var prefs: SharedPreferences


        fun onInit(
            context: Context,
            configName: String = CONFIG_NAME
        ) {
            prefs = context.getSharedPreferences(configName, Context.MODE_PRIVATE)
        }

        fun saveInt(key: String, value: Int) {
            prefs.edit().apply {
                putInt(key, value)
            }.apply()
        }

        fun saveLong(key: String, value: Long) {
            prefs.edit().apply {
                putLong(key, value)
            }.apply()
        }

        fun saveString(key: String, value: String) {
            prefs.edit().apply {
                putString(key, value)
            }.apply()
        }

        fun saveFloat(key: String, value: Float) {
            prefs.edit().apply {
                putFloat(key, value)
            }.apply()
        }

        fun saveBoolean(key: String, value: Boolean) {
            prefs.edit().apply { putBoolean(key, value) }.apply()
        }

        fun saveStringSet(key: String, value: Set<String>) {
            prefs.edit().apply { putStringSet(key, value) }.apply()
        }


        inline fun <reified T> getValue(key: String, def: T? = null): T {
            with(prefs) {
                return when (T::class) {
                    Int::class -> getInt(key, if (def is Int) def else 0)
                    String::class -> getString(key, if (def is String) def else "")
                    Long::class -> getLong(key, if (def is Long) def else 0L)
                    Float::class -> getFloat(key, if (def is Float) def else 0.0f)
                    Boolean::class -> getBoolean(key, if (def is Boolean) def else false)
                    else -> throw IllegalArgumentException("SharedPreferences 类型错误")
                } as T
            }
        }

        fun clear(context: Context) {
            initDefault(context)
            prefs.edit().clear().apply()
        }

        fun remove(context: Context, key: String) {
            initDefault(context)
            prefs.edit().remove(key).apply()
        }

        fun remove(key: String) {
            prefs.edit().remove(key).apply()
        }

        fun getSharedPreferences(context: Context): SharedPreferences {
            initDefault(context)
            return prefs
        }

        fun contains(context: Context? = null, key: String): Boolean {
            context?.also { ctx ->
                initDefault(ctx)
            }
            return prefs.contains(key)
        }

        fun initDefault(context: Context) {
            if (!::prefs.isInitialized) {
                prefs = context.getSharedPreferences(CONFIG_NAME, Context.MODE_PRIVATE)
            }
        }

    }
}


fun Context.clear() {
    SpUtils.SpUtils.clear(context = this)
}

fun Context.remove(key: String) {
    SpUtils.SpUtils.remove(context = this, key = key)
}