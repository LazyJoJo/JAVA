package ArrayList_5_1;

import java.util.ArrayList;

public class EmployeeDB {
    public static void update(ArrayList list){
        //这里必须强转一下，否则不知道传入的是什么，这句有可能会抛出异常。
        ArrayList<Employee> elist =  list;
        for(Employee e : elist){
            int age = e.getAge();
            age+=1;
            e.setAge(age);
        }
    }

    public static ArrayList find(String name){
        return new ArrayList<Employee>(100);
    }


}
