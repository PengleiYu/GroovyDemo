/**
 * 4.9 闭包委托
 * 参考19.7节DSL
 * 参考7.1和13.2节，使用delegate代理类的方法
 */
/**
 * 测试this、owner、delegate
 */
def examiningClosure(Closure closure) {
    closure()
}

examiningClosure {
    println "In First Closure:"
    println "class is " + getClass().name
    println "this is " + this + ", super:" + this.getClass().superclass.name
    println "owner is " + owner + ", super:" + owner.getClass().superclass.name
    println "delegate is " + delegate + ", super:" + delegate.getClass().superclass.name
    examiningClosure {
        println "In Closure within The First Closure:"
        println "class is " + getClass().name//这些闭包里不能在字符串里使用$来引用
        println "this is " + this + ", super:" + this.getClass().superclass.name
        println "owner is " + owner + ", super:" + owner.getClass().superclass.name
        println "delegate is " + delegate + ", super:" + delegate.getClass().superclass.name
    }
}

/**
 * 闭包内的方法路由
 */
class Handler {
    def f1() { println "f1 of Handler called ..." }

    def f2() { println "f2 of Handler called ..." }
}

class Example {
    def f1() { println "f1 of Example called ..." }

    def f2() { println "f2 of Example called ..." }

    def foo(Closure closure) {
        // 1,注意此处会影响其他引用closure的地方
//        closure.delegate = new Handler()
//        closure()
        // 2,为不影响闭包其他调用处，先clone一下
//        def clone = closure.clone()
//        clone.delegate = new Handler()
//        clone()
        // 3,使用with方法一次性执行上述三行
        // 不过with的行为和上述三行代码行为不一致
        // with内部设置了解析策略为代理优先
        new Handler().with closure
    }
}

def f1() { println "f1 of Script called..." }

println ""
new Example().foo {
    // 闭包中的this和owner都是脚本对象，delegate被设置为Handler对象
    // 闭包内方法调用顺序：this -> owner -> delegate
    f1()//调用了脚本中的f1
    f2()//调用了Handler中的f2
    // this和owner都是脚本对象，因为脚本会编译成脚本class
    println this.class.name//this、thisObject
    println owner.class.name
    println delegate.class.name
}
