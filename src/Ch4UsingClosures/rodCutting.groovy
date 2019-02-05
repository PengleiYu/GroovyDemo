/**
 * 4.11 使用记忆化改进性能
 * 空间换时间
 */

import groovy.transform.Immutable

// 统计方法运行时间
def timeIt(length, closure) {
    long start = System.nanoTime()
    println "Max revenue for $length is ${closure(length)}"
    long end = System.nanoTime()
    println "Time taken ${(end - start) / 1.0e9} seconds"
}

// 记录分割方案与总价值
@Immutable
class RevenueDetails {
    int revenue
    ArrayList splits
}

//def cutRod(prices, length) {
cutRod = { prices, length ->
    println "cutRod"
    if (length == 0)
        new RevenueDetails(0, [])
    else {
        def maxRevenueDetails = new RevenueDetails(Integer.MIN_VALUE, [])
        for (rodSize in 1..length) {
            def revenueFromSecondHalf = cutRod(prices, length - rodSize)
            def potentialRevenue = new RevenueDetails(
                    prices[rodSize] + revenueFromSecondHalf.revenue,
                    revenueFromSecondHalf.splits + rodSize)
            if (potentialRevenue.revenue > maxRevenueDetails.revenue)
                maxRevenueDetails = potentialRevenue
        }
        maxRevenueDetails
    }
}.memoize()//仅仅添加一个方法即可
//.memoizeAtLeast(100)//限定记忆空间大小
//.memoizeAtMost(100)
//.memoizeBetween(10,100)

/**
 * 动态规划问题描述：
 * 每个杆子长度都有一个对应的价格，现有一根杆子可以进行分割，求总价值最高的分割方案
 */
def rodPrices = [0, 1, 3, 4, 5, 8, 9, 11, 12, 14,
                 15, 15, 16, 18, 19, 15, 20, 21, 22, 24,
                 25, 24, 26, 28, 29, 35, 37, 38, 39, 40]
def desiredLength = 27

timeIt desiredLength, { length -> cutRod(rodPrices, length) }
