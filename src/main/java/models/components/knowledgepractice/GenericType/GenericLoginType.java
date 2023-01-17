package models.components.knowledgepractice.GenericType;
import java.lang.reflect.Constructor;

 public class GenericLoginType {
    // extends: generic type boundary
    public <T extends LoginPage> void login(Class<T> loginPageClass) {
        Class<?>[] parameters = new Class[]{};
        try {
            // Using java reflection, init params to create an instance
            Constructor<T> constructor = loginPageClass.getConstructor(parameters);
            T loginPageObject = constructor.newInstance();
            loginPageObject.login();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GenericLoginType().login(ExternalLoginPage.class);
        new GenericLoginType().login(InternalLoginPage.class);
    }
}
