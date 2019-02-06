/**
 * 7.1 使用Object类的扩展
 */
/**
 * dump和inspect
 */
str = 'Hello'
println str
println str.dump()//返回对象内部内容
println str.inspect()//说明创建一个对象需要提供什么

/**
 * 使用上下文的with方法
 */
lst = [1, 2]
//lst.add 3
//lst.add 4
//println lst.size()
//println lst.contains(2)
lst.with {
    add(3)
    add(4)
    println size()
    println contains(2)
}
lst.with {
    println "this is $this"
    println "owner is $owner"
    println "delegate is $delegate"
}
/**
 * sleep，酣睡soundSleep
 * 不用处理中断异常了
 */
thread = Thread.start {
    println "Thread started"
    startTime = System.nanoTime()
    new Object().sleep(2000)//忽略中断
    endTime = System.nanoTime()
    println "Thread done in ${(endTime - startTime) / 10**9} seconds"
}
new Object().sleep(100)
println 'Let`s interrupt that thread'
thread.interrupt()
thread.join()

/**
 * 可控中断
 */
def playWithSleep(flag) {
    thread = Thread.start {
        println "Thread started"
        startTime = System.nanoTime()
        new Object().sleep(2000) {
            println "Interrupting...$it"
            flag
        }
        endTime = System.nanoTime()
        println "Thread done in ${(endTime - startTime) / 10**9} seconds"
    }
    thread.interrupt()
    thread.join()
}

println ""
playWithSleep(true)
playWithSleep(false)

