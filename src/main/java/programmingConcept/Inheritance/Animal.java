package programmingConcept.Inheritance;

public class Animal {
    public String name;
    private String color;

    public Animal(){

    }
    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String greeting() {
        return "Hello";
    }

    public void makeSound() {
        System.out.println("Animal Sound");
    }
}
