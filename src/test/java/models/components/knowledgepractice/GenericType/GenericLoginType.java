package models.components.knowledgepractice.GenericType;
import java.lang.reflect.Constructor;

public class GenericLoginType {
    // Gọi class T is a relationship với class LoginPage: T extends LoginPage
    // Truyền vào 1 class, chứ ko phải object --- Purpose: Khi nào muốn khởi tạo thì sẽ dùng java reflection kéo constructor của nó ra tự khởi tạo
    public <T extends LoginPage> void login(Class<T> loginPageClass) {
        Class<?>[] parameters = new Class[]{}; //empty in this case
        try {
            // truyền vào các parameters của constructor của class đó
            Constructor<T> constructor = loginPageClass.getConstructor(parameters);

            // creating new instance
            T loginPageObject = constructor.newInstance();
            loginPageObject.login();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GenericLoginType().login(InternalLoginPage.class);
        new GenericLoginType().login(ExternalLoginPage.class);
    }
}
