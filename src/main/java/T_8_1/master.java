package T_8_1;



public class master {
    public static void main(String[] args) {
        String[] words = {"Mary","had","a","little","lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = "+mm.getFirst());
//        System.out.println("max = "+mm.getSecond());
        System.out.println("test for github");
    }
}
