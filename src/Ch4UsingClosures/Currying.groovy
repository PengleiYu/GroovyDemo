/**
 * 4.7 科里化闭包
 */
def tellFortunes(Closure closure) {
    Date date = new Date("09/20/2012")
//    closure date, "Your day is filled with ceremony"
//    closure date, "They`re features, not bugs"
    // 正向科里化
    postFortune = closure.curry(date)
    postFortune "Your day is filled with ceremony"
    postFortune "They`re features, not bugs"
    // 一次多个参数的科里化
    postFortune = closure.curry(date, "Hello world")
    postFortune()
    // 逆向科里化
    postFortune = closure.rcurry("Hello rCurry")
    postFortune date
    // 指定位置的科里化
    postFortune = closure.ncurry(1, "Hello nCurry")
    postFortune date
}

tellFortunes() { data, fortune ->
    println "Fortune for $data is '$fortune'"
}
