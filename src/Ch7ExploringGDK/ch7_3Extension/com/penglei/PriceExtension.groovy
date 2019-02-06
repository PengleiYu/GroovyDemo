package com.penglei;

class PriceExtension {
    public static double getPrice(String self) {
//        def url = "http://ichart.finance.yahoo.com/table.csv?s=$self".toURL()
//        def data = url.readLines()[1].split(",")
//        Double.parseDouble(data[-1])
        // dns解析失败
//        def url = "http://ichart.finance.yahoo.com/table.csv?s=$ticker".toURL()
        def url="https://www.baidu.com".toURL()
        def data = url.readLines()[1].split(",")
//        Double.parseDouble(data[-1])
        data[-1].hashCode()
    }
}
