/**
 * 7.1.4 间接访问
 */
class Car {
    int miles, fuelLevel
}

car = new Car(fuelLevel: 80, miles: 25)
properties = ['miles', 'fuelLevel']
properties.each { name ->
    println "$name = ${car[name]}"
}
car[properties[1]] = 100
println "fuelLevel new is ${car.fuelLevel}"

println car.properties

/**
 * 7.1.5 间接调用方法
 */
class Person {
    def walk() { println "Walking..." }

    def walk(int miles) { println "Walking $miles miles..." }

    def walk(int miles, String where) { println "Walking $miles miles $where..." }
}

peter = new Person()
peter.invokeMethod("walk", null)
peter.invokeMethod("walk", 10)
peter.invokeMethod("walk", [2, 'uphill'])
