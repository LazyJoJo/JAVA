package T_8_1;

public class ArrayAlg {

    //正常方法
    public static Pair<String> minmax(String[] a){
        if(a==null || a.length==0)return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            String t = a[i];
            if(min.compareTo(t)>0)min = t;  //字典顺序
            if(max.compareTo(t)<0)max = t;
        }
        return new Pair<String>(min,max);
    }

    //泛型方法的定义，T限定为继承某个接口的对象类型，
    //这里的实现接口也用extends,继承对象也是这个关键字
    public static <T extends Comparable> Pair<T> minmax(T[] a){
        if(a==null || a.length==0)return null;
         T min = a[0];
         T max = a[0];
        for (int i = 1; i < a.length; i++) {
            T t = a[i];
            if(min.compareTo(t)>0)min = t;  //字典顺序（很多类都实现了这个方法，才能统一的比较）
            if(max.compareTo(t)<0)max = t;
        }
        return new Pair<T>(min,max);
    }
}
