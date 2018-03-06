package lambda_6_3;
/*
* 需要注意的几点说明：
* 1、只能引用不会改变的变量 这里的变量是a
* 2、不能声明和局部变量同名的参数  这里的参数是value
* 3、如果出现this.toString() 是调用master对象的toString方法，而不是IntConsumer对象的toString方法
*/
public class master {
    public static void main(String[] args) {
        String a = "djksf"; //表示自由变量，在表达式外的局部变量
        repeat(10,value-> System.out.println(value+a));
        //相当于
        IntConsumer action = value -> System.out.println(value);
        repeat(5,action);

    }


    public static void repeat(int n,IntConsumer action){
        for (int j = 0; j < n; j++) {
            action.accept(j);
        }
    }
}


//只有一个抽象方法的接口，可以有默认方法
@FunctionalInterface //这个可加可不加
interface IntConsumer{

    void accept(int value);//这里接收的参数就是lambda的那个参数

    //default 是Java8新加的特点，表示默认的方法
    default void tostring(){
        System.out.println("test");
    }
}
