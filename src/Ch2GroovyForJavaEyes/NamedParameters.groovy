/**
 * 2.3 灵活初始化与具名参数
 */
class Robot {
    def type, height, width

    def access(location, weight, fragile) {
        println "access Received fragile? $fragile, weight: $weight, loc: $location"
    }
    // 最好把第一个参数指明为map
    def access2(Map location, weight, fragile) {
        println "access2 Received fragile? $fragile, weight: $weight, loc: $location"
    }
    /**
     * 第三个形参为map的，必须传递map形式
     */
    def access3(location, weight, Map fragile) {
        println "access3 Received fragile? $fragile, weight: $weight, loc: $location"
    }
}

// 可自动把成员变量名作为键，不按顺序来
robot = new Robot(type: 'arm', width: 10, height: 40)
println "$robot.type, $robot.height, $robot.width"
robot = new Robot(type: 'arm', width: 10)
println "$robot.type, $robot.height, $robot.width"

/**
 * 参数列表多于形参数目，第一个形参location被当做map，
 * 参数列表中多余的键值对会被集合为map赋给第一个形参location
 */
robot.access(x: 30, y: 20, z: 10, 50, true)
robot.access(50, true, x: 30, y: 20, z: 10)
//robot.access(50,true,10,x:30,y:20,z:10,) // 多了一个int，抛异常了
robot.access(50, x: 30, y: 20, true, z: 10) // 键值对顺序没有关系

robot.access2(50, true, x: 30, y: 20, z: 10)
//robot.access2(50,20,true,x:30,y:20,z:10,) // error

//robot.access3(50, true, x: 30, y: 20, z: 10) // error，系统会自动把键值对合并为map，并调整其顺序为第一个
robot.access3(50, true, [x: 30, y: 20, z: 10])// 第三个形参为map的，必须传递map形式
