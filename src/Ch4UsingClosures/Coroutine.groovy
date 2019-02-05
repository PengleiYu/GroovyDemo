/**
 * 4.6 闭包与协程
 */
/**
 * 控制流在iterate方法和闭包中来回转移
 */
def iterate(int n, closure) {
    1.upto(n) {
        println "In iterate with value $it"
        closure(it)
    }
}

println "Calling iterate"
int total = 0
iterate(4) {
    total += it
    println "In closure total so far is $total"
}
println "Down"
