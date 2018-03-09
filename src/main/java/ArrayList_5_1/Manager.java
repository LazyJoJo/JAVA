package ArrayList_5_1;

public class Manager extends Employee {
    private String name;
    private int age;
    private int bonus;


    public Manager(String name, int age, int bonus) {
        super(name, age); //必须要实现父类的构造器
        this.bonus = bonus;
    }


    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}