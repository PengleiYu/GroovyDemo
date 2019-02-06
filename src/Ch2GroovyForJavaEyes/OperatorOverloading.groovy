/**
 * 2.8 操作符重载
 */

for (ch = 'a'; ch < 'd'; ch++) {// ++对应于next方法
    println ch
}
for (ch in 'a'..'c') {
    println ch
}

lst = ['hello']
lst << 'there' // <<对应于leftShift方法
println lst

class ComplexNumber {
    def real, imaginary

    def plus(ComplexNumber other) {
        new ComplexNumber(real: real + other.real,
                imaginary: imaginary + other.imaginary)
    }

    @Override
    String toString() {
        "$real ${imaginary > 0 ? '+' : ''} ${imaginary}i"
    }
}

c1 = new ComplexNumber(real: 1, imaginary: 2)
c2 = new ComplexNumber(real: 4, imaginary: 1)

println "($c1) + ($c2) = ${c1 + c2}"
