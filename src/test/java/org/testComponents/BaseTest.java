package org.testComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.pageObjects.LoginPage;
import org.resources.Config;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    public LoginPage loginPage;

    public WebDriver initDriver(){
        if (driver != null) return driver;

        String browser = Config.getProperty("browser");

        switch (browser){
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
                break;
        }
        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(Config.getProperty("pageLoadTimeout"))));
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperty("implicitlyWait"))));
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod
    public LoginPage launchApplication(){
        driver = initDriver();
        loginPage = new LoginPage(driver);
        loginPage.openWebsite(Config.getProperty("website"));
        return loginPage;
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
