/**
 * 5.2 GString的惰性求值
 * GString绑定的是变量引用的对象，仅仅修改引用并不能改变GString结果
 * 修改引用对象内容才能改变GString输出，通常是让GString绑定一个无参闭包
 *
 * GString表达式求值过程：若包含一个变量则将其打印到一个Writer（通常是StringWriter）；
 * 如果包含一个闭包，则该闭包会被调用，若该闭包接收一个参数，则GString将Writer对象发送给它；
 * 若闭包不接收参数，则简单调用该闭包，若闭包接收多个参数，则调用失败，抛出异常。
 */
price = 684.71
company = 'Google'

//companyClosure = { it.write(company) }//GString中引用闭包会传入StringWriter对象
//priceClosure = { it.write("$price") }
//companyClosure = { -> company }//无参闭包
//priceClosure = { -> price }
//quote = "Today $company stock closed at $price"//不可直接引用
//quote = "Today $companyClosure stock closed at $priceClosure"
quote = "Today ${-> company} stock closed at ${-> price}"//终极版本
println quote

stocks = [Apple: 663.01, Microsoft: 30.95]
stocks.each { key, value ->
    company = key
    price = value
    println quote
}
