package pages;

import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FrontEndPage extends Form {
    private final ILabel darkModeButton = getElementFactory().getLabel(By.className("wp-dark-mode-switch-styled"), "Plugin selector");
    private final ILabel frontEnd = getElementFactory().getLabel(By.className("wp-dark-mode-active"), "Front End Dark mode");

    public FrontEndPage() {
        super(By.className("home"), "Front End Site Page");
    }

    //// clicks dark mode button and checks if it is working
    public boolean isDarkModeWorking() {
        super.state().waitForDisplayed();
        darkModeButton.click();
        // Retrieve the class attribute of the element
        String className = frontEnd.getAttribute("class");
        // Return true if the class name contains 'active', otherwise return false
        return className.contains("active");
    }
}
