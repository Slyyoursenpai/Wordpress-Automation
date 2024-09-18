package tests;

import io.github.cdimascio.dotenv.Dotenv;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.FrontEndPage;
import pages.LoginPage;

public class WordpressTest extends BaseTest {
    private static final Dotenv dotenv = Dotenv.load();

    private final static String USERNAME = dotenv.get("NAME"); // using env variable
    private final static String PASSWORD = dotenv.get("PASSWORD"); // using env variable
    private final static int SWITCH_STYLE_NO = 1;
    private final static int SWITCH_SIZE_NO = 220;

    @Test
    public void wordPressTest() {
        //// Login
        LoginPage logIn = new LoginPage();
        logIn.state().waitForDisplayed();
        logIn.enterUserNameOrEmail(USERNAME);
        logIn.enterPassword(PASSWORD);
        logIn.clickLoginButton();

        //////// Dashboard
        DashboardPage admin = new DashboardPage();
        admin.clickPlugin();
        boolean isDarkModePluginActive = admin.isDarkModePluginActive();
        if (!isDarkModePluginActive) {
            // Plugin is not active, so install and activate it
            admin.installAndActivatePlugin("WP Dark Mode");
            // Recheck to ensure the plugin is now active after installation and activation
            Assert.assertTrue(admin.isDarkModePluginActive(), "The plugin 'WP Dark Mode' is still not active.");
        }
        admin.clickWPDarkModeSettings();
        admin.enableAdminDarkModeSettings();
        Assert.assertTrue(admin.isAdminDarkModeWorking(), "Dark Mode not working");
        admin.clickWPDarkModeSettings();
        admin.changeFloatingSwitchStyle(SWITCH_STYLE_NO);
        admin.changeSwitchSize(SWITCH_SIZE_NO);
        admin.changeSwitchPositionLeft();
        admin.disableKeyboardShortcut();
        admin.enablePageTransitionAnimation();
        admin.goToMainSite();
        admin.state().waitForNotDisplayed();
        //// Front end main page
        FrontEndPage front = new FrontEndPage();
        boolean working = front.isDarkModeWorking();
        Assert.assertTrue(working, "Dark mode is not active on the front end.");
    }
}
