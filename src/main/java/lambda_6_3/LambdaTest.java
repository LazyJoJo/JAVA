package lambda_6_3;

import javax.swing.Timer;
import javax.swing.*;
import java.util.Arrays;
import java.util.*;

public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[]{"Mercury" , "Venus", "Earth" , "Mars"};
        System.out.println(Arrays.toString(planets));
        System.out.println("sorted in dictionary order");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("sorted by length");
        Arrays.sort(planets,(first,second)->first.length()-second.length());//比较两个字符串哪个长，长的排在后面，第二个参数相当于一个比较器
        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(1000,event->
                System.out.println("the time is"+new Date()));//计时器，第二个参数是需要触发的事件
        t.start();
        JOptionPane.showMessageDialog(null,"Quit Program?");
        System.exit(0);
    }
}
