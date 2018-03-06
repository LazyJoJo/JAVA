package enum_5_6;

enum  Size {
    SMALL("S"),BIG("B"),NORMAL("N");//第一行必须是具体类型，括号中是类的一个元素，外面可以通过方法访问
    private String abbreviation;
    //该构造器为私有的，只能在类初始化时直接进行赋值
    Size(String abbreviation){
        this.abbreviation = abbreviation;

    }

    public String getAbbreviation()
    {
        return this.abbreviation;
    }

}
