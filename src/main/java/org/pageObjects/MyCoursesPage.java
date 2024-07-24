package org.pageObjects;

import org.abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.XMLFormatter;

public class MyCoursesPage extends AbstractComponent {
    private WebDriver driver;

    public MyCoursesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root sc-caPbAK ipXAMl css-s18byi\"]")
    public WebElement listOfCoursesMessage;

    @FindBy(xpath = "//div[@class=\"sc-iveFHk kqpnEj\"]")
    public WebElement kufhkLink;

    @FindBy (xpath = "(//span[contains(@class,'MuiBadge-root')]//*)[1]")
    public WebElement notificationIcon;

    @FindBy(xpath = "//div[@class=\"sc-ilhmMj hVcBBr\"]//p")
        public WebElement notificationBoxMessage;

    @FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1ua49gz\"]")
        public WebElement settingsButton;

    @FindBy (xpath = "(//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1ua49gz\"])[2]")
    public WebElement backButton;

    By elementName = By.xpath("//div[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root sc-caPbAK ipXAMl css-s18byi\"]");

    public String getMessage () {
        AbstractComponent.waitForElementToAppear(listOfCoursesMessage);
        return listOfCoursesMessage.getText();
    }
    public  boolean isElementPresent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementName));
        try{
            driver.findElement(elementName);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }








}
