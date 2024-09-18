package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class DashboardPage extends Form {
    private final ILabel pluginSettingsBtn = getElementFactory().getLabel(
            By.xpath("//div[contains(text(), 'Plugins')]"), "Plugin selector");
    private final ILabel darkModeSettingsBtn = getElementFactory().getLabel(
            By.xpath("//div[contains(text(), 'WP Dark Mode')]"), "WP Dark Mode selector");
    private final ILink activePluginLink = getElementFactory().getLink(By.xpath(
            "//a[contains(text(),'Active ')]"), "Active Plugin");
    private final ILabel isWpDarkModePluginActive = getElementFactory().getLabel(
            By.xpath("//strong[contains(text(), 'WP Dark Mode')]"), "WP Dark Mode name");
    private final ILabel IsWpDarkModePluginInstalled = getElementFactory().getLabel(
            By.xpath("//a[contains(text(), 'WP Dark Mode')]"), "WP Dark Mode installed");
    private final ILink addNewPluginBtn = getElementFactory().getLink(
            By.xpath("//a[contains(text(), 'Add New')]"), "Add New Plugin Button");
    private final ITextBox searchField = getElementFactory().getTextBox(
            By.id("search-plugins"), "Search Field");
    private final IButton installButton = getElementFactory().getButton(
            By.xpath("//a[contains(@class, 'install-now') and contains(@aria-label, 'Install WP Dark Mode')]"), "Install Button");
    private final IButton activateButton = getElementFactory().getButton(
            By.xpath("//a[contains(@class, 'activate-now') and contains(@aria-label, 'Activate WP Dark Mode')]"), "Activate Button");
    private final ILink mainSite = getElementFactory().getLink(By.xpath(
            "//a[@class='ab-item' and text()='Demo Site']"), "main website page");

    ///Locators for Plugin Customization and Use
    private final ILink darkModeControlsAdmin = getElementFactory().getLink(
            By.xpath("//a[contains(@class, 'nav-item-child') and contains(text(), 'Admin Panel Dark Mode')]"), "Admin Dark Mode Controls");
    private final ILabel adminDarkModeSettingsToggle = getElementFactory().getLabel(
            By.className("h-full"), "Admin Dark Mode Toggle Switch");
    private final ILabel adminDarkModeDashBoardToggle = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'switch') and contains(@class, 'wp-dark-mode-ignore')]"), "Dark Mode");
    private final ILabel customization = getElementFactory().getLabel(
            By.xpath("//div[contains(@class, 'flex') and .//h4[text()='Customization']]"), "Dark mode Customization Dropdown");
    private final ILabel switchSettings = getElementFactory().getLabel(
            By.xpath("//a[contains(text(),'Switch Settings')]"), "Dark Mode Switch Settings");
    private final ILabel animationSettings = getElementFactory().getLabel(
            By.xpath("//a[contains(text(),'Site Animation')]"), "Animation Settings");
    private final ILabel switchSizeSlider = getElementFactory().getLabel(
            By.xpath("//input[@class='range' and @type='range']"), "Floating Switch Size Slider");
    private final ILabel switchPositionButtonLeft = getElementFactory().getLabel(
            By.xpath("//div[contains(@class, 'cursor-pointer') and contains(@class, 'flex')]/span[text()='Left']"), "Switch Position Left");
    private final ILabel darkModeAdvanced = getElementFactory().getLabel(
            By.xpath("//div[contains(@class, 'flex') and .//h4[text()='Advanced']]"), "Advanced Settings Dropdown");
    private final ILabel darkModeAccessibilitySettings = getElementFactory().getLabel
            (By.xpath("//a[contains(@class, 'nav-item-child') and text()='Accessibility']"), "Dark mode Accessibility Settings");
    private final IButton keyboardShortcutToggle = getElementFactory().getButton(
            By.xpath("//label[.//div[text()='Keyboard Shortcut']]//div[contains(@class, 'bg-blue-600')]"), "Keyboard Shortcut Toggle");
    private final IButton enableAnimationToggle = getElementFactory().getButton(
            By.xpath("//div[contains(@class, 'bg-slate-200')]"), "Animation Toggle");
    private final IRadioButton selectAnimation = getElementFactory().getRadioButton(
            By.xpath("//div[contains(@class, 'flex') and contains(@class, 'cursor-pointer') and .//span[text()='Pulse']]"), "Pulse Animation");
    private final IButton saveButton = getElementFactory().getButton(
            By.xpath("//button[contains(@class, 'border-blue-500')]"), "Save Button");
    private final IButton saveButton2 = getElementFactory().getButton(
            By.xpath("//button[contains(@class, 'bg-blue-500') and contains(@class, 'text-white') and text()='Save Changes']"), " Advanced Save Button");

    public DashboardPage() {
        super(By.id("menu-dashboard"), "Admin Dashboard Page");
    }

    /********* Private Methods ******/
    /// click WP Dark Mode Admin Settings
    private void clickDarkModeSettingsAdmin() {
        darkModeControlsAdmin.click();
    }
    ///click WP Dark Mode Switch Settings
    private void clickDarkModeSwitchSettings() {
        customization.click();
        switchSettings.click();
    }
    //// click WP Dark Mode Advanced Settings
    private void clickDarkModeAdvancedAccessibilitySettings() {
        // Click on the Advanced Settings Dropdown
        darkModeAdvanced.clickAndWait();
        // Click on the Accessibility settings element
        darkModeAccessibilitySettings.getJsActions().scrollIntoView();
        darkModeAccessibilitySettings.getElement().click();
    }
    // Presses Save button that appears after changing settings
    private void saveSettings() {
        saveButton.state().waitForDisplayed();
        saveButton.click();
    }
    // Presses Save button that appears after advanced changing settings
    private void saveAdvancedSettings() {
        saveButton2.state().waitForDisplayed();
        saveButton2.click();
    }
    /// activates plugin from plugin search results
    private void activatePlugin() {
        // activate plugin
        activateButton.state().waitForDisplayed();
        activateButton.click();
    }
    /// checks if WP Dark Mode Plugin is installed
    private boolean isPluginInstalled() {
        return IsWpDarkModePluginInstalled.state().isDisplayed();
    }
    /// toggles on darkmode in admin dashboard
    private void enableAdminDarkModeDashBoard() {
        adminDarkModeDashBoardToggle.click();
    }
    /********* Public  Methods ******/

    /// checks if WP Dark Mode Plugin is active in Plugin Settings
    public boolean isDarkModePluginActive() {
        return isWpDarkModePluginActive.state().waitForDisplayed();
    }
    /// installs plugin and activates it
    public void installAndActivatePlugin(String pluginName) {
        // Click the 'Add New' button to navigate to the plugin search page
        addNewPluginBtn.click();
        // Search for the plugin by typing the plugin name into the search field
        searchField.clearAndType(pluginName);

        if (isPluginInstalled()) {
            activatePlugin(); // method
        } else {
            installButton.state().waitForDisplayed();
            installButton.click();
            activatePlugin();
        }
    }
    /// click Plugin Settings
    public void clickPlugin() {
        pluginSettingsBtn.click();
        activePluginLink.click();
    }
    /// click WP Dark Mode in Dashboard
    public void clickWPDarkModeSettings() {
        darkModeSettingsBtn.click();
    }
    // enables admin dark mode option
    public void enableAdminDarkModeSettings() {
        // Code to enable the dark mode at admin
        clickDarkModeSettingsAdmin();
        adminDarkModeSettingsToggle.clickAndWait();
        saveSettings();
    }
    /// checks if dark mode is working on admin dashboard
    public boolean isAdminDarkModeWorking() {
        enableAdminDarkModeDashBoard();
        // Check if the dark mode is enabled by verifying specific elements or background colors
        String classAttribute = adminDarkModeDashBoardToggle.getAttribute("class");
        boolean checker = classAttribute.contains("active");
        // Check if it contains the word 'active'
        enableAdminDarkModeDashBoard();
        return checker;
    }
    ///// Changes floating switch style
    public void changeFloatingSwitchStyle(int style) {
        clickDarkModeSwitchSettings();
        // Code to change switch style
        List<IElement> switchStyles = getElementFactory().findElements(By.className("bg-[#F9FAFB]"), ElementType.LABEL);
        switchStyles.get(style).state().waitForClickable();
        switchStyles.get(style).click();
        saveSettings();
    }
    /// Changes floating switch size by moving slider
    public void changeSwitchSize(int size) {
        //clickDarkModeSwitchSettings();
        // Code to change switch size
        switchSizeSlider.state().waitForDisplayed();
        // JS to enable slider
        JavascriptExecutor js = (JavascriptExecutor) AqualityServices.getBrowser().getDriver();
        js.executeScript("arguments[0].value = arguments[1];", switchSizeSlider.getElement(), size);
        //Trigger input and notify event change
        js.executeScript("arguments[0].dispatchEvent(new Event('input', {bubbles: true}));", switchSizeSlider.getElement());
        js.executeScript("arguments[0].dispatchEvent(new Event('change', {bubbles: true}));", switchSizeSlider.getElement());
        saveSettings();
    }
    /// changes switch position to left side
    public void changeSwitchPositionLeft() {
       // clickDarkModeSwitchSettings();
        // Code to change switch position
        switchPositionButtonLeft.click();
        saveSettings();
    }
    /// disables keyboard shortcut from accessibility settings
    public void disableKeyboardShortcut() {
        clickDarkModeAdvancedAccessibilitySettings();
        // Code to disable the keyboard shortcut from accessibility settings
        keyboardShortcutToggle.state().waitForDisplayed();
        keyboardShortcutToggle.clickAndWait();
        saveAdvancedSettings();
    }
    //// enables page animation and chooses animation
    public void enablePageTransitionAnimation() {
        customization.click();
        // Code to enable and change the page-transition animation effect
        animationSettings.getJsActions().scrollIntoView();
        animationSettings.click();
        enableAnimationToggle.clickAndWait();
        selectAnimation.state().waitForDisplayed();
        selectAnimation.click();
        saveButton.click();
    }
    // goes to main site homepage
    public void goToMainSite() {
        mainSite.click();
    }
}
