package enum_5_6;

public class master {
    public static void main(String[] args){

        Size a = Size.BIG;
        System.out.println(a.getAbbreviation());

        //推荐使用==，不使用equal，实测结果是一样的
        if(a == Size.SMALL){
            System.out.println("you are right !");
        }
        if(a.equals(Size.BIG)){
            System.out.println("you are right !");
        }

    }

    //测试可变参数部分（可变参数只能在传参中使用，不能在别处使用）

    //可变部分必须放在最后，可变参数的使用和数组一样
    public void test(String b,String ... a ){
        for(String c : a){
            System.out.println(c);
        }
        System.out.println(a[1]);
    }
}
