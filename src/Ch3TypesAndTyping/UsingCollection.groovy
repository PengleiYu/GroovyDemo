/**
 * 多分派/多方法示例
 */
private static void test1() {
    ArrayList<String> list = new ArrayList<>();
    Collection<String> collection = list;
    list.add("one");
    list.add("two");
    list.add("three");
    list.remove(0);
    //由于多方法机制，此处实际是调用ArrayList的remove（int）方法
    //在Java中将会调用Collection的remove（Object）方法
    collection.remove(0);
    System.out.println("Added three items, removed tow, so 1 item to remain.");
    System.out.println("number of elements is: " + list.size());
    System.out.println("number of elements is: " + collection.size());
}

private static void test2() {
    ArrayList<Integer> list = new ArrayList<>();
    Collection<Integer> collection = list;
    list.add(1);
    list.add(2);
    list.add(3);
    list.remove(0);
    collection.remove(0);
    System.out.println("Added three items, removed tow, so 1 item to remain.");
    System.out.println("number of elements: " + list.size());
    System.out.println("number of elements: " + collection.size());
}

test1()
test2()
