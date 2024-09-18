package tests;

import aquality.selenium.browser.AqualityServices;
import utils.SettingsTestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public abstract class BaseTest {
    @BeforeMethod
    public void setup() {
        getBrowser().maximize();
        getBrowser().goTo(SettingsTestData.getEnvData().getSite());
    }

    @AfterMethod
    public void teardown() {
        if (AqualityServices.isBrowserStarted()) {
            getBrowser().quit();
        }
    }
}
