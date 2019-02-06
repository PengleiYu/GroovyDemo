/**
 * 2.7 布尔求值
 */
str = 'hello'
if (str) {//非null非空则为true
    println 'hello world'
}

// 集合非null，非空则为true
lst0 = null
println lst0 ? 'lst0 true' : 'lst0 false'
lst1 = [1, 2, 3]
println lst1 ? 'lst1 true' : 'lst1 false'
lst2 = []
println lst2 ? 'lst2 true' : 'lst2 false'

// 对象可通过实现asBoolean方法来决定自己的布尔转换
class Hello {
    def asBoolean() {
        false
    }
}

if (new Hello()){
    println "Hello() is not null"
}
