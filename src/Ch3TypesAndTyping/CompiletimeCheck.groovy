/**
 * 静态类型检查生效时，不能直接调用动态方法
 * 但是有一个变通方案，可以在对象上使用invokeMethod()方法，见10.6节
 */
import groovy.transform.TypeChecked
import groovy.transform.TypeCheckingMode

/**
 * 1,开启静态类型检查
 */
//@TypeChecked//编译器进行静态类型检查
def shout(String str) {
    println "Printing in uppercase"
    println str.toUpperCase()
    println "Printing again in uppercase"
    println str.toUppercase()//方法名写错了，但是动态类型不会在编译器检查
}

try {
    shout('hello')
} catch (ex) {
    println "Failed...${ex.message}"
}

/**
 * 2,静态类型检查下的注入方法
 */
//@TypeChecked
def shoutString(String str) {
    println str.shout()// 加了类型检查注解后，报错
}

println ""
str = 'hello'
// 向类中注入方法
str.metaClass.shout = { -> toUpperCase() }
shoutString(str)

/**
 * 3,静态类型检查下的Groovy扩展方法
 */
@TypeChecked
def printInReverse(String str) {
    println str.reverse()// Groovy添加的方法，可以在静态类型检测时通过
}

println ""
printInReverse('hello')

/**
 * 4,即使开启了静态类型检查，在类型检查成功时，不必使用强制类型转换
 */
@TypeChecked
def use(Object instance){
    if (instance instanceof String)
        println instance.length()//不必强制类型转换
    else println instance
}
println ""
use('hello')
use(4)

@TypeChecked
class Sample{
    def method1(){

    }
    @TypeChecked(TypeCheckingMode.SKIP)//跳过静态类型检测
    def method2(String str){
        str.shout()
    }
}
