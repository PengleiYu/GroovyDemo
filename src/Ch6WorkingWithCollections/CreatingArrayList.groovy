/**
 * 6.1 使用List
 */
lst = [1, 3, 4, 1, 8, 9, 2, 6]
println lst
println lst.getClass().name
println lst[0]//索引
println lst[lst.size() - 1]
println lst[-2]//负数索引
println lst[2..5]//范围
println lst[-6..-3]//负数范围

subList = lst[2..5]//该实例指向源列表部分内容
println subList.dump()
subList[0] = 55
println "After  subList[0]=55 lst = $lst"

/**
 * 6.2 迭代ArrayList
 * 内部迭代器：
 * 1，each
 * 2，collect
 */

/**
 * 遍历但不能操作原本元素
 */
lst = [1, 3, 4, 1, 8, 9, 2, 6]
lst.each { print "$it " }
println ""
lst.reverseEach { print "$it " }
println ""
lst.eachWithIndex { int entry, int i ->
    print "[$i]=$entry "
}
println ""

doubled = []
lst.each { doubled << it * 2 }
println doubled
/**
 * 搜集元素变换的结果
 */
println lst.collect { it * 3 }

/**
 * 6.3 使用查找方法
 */
println lst.find { it == 2 }
println lst.find { it > 4 }
println lst.findAll { it == 2 }
println lst.findIndexOf { it == 2 }//获取位置
println lst.findAll { it > 4 }

/**
 * 6.4 List上的其他便捷方法
 */
lst = ['Programming', 'In', 'Groovy']
count = 0
lst.each { count += it.size() }
println count
println lst.collect { it.size() }.sum()//lst变为长度列表，然后求和
println lst.inject(0) { carryOver, element -> carryOver + element.size() }//传入初始值，然后不断叠加元素长度

println lst.join(' ')
lst[0] = ['Be', 'Productive']
println lst
lst = lst.flatten()
println lst
println lst - ['Productive', 'In']
println lst.reverse()

/**
 * *号在每个元素上执行操作，不显示使用each
 */
println lst.size()
println lst*.size()
println lst*.toUpperCase()

/**
 * *号将集合拆散为单个对象
 */
def words(a, b, c, d) {
    println "$a,$b,$c,$d"
}

words(*lst)//数量必须和方法形参一致
