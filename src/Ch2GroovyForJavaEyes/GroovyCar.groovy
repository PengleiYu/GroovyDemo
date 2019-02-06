/**
 * 2.2 JavaBean
 */

/**
 * 传统JavaBean
 */
class Car {
    def miles = 0// groovy 不区分private、public和protected
    final year

    Car(theYear) { year = theYear }
}

Car car = new Car(2008)

println "Year: $car.year"
println "Miles: $car.miles"
println "Setting miles"
car.miles = 25
println "Miles: $car.miles"

/**
 * Groovy方式的JavaBean
 */
class Car2 {
    final year
    private miles = 0

    Car2(theYear) { year = theYear }

    def getMiles() {
        println "getMiles called"
        miles
    }

    /**
     * private其实没用
     */
    private void setMiles(miles) {
        throw new IllegalAccessException("you're not allowed to change miles")
    }

    /**
     * 此处直接访问miles，而不是通过setMiles
     */
    def drive(dist) {
        if (dist > 0) miles += dist
    }
}

def car2 = new Car2(2012)

println "Year: $car2.year"
println "Miles: $car2.miles"
println "Driving"
car2.drive(10)
println "Miles: $car2.miles"

try {
    print 'Can I set the year? '
    car2.year = 1900
} catch (ReadOnlyPropertyException ex) {
    println ex.message
}
try {
    print 'Can I set the miles? '
    car2.miles = 1900
} catch (IllegalAccessException ex) {
    println ex.message
}

/**
 * 取代访问器
 */
Calendar.instance

str = 'hello'
str.class.name
