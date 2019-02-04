/**
 * 4.1 闭包的便利性
 */

/**
 * 传统方式
 */
def sqr(n) {
    squared = []
    for (int i = 2; i <= n; i += 2) {
        squared << i**2
    }
    squared
}

println sqr(10)

/**
 * Groovy方式
 */
static def pickEvent(n, block) {
    for (int i = 2; i <= n; i += 2) {
        block(i)
    }
}

//pickEvent(10) { println it }
int total = 0
pickEvent(10) { total += it }
println total
int product = 1
pickEvent(10) { product *= it }
println product
