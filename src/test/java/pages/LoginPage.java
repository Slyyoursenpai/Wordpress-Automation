package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class LoginPage extends Form {

    private final ITextBox nameOrEmail = getElementFactory().getTextBox(By.id("user_login"), "Password or Email Field");
    private final ITextBox password = getElementFactory().getTextBox(By.id("user_pass"), "Password Field");
    private final IButton loginButton = getElementFactory().getButton(By.id("wp-submit"), "Submit Button");

    public LoginPage() {
        super(By.id("login"), "Admin Login Page");
    }

    public void enterUserNameOrEmail(String name) {
        nameOrEmail.clearAndType(name);
    }

    public void enterPassword(String pass) {
        password.clearAndType(pass);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}
