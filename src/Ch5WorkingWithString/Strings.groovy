/**
 * 5.4 操作符重载： + - * / ++(next) replaceAll() tokenize()
 */
str = "It`s a rainy day in Seattle"
println str
str -= 'rainy'
println str - 'rainy'//移除字符串
println str * 3//字符串重复多次
println(++str)//最后一个字符递增
println str.tokenize()

/**
 * 迭代String
 */
for (str in 'held'..'helm') {
    print "$str "
}
println ""

/**
 * 5.5 正则表达式
 */
obj = ~"hello"//正斜杠中不必对反斜杠进行转义
println obj.getClass().name

// =~表示匹配，返回matcher；==～表示整体匹配，返回boolean
pattern = ~"[Gg]roovy"
text = 'Groovy is Hip'
if (text =~ pattern)
    println "match"
else println "no match"
if (text ==~ pattern)
    println "match"
else println "no match"

// matcher
matcher = 'Groovy is groovy' =~ /[Gg]roovy/
print "Size of matcher is ${matcher.size()} "
println "with elements ${matcher[0]} and ${matcher[1]}"

// replaceFirst/replaceAll
str = 'Groovy is groovy, really groovy'
println ""
println str
result = (str =~ /groovy/).replaceAll('hip')
println result
