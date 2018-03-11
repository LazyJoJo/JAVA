package Collection_9_0;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {

    public static void main(String[] args) {
        //有序的链表
        List<String> a = new LinkedList<String>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<String>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        //变成迭代器，方便用户操作
        ListIterator<String> aIter = a.listIterator(); //只适用于list,相当于转成双向链表的迭代器，可以修改值
        Iterator<String> bIter = b.iterator();//使用所有集合，单向迭代器，不可以修改值

        aIter.next();
        aIter.set("test"); //和remove相同，必须先next之后才能修改第一个值
        System.out.println(a);
        System.out.println(b);

        //将b中的数据穿插到a中
        aIter.previous();//向前移一位，重置指针位，只有ListIterator有这个方法，iterator没有
        while(bIter.hasNext()){
            if(aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }
        System.out.println(a);

        //重新将指针指到第一个元素之前。
        bIter = b.iterator();
        //删除偶数位数据
        while(bIter.hasNext()){
            bIter.next();
            if(bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }

        System.out.println(b);
        a.removeAll(b);
        System.out.println(a);
    }
}
