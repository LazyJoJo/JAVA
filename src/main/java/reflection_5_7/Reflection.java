package reflection_5_7;

import java.lang.reflect.*;

public class Reflection {

    public static void printConstructors(Class cl){
        Constructor[] constructors = cl.getDeclaredConstructors();//获取所有构造体，包含私有的
        for( Constructor c: constructors){
            String name = c.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length()>0){
                System.out.print(modifiers+" ");
            }
            System.out.print(name+"(");
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if(i>0) System.out.print(" ,");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    //凡是Class类型的，都是因为无法确认一个具体的类型，所以需要封装一个类来表示，之后要通过getName来获得具体叫的名字
    public static void printMethods(Class cl){
        Method[] methods = cl.getDeclaredMethods();
        for( Method m : methods){
            Class retType = m.getReturnType();  //返回类型
            String name = m.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(m.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.print(retType.getName()+" "+name+"(");
            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if(i>0) System.out.print(" ,");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    //class 类型数据也可以直接打出，需要注意，我们要的不是他的类而是他的名字。
    public static void printFields(Class cl){
        Field[] fields = cl.getDeclaredFields();
        for(Field f : fields){
            String name = f.getName();
            Class type = f.getType();
            System.out.print("  ");
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.println(type.getName()+" "+name);
        }
    }
}
