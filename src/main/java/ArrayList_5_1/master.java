package ArrayList_5_1;

import java.util.ArrayList;

public class master {
    public static void main(String[] args){
        ArrayList<Employee> employeeList = new ArrayList<>();
        for(int i=0;i<10;i++){
            employeeList.add(new Employee("as"+i,i));
        }
        employeeList.set(5,new Employee("test",5));
        employeeList.add(5,new Employee("test2",6)); //添加在第六个元素的位置上
        System.out.println(employeeList.get(6).getName());//获得的是第七个元素
        employeeList.remove(5); //删除的是第六个元素
        EmployeeDB.update(employeeList);
        ArrayList<Employee> elist = EmployeeDB.find("d");
        for(int i=0;i<10;i++){
            System.out.println(employeeList.get(i).getName() +"  "+employeeList.get(i).getAge());
        }

        Employee[] a = new Employee[employeeList.size()];
        employeeList.toArray(a);
        System.out.println(a[1].getName());

        //下面这种写法是错误的
        //Employee[] b = (Employee[]) employeeList.toArray();//
        //System.out.println(b[1]);


        System.out.printf("");
    }

}
