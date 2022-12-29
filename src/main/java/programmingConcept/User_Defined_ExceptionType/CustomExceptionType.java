package programmingConcept.User_Defined_ExceptionType;

public class CustomExceptionType extends Exception {
    private static String myCustomException = "Custom Exception Type - Msg";
    public CustomExceptionType(String err) {
        super(myCustomException);
    }
}
