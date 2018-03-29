package thread_14_0;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/*
  * @author       LazyJoJo
  * @date         2018/3/29 20:41
  * @description
  */
public class Ball {
    public static final int XSIZE = 15;
    public static final int YSIZE = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;
 /*
  * @author       LazyJoJo
  * @date         2018/3/29 21:02
  * @description  moves the ball to the next position
  */
    public void move(Rectangle2D bounds){
        x+=dx;
        y+=dy;

        if(x<bounds.getMinX()){
            x=bounds.getMinX();
            dx = -dx;
        }
        if(x+XSIZE>bounds.getMaxX()){
            x=bounds.getMaxX()-XSIZE;
            dx = -dx;
        }
        if(y<bounds.getMinY()){
            y=bounds.getMinY();
            dy = -dy;
        }
        if(y+YSIZE>bounds.getMaxY()){
            y=bounds.getMaxY()-YSIZE;
            dy = -dy;
        }
    }
 /*
  * @author       LazyJoJo
  * @date         2018/3/29 21:10
  * @description  get the shape of the ball at its current position
  */
    public Ellipse2D getShape(){
        return new Ellipse2D.Double(x,y,XSIZE,YSIZE);
    }

}
