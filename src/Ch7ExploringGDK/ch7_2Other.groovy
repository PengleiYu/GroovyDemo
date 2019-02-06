/**
 * 数组扩展
 */
int[] arr = [1, 2, 3, 4, 5, 6]
println arr[2..4]

/**
 * 7.2.2 对java.lang的扩展
 */

// << 管道
process = 'wc'.execute()
process.out.withWriter {
    it << "Let the World know...\n"
    it << "Groovy Rocks!\n"
}
println process.in.text
// String数组作为命令行参数发送给进程
String[] command = ['groovy', '-e', '"print \'Groovy\'"']
println "Calling ${command.join(" ")}"
println command.execute().text
//多个线程
def printThreadInfo(msg) {
    def currentThread = Thread.currentThread()
    println "$msg Thread is ${currentThread}.Daemon? ${currentThread.isDaemon()}"
}

printThreadInfo 'Main'
Thread.start {
    printThreadInfo "Started"
    sleep(3000) { println "Interrupted" }
    println "Finished Started"
}
sleep(1000)
Thread.startDaemon {
    printThreadInfo "Started Daemon"
    sleep(5000) { println "Interrupted" }
    println "Finished Started Daemon"
}

/**
 * 7.2.3 java.io的扩展
 */
def file = new File("HelloWorld.txt")
//new File("HelloWorld.txt").withWriter {
//    it << "Hello\n"
//    it << "World"
//}
file.eachLine {//遍历每行
    println it
}

println file.filterLine { it =~ /ll/ }//过滤每行

// 对流的扩展
file.withInputStream {
    it.withReader {}
    it.iterator()
}
//file.withObjectInputStream {
//    it.iterator()
//}
file.withDataInputStream {
    it.iterator()
}
/**
 * 7.2.4 java.util的扩展
 */
def list = [1, 2, 3]
list.asImmutable()//List、Set、SortedSet、SortedMap都有该方法
Iterable<Integer> iterable = list
println iterable.inject(0) { result, element -> result + element }//Iterator支持inject方法

Timer timer = new Timer()
timer.runAfter(1000) { println "Timer runAfter" }//timer加入了runAfter方法
