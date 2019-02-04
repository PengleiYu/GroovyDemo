/**
 * 静态编译
 */
import groovy.transform.CompileStatic

@CompileStatic
def shout1(String str) {
    //非静态编译下，这里是通过CallSite.call来处理Groovy的动态调动机制
    //静态编译下，则是直接调用
    println str.toUpperCase()
}
