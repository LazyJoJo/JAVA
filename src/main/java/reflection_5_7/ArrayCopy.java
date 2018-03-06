package reflection_5_7;


import java.lang.reflect.Array;

public class ArrayCopy {

    //不是好的方法，int[]不能转成object[],只能转成object
    public static Object[] badCopyOf (Object[] a ,int newLength){
        Object[] newArray = new Object[newLength];
        System.arraycopy(a,0,newArray,0, Math.min(a.length,newLength));
        return newArray;
    }

    //这是一种比较通用的方式，通过反射判断是否是数组，并对数组进行实例化，
    public static Object goodCopyOf (Object a,int newLength){
        Class cl = a.getClass();
        if(!cl.isArray()) return  null;
        Class componentType = cl.getComponentType();//获得数组的具体类型
        int length = Array.getLength(a);//通过反射的方式获得数组的长度，正常情况下无法获得，因为传进来的是一个对象，不清楚是什么数组
        Object newArray = Array.newInstance(componentType,newLength);//数组实例化
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }


}
