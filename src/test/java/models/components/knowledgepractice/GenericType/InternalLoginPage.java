package models.components.knowledgepractice.GenericType;

public class InternalLoginPage extends LoginPage{
    @Override
    public String username() {
        return "Internal Login Page | username";
    }

    @Override
    public String password() {
        return "Internal Login Page | password";
    }

    @Override
    public String loginBtn() {
        return "Internal Login Page | loginBtn";
    }
}
