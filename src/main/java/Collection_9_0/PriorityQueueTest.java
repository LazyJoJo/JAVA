package Collection_9_0;
 /*
  * @author       LazyJoJo
  * @date         2018/3/13 11:19
  * @description  优先队列的测试
  */

import java.time.LocalDate;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();//按一定顺序输出，但是不是大小顺序，目前未知
        pq.add(LocalDate.of(1906,12,9));
        pq.add(LocalDate.of(1915,12,10));
        pq.add(LocalDate.of(1903,12,3));
        pq.add(LocalDate.of(1910,6,22));

        System.out.println("Iterating over elements...");
        for(LocalDate date:pq){
            System.out.println(date);
        }
        System.out.println("Removing elements");
        while(!pq.isEmpty()){
            System.out.println(pq.remove());//一个一个删除，从小到大
        }
    }
}
