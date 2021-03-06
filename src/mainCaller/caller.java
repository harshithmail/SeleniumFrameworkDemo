package mainCaller;

import ExcelOps.ExcelOperation;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class caller implements Commons {

    public static void main(String[] args) throws IOException, InvalidFormatException,
                     ClassNotFoundException, IllegalAccessException, InstantiationException,
                                                NoSuchMethodException, InvocationTargetException {

        //System.setProperty("webdriver.gecko.driver", geckoDriver);
        System.setProperty("webdriver.chrome.driver", chromedriver);
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        //driver.get("https://learn.letskodeit.com/p/practice");
        driver.get("http://book.theautomatedtester.co.uk/");
        driver.manage().window().maximize();
        Random rad = new Random();
        int session_id = rad.hashCode();
        ExcelOperation excel  = new ExcelOperation();
        int rowNum = excel.RowNum("Chapter1");

        /* This is to execute Chapter1 Test Cases */
        for (int i=1; i<=rowNum; i++) {
            String ClassName =  "TestCases." + excel.ExcelRead("Chapter1", i, 2);
            Constructor constructor = Class.forName(ClassName).getConstructor(WebDriver.class, int.class);
            constructor.newInstance(driver, session_id);
        }
        driver.quit();
    }
}
