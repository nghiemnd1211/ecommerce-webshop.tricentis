package JavaLearning.ComparableInterface;

public class Customers implements Comparable<Customers>{
    private String name;
    private int id;

    public Customers(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
    @Override
    public int compareTo(Customers toCompare) {
        return this.name.compareTo(toCompare.name);
    }
}
