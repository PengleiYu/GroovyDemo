/**
 * 使用Groovy代码生成变换
 */

import groovy.transform.Canonical
import groovy.transform.Immutable
import groovy.transform.InheritConstructors

/**
 * 1, 类似于lombok的@Data和Kotlin的data class
 */
@Canonical(excludes = "lastName,age")
class Person {
    String firstName
    String lastName
    int age
}

def sara = new Person(firstName: "Sara", lastName: "Walker", age: 49)
println sara

/**
 * 2, 被极大简化的委托
 */
class Worker {
    def work() { println 'get work done' }

    def analyze() { println 'analyze...' }

    def writeReport() { println 'get report written' }
}

class Expert {
    def analyze() { println 'expert analysis...' }
}

class Manager {
    @Delegate
    Expert mExpert = new Expert()
    @Delegate
    Worker mWorker = new Worker()
}

def bernie = new Manager()
bernie.analyze()
bernie.work()
bernie.writeReport()

/**
 * 3, 不可变，线程安全
 * 自动提供了构造器
 */
@Immutable
class CreditCard {
    String cardNumber
    int creditLimit
}

println new CreditCard("4000-1111-2222-3333", 1000)

/**
 * 4, 懒加载
 * 字段被标为了volatile
 */
class Heavy {
    def size = 10

    Heavy() { println "Creating Heavy with $size" }
}

class AsNeeded {
    def value
    @Lazy
    Heavy mHeavy1 = new Heavy()
    @Lazy
    Heavy mHeavy2 = { new Heavy(size: value) }()

    AsNeeded() { println "Created AsNeeded" }
}

def asNeeded = new AsNeeded(value: 1000)
println asNeeded.mHeavy1.size
println asNeeded.mHeavy1.size
println asNeeded.mHeavy2.size // Heavy构造方法执行时size为10，之后size才被赋值为1000
println ""

/**
 * 5, 去掉new关键字
 * Ruby风格：new成为一个静态方法
 * Python风格：不使用new关键字
 */
@Newify([Person, CreditCard])
//默认auto为true
def fluentCreate() {
    println Person.new(firstName: "John", lastName: "Doe", age: 20)
    println Person(firstName: "John", lastName: "Doe", age: 20)
    println CreditCard("1234-5678-1234-5678", 2000)
}

fluentCreate()

/**
 * 6, 单例
 * lazy不仅将实例创建延迟到了最后时刻，还保证了创建部分是线程安全的
 */
@Singleton(lazy = true)
class TheUnique {
    // 警告：单例不能有构造方法，不过可以运行
    // 可能是新版Groovy的规则，2.1.1还没有
    private TheUnique() { println 'Instance created' }

    static int hah = 1 // 用于测试lazy选项

    def hello() { println 'hello' }
}

println "Accessing TheUnique"
println TheUnique.hah
println "Accessing TheUnique"
TheUnique.instance.hello()
TheUnique.instance.hello()

/**
 * 7, 简化多构造器继承
 * 若不加该注解，子类必须实现一个构造方法，且若未实现其他的构造方法则无法使用
 * 加上注解后，子类会自动继承所有构造方法（可通过AST查看）
 */
class A {
    A(int a) {}

    A(String s) {}

    A(Object o) {}
}

@InheritConstructors
class B extends A {
//    B(int a) { super(a) }
}

println new B(" ")
println new B(1)
println new B(new Object())
