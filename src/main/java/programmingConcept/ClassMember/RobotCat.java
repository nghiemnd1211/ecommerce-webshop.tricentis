package programmingConcept.ClassMember;

public class RobotCat {
    private String name;
    private int id;
    public static int publicCatId = 0;
    //If you want to share the class variable to another instances
    // So basically, instance contains the specific values for that object and objects contains the memory location (at run-time).

    public RobotCat (String name){
        this.name = name;
        this.id = ++this.publicCatId;
    }

    public static void main(String[] args) {
        RobotCat rc1 = new RobotCat("Lulu");
        publicCatId =10;

        RobotCat rc2 = new RobotCat("Lala");
        System.out.println(rc1.id);
        System.out.println(rc2.id);
    }
}
