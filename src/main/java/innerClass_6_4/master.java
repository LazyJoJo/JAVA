package innerClass_6_4;

import javax.swing.*;

public class master {
    public static void main(String[] args) {
        //=======================test1
        TalkingClock clock = new TalkingClock(1000,true);
        clock.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);

        //=======================test2
        TalkingClockForMissName clock2 = new TalkingClockForMissName();
        clock2.start(1000,true);

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);

        //=======================test3
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = 100*Math.random();
        }
        ArrayAlg.Pair p = ArrayAlg.minmax(d);
        System.out.println(p.getFirst());
        System.out.println(p.getSecond());


    }
}
