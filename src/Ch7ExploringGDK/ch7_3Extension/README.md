1,定义动态扩展类和静态扩展类，设置好包名路径
2,配置Manifest文件，注意文件夹路径
3,执行groovyc -d classes com/penglei/*.groovy；生成class文件
4，执行jar -cf priceExtensions.jar -C classes com -C manifest .；生成Jar包
5，编写FindPrice文件
6，执行groovy -classpath priceExtensions.jar FindPrice.groovy；运行FIndPrice脚本

tips: 教程里的网址dns解析失败，换成百度了