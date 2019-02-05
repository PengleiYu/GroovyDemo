/**
 * 4,8 动态闭包
 */

/**
 * 检查闭包存在与否
 */
def doSomeThing(closure) {
    if (closure) {
        closure()
    } else {
        println "Using default implementation"
    }
}

doSomeThing { println "Use specialized implementation" }
doSomeThing()

/**
 * 检查闭包期望的参数数目
 */
def completeOrder(Number amount, Closure taxComputer) {
    Number tax = 0
    if (taxComputer.maximumNumberOfParameters == 2) {
        tax = taxComputer amount, 6.05
    } else {
        tax = taxComputer amount
    }
    println "Sales tax is $tax"
}

completeOrder(100) { it * 0.0825 }
completeOrder(100) { amount, rate -> amount * (rate / 100) }

def examine(Closure closure) {
    println "$closure.maximumNumberOfParameters parameter(s) given:"
    for (aParameter in closure.parameterTypes) {
        println aParameter.name
    }
    println "--"
}

// 闭包类型信息
examine {}//Object
examine { it }//Object
examine { -> }//0参数
examine { val1 -> }//Object
examine { Date val1 -> }//Date
examine { Date val1, val2 -> }//Data,Object
examine { Date val1, String val2 -> }//Data,String
