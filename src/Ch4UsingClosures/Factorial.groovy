/**
 * 4.10 使用尾递归编写程序
 */

/**
 * 简单斐波那契数列
 */
BigInteger factorial(BigInteger number) {
    if (number == 1) 1 else number * factorial(number - 1)
}

try {
    println "factorial of 5 is ${factorial(5)}"
    println "Number of bits in the result is ${factorial(5000).bitCount()}"
} catch (Throwable ex) {
    println "Caught ${ex.class.name}"
}

/**
 * 尾递归版本斐波那契
 */
factorial2 = { int number, BigInteger theFactorial ->
    number == 1 ? theFactorial : factorial2.trampoline(number - 1, number * theFactorial)
}.trampoline()
println "factorial of 5 is ${factorial2(5, 1)}"
println "Number of bits in the result is ${factorial2(5000, 1).bitCount()}"

/**
 * 单参数版本的尾递归斐波那契
 * @param factorialFor
 * @return
 */
def factorial3(int factorialFor) {
    def tailFactorial
    tailFactorial = { int number, BigInteger theFactorial = 1 ->
        number == 1 ? theFactorial :
                tailFactorial.trampoline(number - 1, number * theFactorial)
    }.trampoline()
    tailFactorial(factorialFor)
}

println "factorial of 5 is ${factorial3(5)}"
println "Number of bits in the result is ${factorial3(5000).bitCount()}"
