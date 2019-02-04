/**
 * 多分派/多方法示例
 */
class Employee {
    public void raise(Number amout) {
        println "Employee got raise"
        println amout.class.name
    }
}

class Executive extends Employee {//子类
    void raise(Number amout) {//在Java中无论传什么类型的Number，都会调用该方法
        println "Executive got raise"
    }

    void raise(BigDecimal amout) {//在Groovy中调用该方法
        println "Executive got outlandish raise"
        println amout.class.name
    }
//    void raise(Long amout){
//        println "Executive got Long raise"
//        println amout.class.name
//    }
}

void giveRaise(Employee employee) {
//    employee.raise(new BigDecimal(10000.00))
    employee.raise(10000.00)
    //传int、long等数字都会调用参数类型BigDecimal的raise
    // 因为BigDecimal在多态中比Number更接近
    // todo 没搞懂，Integer和BigDecimal都是Number的子类
//    employee.raise(new Integer(1))
//    employee.raise(new Double(1))
//    employee.raise(new Long(1))
}

giveRaise new Employee()
giveRaise new Executive()
