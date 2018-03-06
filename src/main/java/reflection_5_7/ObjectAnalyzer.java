package reflection_5_7;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {

    private ArrayList<Object> visited = new ArrayList<>();//防止陷入死循环

    public String toString(Object obj){
        if(obj == null) return null;
        if(visited.contains(obj)) return "...";
        visited.add(obj);
        Class cl = obj.getClass(); //object to class
        if(cl==String.class) return (String)obj;
        //解决一维到多维数组的值获取问题
        if(cl.isArray()) {
            String r = cl.getComponentType() + "[] {";//获取数组的类型
            for (int i = 0; i < Array.getLength(obj); i++) {
                if(i>0) r+=" ,";
                Object val = Array.get(obj,i);
                if(cl.getComponentType().isPrimitive()) r+=val;//是基本数据类型则直接输出
                else r+=toString(val);//递归的查看数据类型
            }
            return r+"}";
        }
        //分析具体的类中的fields部分
        String r = cl.getName();
        do{
            r+="[";
            Field[] fields = cl.getDeclaredFields();
            //第一种获取数据具体值得方式
            AccessibleObject.setAccessible(fields,true);//将整个区域的数据设置为可读取
            for(Field f : fields){
                if(!Modifier.isStatic(f.getModifiers())){//过滤掉类中的常量，静态元素用【】表示
                    if(!r.endsWith("[")) r+=","; //除第一个元素外
                    r+=f.getName()+"=";
                    try {
                        Class t = f.getType();
                        Object val = f.get(obj); //最终所有值都是以object的形式来展现
                        if (t.isPrimitive()) r += val;
                        else r += toString(val);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
            r+="]";
            cl = cl.getSuperclass(); //查看父类

        }while(cl!=null && cl!=Object.class);//有一些超类可能没有数据 就会变成【】

        return r;
    }
}
