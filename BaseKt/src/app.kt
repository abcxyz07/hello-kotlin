import java.lang.IllegalArgumentException

/*
* Kotlin 中基础类型 数字、字符（不是数字）、布尔值、数组与字符串
*
* 1.数字
*   Byte 8 bit
*   Short 16bit
*   Int 32bit
*   Float 32bit
*   Long 64bit
*   Double 64bit
* */

/*
* == 比较值是否相等，=== 比较对象的内存地址是否相等
* 数字装箱后不一定保留同一性，但会保留相等性
* */
fun numberTest1(): Unit {
    val a: Int = 1000
    println(a === a)
    val boxedA: Int? = a
    val boxedB: Int? = a
    println(boxedA === boxedB)
}

/*
* 显示转换，小类型不能隐式地转换为大类型。即 Byte 不能隐式地转换为 Int 型变量，故需要显示转换
* 数字类型支持的转换
* toByte()
* toShort()
* toInt()
* toLong()
* toFloat()
* toDouble()
* toChar()
*
* 算数运算会有重载做适当转换 Long + Int => Long
* */
fun numberTest2(): Unit {
    val a: Int = 1
    val b: Long? = a.toLong()
    println(b)

    val c = 1L + 3
    println(c)
}

/*
* 位运算列表
* shl 有符号左移 <<
* shr 有符号右移 >>
* ushr 无符号右移 >>>
* and 位与
* or 位或
* xor 位异或
* inv 位非
* */
fun numberTest3(): Unit {
    val x = (1 shl 2) and 0x000FF000
    println(x)
}

/*
* Char 字符，不能直接当做数字
* 支持特殊字符转义，其他要用 Unicode 转义序列
* 需要可空引用时，数字、字符会被装箱，装箱不会保留同一性
* */
fun charTest(c: Char): Int {
    if (c !in '0'..'9'){
        throw IllegalArgumentException("out of range")
    }
    return c.toInt() - '0'.toInt();
}

/*
* 数组，Kotlin 中用 Array 表示，有 get set 函数以及 size 属性，还有其他函数
* 创建 arrayOf(1,2,3) arrayOfNulls 创建一个固定大小所有元素都为空的数组
*   Array(大小，函数)
* Kotlin 中的 Array 是类型不变的，Array<String> 不能赋值给 Array<Any>，但却可以使用 Array<outAny>
* 原生类型数组 ByteArray、ShortArray、IntArray 与 Array 无继承关系
* */

/*
* 字符串不可改变，字符可以使用 s[index] 访问，用 for 循环迭代字符串
* 字符串拼接，优先使用字符串模板
* 字符串字面值：转义字符串，类似 Java 字符串；原始字符串，使用 """ 分解符括起来，
* 默认使用 | 作为边界前缀
* 字符串模板：以 $ 开始，由一个简单的名字活着 {} 括起来的表达式
*
* */
fun stringTest(): Unit {
    val price = """
        ${'$'}9.99
    """.trimIndent()
    println(price)
}

/*
* if 一个表达式，类似 Java 中的三元运算符，有一个返回值
* */
fun ifTest1(x: Int, y: Int): String {
    return if (x > y) x.toString() else y.toString();
}

/*
* if 的分支可以是代码块，最后的表达式作为该块儿的值
* */
fun ifTest2(x: Int, y: Int): Any {
    return if (x > y) {
        println("choose x")
        x
    } else {
        println("choose y")
        y
    };
}

/*
* when 类似于 Java 中的 switch，将它的参数和所有的条件顺序比较，直到满足某个分支条件
* when 既可以作为语句，也可以作为表达式使用
*   1.当做语句使用，则忽略其他条件分支的值
*   2.当做表达式使用，则符合条件的值就是整个表达式的值（必须有 else 分支）
* 可做条件分支：
*   1.普通基本类型，可以用逗号隔开
*   2.任意表达式
*   3.使用 in !in 或者 is !is
* */
fun whenTest1(x: Int): Unit {
    when(x){
        1 -> println(1)
        2,3 -> println(x)
        whenTest1Inner(3) -> println(4)
        else -> {
            println("when else")
        }
    }
}

fun whenTest1Inner(x: Int): Int {
    return x + 1;
}

fun main(args: Array<String>){
    println("Hello world!")
    numberTest1()
    numberTest2()
    numberTest3()

    val a = charTest('7');
    println(a)

    stringTest()

    val ifTest1 = ifTest1(1,2);
    println(ifTest1)

    val ifTest2 = ifTest2(1,2);
    println(ifTest2)

    println("------------------------")
    whenTest1(1)
    whenTest1(2)
    whenTest1(3)
    whenTest1(4)
    whenTest1(5)
}