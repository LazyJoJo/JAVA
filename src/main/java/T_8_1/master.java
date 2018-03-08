package T_8_1;


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

        //==============
        Pair<String>[] a = (Pair<String>[]) new Pair<?>[10];

    }
}
