package thread_14_0;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/*
  * @author       LazyJoJo
  * @date         2018/3/29 21:12
  * @description
  */
public class BallComponent extends JPanel {
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;

    private List<Ball> balls = new ArrayList<>();

     /*
      * @author       LazyJoJo
      * @date         2018/3/31 10:40
      * @description  add the ball into the component
      */
    public void add(Ball b){
        balls.add(b);
    }
     /*
      * @author       LazyJoJo
      * @date         2018/3/31 10:41
      * @description  paint the component
      */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //success
        for (int i = 0; i < balls.size(); i++) {
            g2.fill(balls.get(i).getShape());
        }
        //error  java.util.ConcurrentModificationException
        //出现错误的原因，遍历的时候添加或删除元素
//        for(Ball b : balls){
//            g2.fill(b.getShape());
//        }
    }
     /*
      * @author       LazyJoJo
      * @date         2018/3/29 21:34
      * @description  复写了设置大小的方法
      */
    public Dimension getPreferredSize(){
        return new Dimension(WIDTH,HEIGHT);
    }
}
