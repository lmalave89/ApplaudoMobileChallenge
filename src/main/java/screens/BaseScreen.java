package screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BaseScreen {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }

    protected void click(By by) {
        waitVisibility(by);
        driver.findElement(by).click();
    }

    protected void hideKeyboard() {
        driver.hideKeyboard();
    }

    protected WebElement waitAndFindElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void sendTextNative(By by, String text) throws IOException {
        waitVisibility(by);
        String textConverted = text.replaceAll("\\s", "%s");
        String command = "adb shell input text \"" + textConverted + "\"";
        Runtime.getRuntime().exec(command);
        sleep(3000);
    }

    protected void sendTextNative(String text) throws IOException {
        String textConverted = text.replaceAll("\\s", "%s");
        String command = "adb shell input text \"" + textConverted + "\"";
        Runtime.getRuntime().exec(command);
        sleep(3000);
    }

    protected void waitVisibility(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void clickOnFindElements(By by) {
        List<WebElement> items = driver.findElements(by);
        for (WebElement item: items) {
            item.click();
        }
    }

    protected void pressEnter() {
        driver.pressKeyCode(66);
    }

    protected void clickBackButtonNative() {
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    protected void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scroll(By by) {
        boolean found = false;
        while (!found) {
            try {
                driver.findElement(by);
                found = true;
            } catch (Exception e) {
                Dimension size = driver.manage().window().getSize();
                int startx = size.width / 2;
                int starty = (int) (size.height * 0.9);
                int endx = size.width / 2;
                int endy = (int) (size.height * 0.2);
                (new TouchAction(driver))
                        .press(PointOption.point(startx, starty))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(endx, endy))
                        .release()
                        .perform();
            }
        }
    }
}

