/**
 * 2.1 从Java到Groovy
 */

/**
 * 空指针
 */
static def foo(String str) {
    str?.reverse()
}

println foo("evil")
println foo(null)

/**
 * 异常处理
 */
static def openFile(String fileName) {
    new FileInputStream(fileName)
}

try {
    openFile("nonexistentFile")
} catch (FileNotFoundException ex) {
    println "Oops: " + ex
}

/**
 * 简化进程调用
 */
//println "git help".execute().text
//println "git help".execute().class.name
println "ls -l".execute().text
/**
 * 实现for循环
 */
//for (int i=0;i<3;i++){
//    print('ho ')
//}
//for (i in 0..2){ print 'ho '}
3.times { print 'ho ' }
println 'Merry Groovy!'
/**
 * 实现循环的多种方式
 */
// upto
0.upto(2){print "$it "}
// times
3.times {print "$it "}
// step
0.step(10,2){print "$it "}
