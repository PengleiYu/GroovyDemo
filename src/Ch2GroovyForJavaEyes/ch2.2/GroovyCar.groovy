/**
 * JavaBean
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
