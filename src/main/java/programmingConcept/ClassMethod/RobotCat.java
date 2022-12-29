package programmingConcept.ClassMethod;

public class RobotCat {
    String name;
    int id;
    public static int publicCatId = 0;

    public RobotCat(String name){
        id = RobotCat.increase_publicCatId();
        this.name = name;
    }
    public static int increase_publicCatId(){
        publicCatId++;
        return publicCatId;
    }

    public static void main(String[] args) {
        RobotCat rc1 = new RobotCat("HIHI");
        RobotCat rc2 = new RobotCat("HAHA");

        System.out.println(rc1.id);
        System.out.println(rc2.id);
    }

}
