package com.penglei;

class PriceStaticExtension {
    public static double getPrice(String selfType, String ticker) {
        // dns解析失败
//        def url = "http://ichart.finance.yahoo.com/table.csv?s=$ticker".toURL()
        def url="https://www.baidu.com".toURL()
        def data = url.readLines()[1].split(",")
//        Double.parseDouble(data[-1])
        data[-1].hashCode()
    }
}