package T_8_1;

import ArrayList_5_1.Employee;
import ArrayList_5_1.Manager;

public class PairTest3 {

    //通配符泛型的测试

    //条件一：带有子类限定的通配符可以读取泛型对象——<? extends Employee>——不能写入对象
    //条件二：带有超类限定的通配符可以向泛型对象写入——<? super Manager>——也可以读取对象，但是读取对象没有意义，因为他不能使用？的方法
    //泛型T 是没有super这个关键字的，只有通配符？有super这个关键字

    public static void printBuddies(Pair<? extends Employee> p){
        Employee first = p.getFirst();
        Employee second = p.getSecond();
//        不能进行set操作——即写入操作
//        Manager a = new Manager("test",333,1900,1,1,);
//        p.setFirst(a);
//        p.setSecond(a);
        System.out.println(first.getName() + " and "+second.getName()+" are buddies." );
        //只能调用Employee的方法不能调用？的方法，因为不知道具体是什么类
        //Pair类的方法都可以调用
    }

    public static void minmaxBonus(Manager[] a ,Pair<? super Manager> result){
        if(a.length == 0)return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; i++) {
            if(min.getBonus()>a[i].getBonus()) min = a[i];
            if(max.getBonus()<a[i].getBonus()) max = a[i];
        }
//        主要是用于调用set方法
        result.setFirst(min);
        result.setSecond(max);
        //读取对象
//        System.out.println(result.getFirst().getName()); //不能调用？的方法，因为不知道具体是什么，可以调用Pair类的方法
//        System.out.println(result.getSecond());  //不会报错，但没有意义


    }

    public static void maxminBonus(Manager[] a, Pair<? super Manager> result){
        minmaxBonus(a, result);
        PairAlg.swapHelper(result);
        PairAlg.swap(result);
    }

}
