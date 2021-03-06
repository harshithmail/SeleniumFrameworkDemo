package TestCases;

import FrameworkProperties.ApplicationScreenshot;
import WebpageElements.Chapter1WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class TestCase2 {

    public TestCase2(WebDriver driver, int session_id) {
        try {
            Chapter1WebElement webele = new Chapter1WebElement(driver);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webele.Chapter1Link.click();
            Select dropdown = new Select(webele.dropDown);
            dropdown.selectByValue("Selenium Code");
            Thread.sleep(4000);
            new ApplicationScreenshot(driver, "Chapter1_test2_" + session_id);
            webele.homePage.click();
            System.out.println("Test case Passed.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Test case Failed.");
        }

    }
}
