package Collection_9_0;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {

        //SortedSet和NavigableSet都是TreeSet实现的接口，
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Widget",4562));
        parts.add(new Item("Modem",9912));
//        先按数字排序再按字母排序
        System.out.println(parts);

        //实现只靠description排序
        //括弧里是比较器的初始化，
        NavigableSet<Item> sortByDescription = new TreeSet<>(
                Comparator.comparing(Item::getDescription) //输入对象，得到对象中的一个值
        );
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);

//        test===================
//        测试接口的使用方法
        test a = new Item("dd",2);
        System.out.println(a.getDescription());
        Comparable b = new Item("aa",2);
        System.out.println(b.compareTo(a));
        //从上面可以看出接口不同时，实现的类只能用接口里的方法，不能调用Item的所有方法


    }
}
