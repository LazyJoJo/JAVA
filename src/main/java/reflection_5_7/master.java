package reflection_5_7;

import ArrayList_5_1.Employee;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

public class master {
    public static void main(String[] args) {

        //test1-----------------------------------------获取类信息（Reflection）
        try{
            Class cl = Class.forName("java.lang.Double");
            Class scl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers + " ");
            System.out.print("class "+cl.getName());
            if(scl!=null && scl!=Object.class)
                System.out.println(" extends "+scl.getName()+"{");
            Reflection.printFields(cl);
            System.out.println();
            Reflection.printConstructors(cl);
            System.out.println();
            Reflection.printMethods(cl);
            System.out.println("}");

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("2---------------------------------------");

        //test2-----------------------------------------获取具体值（ObjectAnalyzer）
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            squares.add(i*i);
        }
        ObjectAnalyzer oa = new ObjectAnalyzer();
        System.out.println(oa.toString(squares));
        //解析ArrayList这个类本身，里面有elementData，size，modCount这几个元素，其他为静态元素
        //其中elementData又是一个Integer数组，默认10个空间大小
        int[][] a = {{1,1},{2,2}};
        System.out.println(oa.toString(a));
        System.out.println("3---------------------------------------");

        //test3-----------------------------------------修改具体值（无）
        Employee e = new Employee("ss",1);
        Class el = e.getClass();
        try {
            Field f = el.getDeclaredField("name");//这里是没有添加S的，寻找单独区域
            f.setAccessible(true);//第二种设置可获取参数的方法
            f.set(e, "dd");
        }catch(Exception e1){
            e1.printStackTrace();
        }
        System.out.println(oa.toString(e));
        System.out.println("4---------------------------------------");

        //test4-----------------------------------------数组类型参数的反射应用（ArrayCopy）
        int[] ary = {1,2,3};
        ary = (int[])ArrayCopy.goodCopyOf(ary,10);
        System.out.println(ary.toString());//打印出对象信息
        System.out.println(Arrays.toString(ary));//打印出数组内具体的数据信息

        String[] ary2 = {"ddj","djsl","xiaoming"};
        ary2 = (String[])ArrayCopy.goodCopyOf(ary2,10);
        System.out.println(Arrays.toString(ary2));

        System.out.println("下面会产生一个错误，类型间无法转换");
        ary2 = (String[])ArrayCopy.badCopyOf(ary2,20);
        System.out.println(Arrays.toString(ary2));


    }
}
