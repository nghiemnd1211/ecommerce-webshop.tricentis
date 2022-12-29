package programmingConcept.Inheritance;

public class Cat extends Animal{
    public Cat(){
        System.out.println();
    }
    public Cat(String name, String color){
        super(name,color);
    }
    public String greeting(){
        return super.greeting()+" my name is "+ this.getName();
    }

    public void makeSound(){
        super.makeSound();
        System.out.println("Meow meow...");
    }
    public static void main(String[] args) {
        Animal cat = new Cat("cat01","white");
        System.out.println(cat.greeting());
        cat.makeSound();
    }
}
