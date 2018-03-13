package Collection_9_0;

import java.util.Objects;

public class Item implements Comparable<Item>,test{
    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
        return "[description= "+description+", partNumber= "+partNumber+"]";
    }

    @Override
    //重写equals和hashCode方法
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(obj==null)return false;
        if(this.getClass() != obj.getClass())return false;
        Item other = (Item)obj;
        return Objects.equals(description,other.description) && partNumber==other.partNumber;
    }

    public int hashCode(){
        return Objects.hash(description,partNumber);
    }

    @Override
    //重写比较方式
    public int compareTo(Item other) {
        //数字相等时等于0
        int diff = Integer.compare(partNumber,other.partNumber);//比较数字是否相同
        return diff!=0 ? diff : description.compareTo(other.description);//两个类的比较写法不同
    }
}
