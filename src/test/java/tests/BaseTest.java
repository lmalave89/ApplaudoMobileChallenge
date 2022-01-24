package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;

public class BaseTest {

    public WebDriverWait wait;

    @BeforeMethod
    @Parameters({"deviceName", "platformVersion"})
    public void setup (String deviceName, String platformVersion) throws IOException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("app", System.getProperty("user.dir") + "\\src\\main\\resources\\app\\me.wolszon.fastshopping_23.apk");
        caps.setCapability("noReset","false");
        ThreadLocalDriver.setTLDriver(new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"),caps));
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 30);
    }

    @AfterMethod
    public synchronized void teardown(){
        ThreadLocalDriver.getTLDriver().quit();
    }

}
