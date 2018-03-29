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

    public void add(Ball b){
        balls.add(b);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(Ball b : balls){
            g2.fill(b.getShape());
        }
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
