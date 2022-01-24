package tests.cucumber.steps;

import org.openqa.selenium.support.ui.WebDriverWait;
import tests.ThreadLocalDriver;

public class BaseSteps {

    protected WebDriverWait wait;

    protected void setupCucumber () {
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 30);
    }

    protected void tearDownSteps(){
        ThreadLocalDriver.getTLDriver().quit();
    }
}
