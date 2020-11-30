package com.jxd.base.utils

/**
 * 减法
 */
operator fun Int?.minus(n: Int?) = (this ?: 0).minus(n ?: 0)

/**
 * 加法
 */
operator fun Int?.plus(n: Int?) = (this ?: 0).plus(n ?: 0)

/**
 * 乘法
 */
operator fun Int?.times(n: Int?): Int {
    if (this == null) return 0
    if (n == null) return 0
    return this.times(n)
}

/**
 * 除法
 */
operator fun Int?.div(n: Int?): Int {
    if (this == null) return 0
    if (n == null) return 0
    if (n == 0) return 0
    return this.div(n)
}

/**
 * 比较两个可能为空的Int值
 * 若当前值 和 比较值都为null ，则返回相同(0)
 * 若当前值为null，比较值不为null，则认为当前值<比较直(null < Value)，返回小于(<0)
 * 若当前值不为null，比较值为null，则认为当前值>比较值(value>null),返回大于(>0)
 * 都不为null，自行比较
 */
operator fun Int?.compareTo(other: Int?): Int {
    if (this == null && other == null) return 0
    if (this == null) return -1
    if (other == null) return 1
    return this.compareTo(other)
}

operator fun Double?.compareTo(other: Double?): Int = (this ?: 0.0).compareTo(other ?: 0.0)
