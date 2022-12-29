package programmingConcept.MethodParameters_ReturnType;

public class RobotCat {
    String name;
    String id;
    public RobotCat(){

    }
    public RobotCat(String name, String id){
        this.name = name;
        this.id =  id;
    }
    public void sayHello(){
        System.out.println( "Hello, I'm a robot cat");
    }
    public void sayGoodbye(){
        System.out.println("Bye!");
    }
    public RobotCat rt(){
        System.out.println("return something");
        return this;
    }
}
