package T_8_1;


import ArrayList_5_1.Employee;
import ArrayList_5_1.Manager;

import java.time.LocalDate;

public class master {
    public static void main(String[] args) {

        //==============8-1
        String[] words = {"Mary","had","a","little","lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = "+mm.getFirst());
        System.out.println("max = "+mm.getSecond());

        //==============8-2
        LocalDate[] birthdays={
                LocalDate.of(1906,12,9),
                LocalDate.of(1815,12,10),
                LocalDate.of(1815,6,3),
                LocalDate.of(1910,6,22),
        };
        Pair<LocalDate> mm1 = ArrayAlg.minmax(birthdays);
        System.out.println(mm1.getFirst());
        System.out.println(mm1.getSecond());
        System.out.println("==========================");
        //==============error
        //Pair<String>[] a = new Pair<String>[10]; 不能实例化泛型数组


        //===============8-3
        Manager ceo = new Manager("Gus Greedy",80,2003000);
        Manager cfo = new Manager("Sid Sneaky",60,1503000);
        Pair<Manager> buddies = new Pair<>(ceo,cfo);
        PairTest3.printBuddies(buddies);
        Manager[] managers = {ceo,cfo};
        Employee e1 = new Employee("dd",3);
        Employee e2 = new Employee("ff",3);
        Pair<Employee> result = new Pair<>(e1,e2);

        PairTest3.minmaxBonus(managers,result);
        System.out.println("first: "+result.getFirst()+", second: "+result.getSecond());
        PairTest3.maxminBonus(managers,result);
        System.out.println("first: "+result.getFirst().getName()+", second: "+result.getSecond().getName());

    }
}
