package T_8_1;

import java.lang.reflect.*;
import java.util.Arrays;

public class GenericReflection {

    public static void printClass(Class<?> cl){
        System.out.print(cl);
        printTypes(cl.getTypeParameters(),"<",",",">",true);//获取泛型变量声明 <T>
        Type sc = cl.getGenericSuperclass();//获得超类（只可能有一个）
        if(sc != null){
            System.out.print(" extends ");
            printType(sc,false);
        }
        printTypes(cl.getGenericInterfaces()," implements ",",","",false);//获取接口类型
        System.out.println();
    }

    public static void printMethod(Method m){
        String name = m.getName();
        System.out.print(Modifier.toString(m.getModifiers()));
        System.out.print(" ");
        printTypes(m.getTypeParameters(),"<",",",">",true);//泛型参数声明
        System.out.print(" ");
        printType(m.getGenericReturnType(),false);//打印返回类型
        System.out.print(" ");
        System.out.print(name);//打印方法名
        System.out.print("(");
        printTypes(m.getGenericParameterTypes(),"",",","",false);//打印输入参数
        System.out.println(")");
    }

    public static void printTypes(Type[] types,String pre, String sep,
                                  String suf, boolean isDefinition){
        if(pre.equals(" extends ")&& Arrays.equals(types, new Type[]{Object.class}))return;//extends Object 时直接返回
        if(types.length>0) System.out.print(pre);
        for (int i = 0; i < types.length; i++) {
            if(i>0) System.out.print(sep);
            printType(types[i],isDefinition);
        }
        if(types.length>0) System.out.print(suf);
    }

    public static void printType(Type type, boolean isDefinition){
        if(type instanceof Class){ //普通类型
            Class<?> t = (Class<?>) type;
            System.out.print(t.getName());
        }else if(type instanceof TypeVariable){ //泛型变量T，包含 T extends comparable<? super T>  整个表示一个变量
            TypeVariable<?> t = (TypeVariable<?>) type;
            System.out.print(t.getName());
            if(isDefinition)
                //T类型只有一种限定，因为都是用extends关键字
                printTypes(t.getBounds()," extends "," & ","",false);
        }else if(type instanceof WildcardType){//通配符？情况 如： ？ super T 这个部分
            WildcardType t = (WildcardType) type;
            System.out.print("?");
            //通配符有两种情况要考虑
            printTypes(t.getUpperBounds()," extends "," & ","" ,false);
            printTypes(t.getLowerBounds()," super "," & ","" ,false);
        }else if(type instanceof ParameterizedType){//泛型类如： comparable<? super T>
            ParameterizedType t = (ParameterizedType)type;
            Type owner = t.getOwnerType();//判断是否是最外层类
            if(owner!= null){
                printType(owner,false);//这只是递归调用
                System.out.print(".");
            }
            printType(t.getRawType(),false);//输出类名
            printTypes(t.getActualTypeArguments(),"<",",",">",false);//输出泛型参数
        }else if(type instanceof GenericArrayType){ //输出T[]情况
            GenericArrayType t = (GenericArrayType)type;
            System.out.print("");
            printType(t.getGenericComponentType(),isDefinition);
            System.out.print("[]");
        }
    }
}
