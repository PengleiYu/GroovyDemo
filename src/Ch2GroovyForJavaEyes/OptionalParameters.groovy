/**
 * 2.4 可选参
 */
def log(x, base = 10) {
    Math.log(x) / Math.log(base)
}

println log(1024)
println log(1024, 10)
println log(1024, 2)

/**
 * 末尾的数组形参视为可选参
 * Groovy会把末尾的实参收集起来赋给数组形参
 */
def task(name, String[] details) {
    println "$name - $details"
}

task 'Call', '123-456-7890'
task 'Call', '123-456-7890', '231-546-0987'
task 'Check Mail'
