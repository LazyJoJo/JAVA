package Collection_9_0;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
* 使用hash表中的桶链结构来实现set集，因此不能有相同的元素
*/
public class SetTest {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();

        long callTime = System.currentTimeMillis();
        String word = "add";
        words.add(word);
        String word2 = "delete";
        words.add(word2);
        callTime = System.currentTimeMillis()-callTime;

        Iterator<String> iter = words.iterator();
        for (int i = 0; i < 20 && iter.hasNext(); i++) {
            System.out.println(iter.next());
        }
        System.out.println("...");
        System.out.println(words.size()+" distinct words "+callTime+" milliseconds");

    }
}
