package programmingConcept.Interface;

public interface Bonus {
    default public void greeting(){
        System.out.println("Hi");
    }
    double getBonus();
}
