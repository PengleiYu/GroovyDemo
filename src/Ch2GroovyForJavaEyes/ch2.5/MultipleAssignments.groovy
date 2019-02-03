/**
 * 多赋值
 */

def splitName(fullName) { fullName.split(' ') }

def (firstName, lastName) = splitName("James Bond") // 多赋值
println "$lastName, $firstName $lastName"

def name1 = "Thomson"
def name2 = "Thompson"
println "$name1 and $name2"
(name1, name2) = [name2, name1] // 交换变量
println "$name1 and $name2"

// 指定变量类型、多余的值会被抛弃
def (String cat, String mouse) = ['Tom', 'Jerry', 'Spike', 'Tyke']
println "$cat and $mouse"

def (first, second,  third) = ['Tom', 'Jerry']
println "$first, $second, $third"
//def (first, second, int third) = ['Tom', 'Jerry'] // int不能为null，所以会抛异常
