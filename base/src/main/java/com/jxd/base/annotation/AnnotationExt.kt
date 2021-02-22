package com.jxd.base.annotation


inline fun <reified T : Annotation> Any.hasAnnotation() =
    javaClass.isAnnotationPresent(T::class.java)
