package testComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.pageObjects.LoginPage;
import org.resources.Config;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseTest {
    static WebDriver driver;
    public LoginPage loginPage;

    public static WebDriver initDriver(){
        if (driver == null) {

            String browser = Config.getProperty("browser");

            switch (browser) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                case "forefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }

            driver.manage().timeouts()
                    .pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(Config.getProperty("pageLoadTimeout"))));
            driver.manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperty("implicitlyWait"))));
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static WebDriver getDriver(){

        // if driver object already exists, then we just return it
        driver = new ChromeDriver();

        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(Config.getProperty("pageLoadTimeout"))));
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperty("implicitlyWait"))));
        driver.manage().window().maximize();

        return driver;

    }





    @BeforeMethod (groups = {"regression"})
    public LoginPage launchApplication(){
        driver = getDriver();

        loginPage = new LoginPage(driver);

        loginPage.openWebsite(Config.getProperty("website"));
        return loginPage;
    }
    @AfterMethod  (groups = {"regression"})
    public void tearDown(){
        driver.close();
    }

}
