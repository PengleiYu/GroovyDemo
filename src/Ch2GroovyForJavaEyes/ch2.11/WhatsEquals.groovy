/**
 * Groovy中==相当于Java的equals方法
 * Groovy中is方法才相当于Java中的==
 */
str1 = 'hello'
str2 = str1
str3 = new String('hello')
str4 = 'Hello'
str5 = 'hello'

println "str1 == str2: ${str1 == str2}"
println "str1 == str3: ${str1 == str3}"
println "str1 == str4: ${str1 == str4}"
println "str1 == str5: ${str1 == str5}"

println "str1.is(str2): ${str1.is(str2)}"
println "str1.is(str3): ${str1.is(str3)}"
println "str1.is(str4): ${str1.is(str4)}"
println "str1.is(str5): ${str1.is(str5)}"

class A {
    @Override
    boolean equals(Object o) {
        println "equals called"
        false
    }
}

class B extends A implements Comparable {
    @Override
    boolean equals(Object o) {
        println "equals called"
        false
    }

    @Override
    int compareTo(Object o) {
        println "compareTo called"
        return 0
    }
}

/**
 * 在实现了Comparable接口的对象上，
 * ==操作符选择了compareTo方法，而不是equals方法
 */
println new A() == new B()
println new B() == new A()
