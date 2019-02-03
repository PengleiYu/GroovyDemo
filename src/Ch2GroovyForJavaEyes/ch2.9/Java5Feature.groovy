/**
 * 自动装箱
 * 2.0之前所有基本类型都被视为对象
 * 2.0之后默认字节码级别作为基本类型，只有必要时才被视为对象
 */
int val = 5
println val.getClass().name

/**
 * 对for-each的支持
 */
String[] greetings = ["Hello", "Hi", "Howdy"]
for (String greet : greetings) {
    println greet
}
for (greet in greetings) {
    println greet
}
/**
 * enum
 */
enum CoffeeSize {
    SHORT, SMALL, MEDIUM, LARGE, MUG
}

def orderCoffee(size) {
    print "Coffee order received for size $size: "
    switch (size) {
        case [CoffeeSize.SHORT, CoffeeSize.SMALL]: // switch的case可以合并为数组
            println 'you`re health conscious'
            break
        case CoffeeSize.MEDIUM..CoffeeSize.LARGE: // enum可以使用range
            println "you gotta be a programmer"
            break
        case CoffeeSize.MUG:
            println "you should try Caffeine IV"
            break
    }
}

orderCoffee(CoffeeSize.SMALL)
orderCoffee(CoffeeSize.LARGE)
orderCoffee(CoffeeSize.MUG)

print 'Available sizes are: '
for (size in CoffeeSize.values()) {
    print "$size "
}
println ''

// 支持构造器和方法的枚举
enum Methodologies {
    Evo(5), XP(21), Scrum(30)

    final int daysInInteration

    Methodologies(days) {
        daysInInteration = days
    }

    def iterationDetails() {
        println "$this recommends $daysInInteration days for iteration"
    }
}

for (methodology in Methodologies.values()) {
    methodology.iterationDetails()
}

/**
 * 变长参数
 * ...和数组等价
 */
def receiveVarArgs(int a, int ... b) {
    println "You passed $a and $b"
}

def receiveArray(int a, int[] b) {
    println "You passed $a and $b"
}

receiveVarArgs(1, 2, 3, 4, 5)
receiveArray(1, 2, 3, 4, 5)
int[] values = [2, 3, 4, 5]
receiveVarArgs(1, values)
receiveArray(1, [2, 3, 4, 5] as int[]) // 中括号表示的是ArrayList，需要转型

println "${[2, 3, 4].class.name}"

/**
 * 静态导入
 * 可设置别名
 */
import static java.lang.Math.random as rand
import groovy.lang.ExpandoMetaClass as EMC

double value = rand()
println value
def metaClass = new EMC(Integer)
assert metaClass.getClass().name == 'groovy.lang.ExpandoMetaClass'

/**
 * 泛型
 */
ArrayList<Integer> list=new ArrayList<>()
list.add(1)
list.add(2.0)
list.add("hello")//不会有编译器错误
println "List populated"
for (int element:list){//运行时类型转换异常
    println element
}
