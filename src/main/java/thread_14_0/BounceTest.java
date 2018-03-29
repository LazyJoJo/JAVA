package thread_14_0;

import javax.swing.*;
import java.awt.*;

/*
  * @author       LazyJoJo
  * @date         2018/3/29 19:50
  * @description  多线程第一部分的测试,入口程序
  */
public class BounceTest {
     public static void main(String[] args) {
         EventQueue.invokeLater(()->{
             //这里面实现的是run的内容
             JFrame frame = new BounceFrame();
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setVisible(true);
         });
     }

     //相当于
//    EventQueue.invokeLater(
//        new Runnable() {
//            public void run(){
//                JFrame frame = new BounceFrame();
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setVisible(true);
//            }
//    });
}
