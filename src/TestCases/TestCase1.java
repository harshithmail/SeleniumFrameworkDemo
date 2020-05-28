package TestCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

import FrameworkProperties.ApplicationScreenshot;
import WebpageElements.Chapter1WebElement;

public class TestCase1 {

	public void testExe(WebDriver driver, int session_id)
	{
		try {
			Chapter1WebElement webele = new Chapter1WebElement(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			webele.Chapter1Link.click();
			webele.checkbox.click();
			webele.radioButton.click();
			webele.inputBox.sendKeys("Test Message1");
			Thread.sleep(3000);
			String plaintext = webele.plainText.getText();
			System.out.println(plaintext);
		    new ApplicationScreenshot(driver, "Chapter1_test1_"+session_id);
			webele.homePage.click();		
			System.out.println("Test case Passed.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Test case failed.");
		} 
	}

}
