package innerClass_6_4;

public class ArrayAlg {

    public static class Pair{
        private double first;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }

    }
    //如果这个不是静态方法，则内部类也可以不是静态的
    public static Pair minmax(double[] values){
        double min = Double.POSITIVE_INFINITY;//一开始是最大值
        double max = Double.NEGATIVE_INFINITY;//最小值
        for(double v:values){
            if(min>v) min = v;
            if(max<v) max = v;
        }
        return new Pair(min,max);//在这里创建对象,所以这个内部类必须是Static
    }
}
