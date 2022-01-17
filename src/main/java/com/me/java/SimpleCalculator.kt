package com.me.java


/**
 * 简易四则运算器程序
 * Input: 3 * 4
 * Output: 12
 */
fun main(args: Array<String>) {

    // 直接返回
    if (args.size != 3) {
        return showHelp()
    }

    // 初始化操作符map
    val operators = mapOf(
        "+" to ::plus,
        "-" to ::minus,
        "*" to ::times,
        "/" to ::divide,
    )
    try {
        // 获取要操作的函数
        // ?: 当为空执行的操作
        val doCalc = operators[args[1]] ?: return showHelp()
        // 调用方法，并需要显示类型转换
        val output = doCalc(args[0].toInt(), args[2].toInt())

        // jointToString为按指定分隔符（默认逗号）将数组拆分
        println(
            """
            Input: ${args.joinToString(" ")}
            Output: $output
        """.trimIndent()
        )
    } catch (e: Exception) {
        return showHelp()
    }

}

fun plus(x: Int, y: Int): Int {
    return x + y
}

fun minus(x: Int, y: Int): Int {
    return x - y
}

fun times(x: Int, y: Int): Int {
    return x * y
}

fun divide(x: Int, y: Int): Int {
    return x / y
}

fun showHelp() {
    println(
        """
        ERROR!!!
        SimpleCalculator:
            Input: 3 * 4
            Output: 12
    """.trimIndent()
    )
}
