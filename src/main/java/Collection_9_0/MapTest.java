package Collection_9_0;

import ArrayList_5_1.Employee;

import java.util.HashMap;
import java.util.Map;

/*
  * @author       LazyJoJo
  * @date         2018/3/13 16:42
  * @description  测试Map这种数据结构
  */
public class MapTest {
     public static void main(String[] args) {
         Map<String, Employee> staff = new HashMap<>();
         staff.put("144",new Employee("Amy",19));
         staff.put("567",new Employee("Harry",29));
         staff.put("890",new Employee("Gary",39));
         staff.put("234",new Employee("Cruz",49));

         System.out.println(staff);
         staff.remove("567");
         staff.put("123",new Employee("Miller",24));
         System.out.println(staff.get("890"));
         //相当于创建了一个运行模板，forEach 是其特有的函数
         staff.forEach((k,v)-> System.out.println("key = "+k+" value = "+v));
     }
}
