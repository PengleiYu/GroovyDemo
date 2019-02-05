/**
 * 5.1 字符串字面常量
 */
println 'He said, "That is Groovy"'//字面常量可包含双引号

str = 'A string'
println str.getClass().name//单引号创建对象的类型

value = 25
println 'The value is ${value}'//单引号内部表达式不会被求值

str = 'hello'
println str[2]
try {
    str[2] = '!'
} catch (ex) {
    println ex
}

value = 12
println "He paid \$${value} for that"
println(/He paid $${value} for that/)//使用正斜杠括起来的也是字符串，其中特殊字符可以不进行转义

/**
 * GString：使用双引号或正斜杠创建
 * Java String：使用单引号创建
 */
what = new StringBuilder('fence')
text = "The cow jumped over the $what"
println text
what.replace(0, 5, "moon")
println text//text被改变了

/**
 * 检查字符串类型
 */
def printClassInfo(obj) {
    println "class: ${obj.getClass().name}"
    println "superclass: ${obj.getClass().superclass.name}"
}

val = 125
println ""
printClassInfo("The Stock closed at $val")//双引号和正引号中有表达式，则创建GString对象
printClassInfo(/The Stock closed at $val/)
printClassInfo("This is a simple String")//双引号和正引号中没有表达式，则创建String对象
printClassInfo(/This is a simple String/)
