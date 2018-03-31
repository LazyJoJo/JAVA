package thread_14_0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 /*
  * @author       LazyJoJo
  * @date         2018/3/29 20:12
  * @description  总面板设计
  */
public class BounceFrame extends JFrame{
    private BallComponent comp;
    public static final int STEPS = 1000;
    public static final int DELAY = 3;

    public BounceFrame(){
        setTitle("Bounce");
        comp = new BallComponent();
        this.add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel,"Start",event->addBallThread());//addBall(), 这个方法就相当于一个代码段
//      相当于
//        button.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent event) {
//                addBall();
//            }
//        });
        addButton(buttonPanel,"Close",event->System.exit(0));
        this.add(buttonPanel,BorderLayout.SOUTH);
        this.pack();
    }
     /*
      * @author       LazyJoJo
      * @date         2018/3/29 20:27
      * @description  添加按钮
      */
    public void addButton(Container c, String title, ActionListener listener){
         JButton button = new JButton(title);
         c.add(button);
         button.addActionListener(listener);
    }

     /*
      * @author       LazyJoJo
      * @date         2018/3/29 20:33
      * @description  add a bouncing ball to the panel
      */
     public void addBall(){
         try{
             Ball ball = new Ball();
             comp.add(ball);
             for (int i = 0; i < STEPS; i++) {
                 ball.move(comp.getBounds());
                 comp.paint(comp.getGraphics());
                 Thread.sleep(DELAY);
             }
         }catch (InterruptedException e){

         }
     }
     public void addBallThread(){
         Runnable r = ()-> addBall();
         Thread t = new Thread(r);
         t.start();
     }

}
