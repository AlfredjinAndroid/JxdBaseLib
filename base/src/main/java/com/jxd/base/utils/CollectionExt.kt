package com.jxd.base.utils

/*
对集合操作的扩展
 */



/*
处理 reduce ， 若集合为空，返回null
reduce 是对集合的操作
依次将所提供的操作应用于集合元素并返回累积的结果
操作有两个参数：先前的累积值和集合元素。
 */
inline fun <S, T : S> Iterable<T>.reduceOrNull(operation: (acc: S, T) -> S): S? {
    val iterator = this.iterator()
    if (!iterator.hasNext()) return null
    var accumulator: S = iterator.next()
    while (iterator.hasNext()) {
        accumulator = operation(accumulator, iterator.next())
    }
    return accumulator
}


/**
 * 集合合并操作
 * 将当前集合 + [elements] 并返回新的集合
 * 由于原Kt集合只允许可变集合进行合并，所以扩展此方法
 */
fun <T, E : T> List<T>.addAll(elements: Collection<E>): List<T> {
    val result = toMutableList()
    result.addAll(elements)
    return result
}

/**
 * 集合替换操作
 * 将当前集合中的旧值[old]替换为新的值[new]
 * 如果集合不存在[old]，则直接添加到集合中
 */
inline fun <T> List<T>.replace(old: T, new: T): List<T> {
    val result = if (this is MutableList<T>) this else toMutableList()
    val index = result.indexOf(old)
    if (index < 0) { // 不存在旧的
        result += new
    } else {
        result[index] = new
    }
    return result
}