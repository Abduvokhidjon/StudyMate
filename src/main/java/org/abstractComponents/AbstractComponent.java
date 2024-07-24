package org.abstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageObjects.MyCoursesPage;
import org.pageObjects.SchedulePage;
import org.resources.Config;

import java.time.Duration;

public class AbstractComponent {
    private static WebDriver driver;
    @FindBy(xpath = "(//li[contains(@class,'MuiListIte')])[2]")
    private static WebElement scheduleBtn;
    @FindBy(xpath = "(//li[contains(@class,'MuiListIte')])[1]")
    private static WebElement myCoursesBtn;

    @FindBy(xpath = "//span[@class=\"sc-hTBuwn ckeXbs\"]")
    private static WebElement userIcon;

    @FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]")
    private static WebElement logOutIcon;

    @FindBy(xpath = "//button[text()='Log out']")
    private static WebElement logOutOption;
    @FindBy(xpath = "//p[contains(text(),'Student')]")
    private static WebElement user;

    @FindBy(xpath = "//div[@class='sc-lllmON lnzwxX']")
    private static WebElement logoutWindow;



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

    public static SchedulePage goToSchedulePage(){
        waitForElementToAppear(scheduleBtn);
        scheduleBtn.click();
        return new SchedulePage(driver);
    }
    public static MyCoursesPage goToMyCoursesPage(){
        waitForElementToAppear(myCoursesBtn);
        myCoursesBtn.click();
        return new MyCoursesPage(driver);
    }

    public static void logOut(){
        openLogoutWindow();
        logOutOption.click();
    }

    public static void openLogoutWindow(){
        userIcon.click();
        logOutIcon.click();
    }
    public static String getCurrentUrl(){
        waitForSeconds(3);
        return driver.getCurrentUrl();
    }

    public String getUserStatus(){
        waitForElementToAppear(user);
        return user.getText();
    }

    public static int getXofElement(WebElement element){
        return element.getLocation().getX();
    }
    public static int getYofElement(WebElement element){
        return element.getLocation().getX();
    }
    public static WebElement getLogoutWindow(){
        return logoutWindow;
    }

    public static void moveAndClick(int x, int y){
        Actions actions = new Actions(driver);
        actions.moveByOffset(x,y).click().build().perform();
    }
    public static boolean verifyTextInElement(WebDriver driver, int numOfSec, WebElement element, String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(numOfSec));
        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
        return element.getText().equals(expectedText);
    }



}
