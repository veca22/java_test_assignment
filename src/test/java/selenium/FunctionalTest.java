package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FunctionalTest {

    protected static WebDriver driver;


    @BeforeClass
    public static void setupClass(){
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
