/**
 * 6.5 使用Map
 */
//langs =['C++':'Stroustrup','Java':'Gosling','Lisp':'McCarthy']
langs = ['C++': 'Stroustrup', Java: 'Gosling', Lisp: 'McCarthy']//map的key可以省略引号

println langs.getClass().name
println langs['Java']//数组方式
println langs.Java//属性方式
println langs.'C++'//操作符重载，必须加引号

/**
 * 6.6 在Map上迭代
 */
// 遍历
langs.each { entry ->
    println "Language $entry.key was authored by $entry.value"
}
// 遍历
langs.each { language, author ->
    println "Language $language was authored by $author"
}
// 搜集结果
println langs.collect { language, author ->
    language.replaceAll(/\+/, "P")
}
// 查找一个符合的
entry = langs.find { language, author ->
    language.size() > 3
}
println "Find $entry.key written by $entry.value"

println ""
// 查找所有符合
langs.findAll { language, author ->
    language.size() > 3
}.each { key, value ->
    println "Find $key written by $value"
}

println ""
// 是否存在符合
println langs.any { language, author ->
    language =~ /[^A-Za-z]/
}
// 是否全部符合
println langs.every { language, author ->
    language =~ /[^A-Za-z]/
}

// 使用分组
friends = [briang : 'Brian Goetz', brians: 'Brian Sletten',
           davidb : 'David Bock', davidg: 'David Geary',
           scottd : 'Scott Davis', scottl: 'Scott Leberknight',
           stuarth: 'Stuart Halloway']
groupByFirstName = friends.groupBy { it.value.split(" ")[0] }
groupByFirstName.each { firstName, buddies ->
    println "$firstName : ${buddies.collect { key, fullName -> fullName }.join(", ")}"
}
