package com.me.kotlin

/**
 * 为String添加-、*、/运算符
 */

operator fun String.minus(right: Any?): String = this.replace(right.toString(), "")

/**
 * joinToString：循环right次，拼接的字符串为""，重复添加字符串本身
 */
operator fun String.times(right: Int): String = (0..right).joinToString("") { this }

/**
 * windowed方法：<br/>
 * 1.创建一个滑块，大小为right.length
 * 2.每次移动步长为1
 * 3.满足条件lambda的条件时添加到list
 * count方法：统计it为true的个数
 */
operator fun String.div(right: Any?): Int = when (right) {
    is Int -> 0
    is String -> this.windowed(right.length, 1) {
        it == right
    }.count { it }
    else -> 0
}

fun main() {
    val str = "Hello World"

    println(str - "l")
    println(str * 5)
    println(str / 10)
    println(str / "l")
}