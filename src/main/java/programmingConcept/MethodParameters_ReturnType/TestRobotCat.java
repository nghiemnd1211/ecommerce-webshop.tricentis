package programmingConcept.MethodParameters_ReturnType;

public class TestRobotCat {
    public static void demo(RobotCat robotCat){
        robotCat.sayHello();
        robotCat.sayGoodbye();
    }

    public static void main(String[] args) {
        TestRobotCat testRobotCat = new TestRobotCat();
        testRobotCat.demo(new RobotCat("nnn","111"));
    }
}
