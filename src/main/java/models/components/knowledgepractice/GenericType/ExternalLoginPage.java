package models.components.knowledgepractice.GenericType;

public class ExternalLoginPage extends LoginPage{
    @Override
    public String username() {
        return "External Login Page | username";
    }

    @Override
    public String password() {
        return "External Login Page | password";
    }

    @Override
    public String loginBtn() {
        return "External Login Page | loginBtn";
    }
}
