package org.abstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageObjects.MyCoursesPage;
import org.pageObjects.SchedulePage;
import org.resources.Config;

import java.time.Duration;

public class AbstractComponent {
   static WebDriver driver;
    @FindBy(xpath = "(//li[contains(@class,'MuiListIte')])[2]")
    static WebElement scheduleBtn;
    @FindBy(xpath = "(//li[contains(@class,'MuiListIte')])[1]")
    static WebElement myCoursesBtn;

    @FindBy(xpath = "//span[@class=\"sc-hTBuwn ckeXbs\"]")
    static WebElement userIcon;

    @FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]")
    static WebElement logOutIcon;

    @FindBy(xpath = "//button[text()='Log out']")
    static WebElement logOutOption;
    @FindBy(xpath = "//p[contains(text(),'Student')]")
    WebElement user;


    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static void waitForElementToAppear(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(Config.getProperty("implicitlyWait"))));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public static void waitForSeconds(int numberOfSeconds){
        try{
            Thread.sleep(numberOfSeconds * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public SchedulePage goToSchedulePage(){
        waitForElementToAppear(scheduleBtn);
        scheduleBtn.click();
        return new SchedulePage(driver);
    }
    public MyCoursesPage goToMyCoursesPage(){
        waitForElementToAppear(myCoursesBtn);
        myCoursesBtn.click();
        return new MyCoursesPage(driver);
    }

    public static void logOut(){
        userIcon.click();
        logOutIcon.click();
        logOutOption.click();
    }
    public static String getCurrentUrl(){
        waitForSeconds(3);
        return driver.getCurrentUrl();
    }

    public String getUserStatus(){
        waitForElementToAppear(user);
        return user.getText();
    }
}
