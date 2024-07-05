package org.pageObjects;

import org.abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  extends AbstractComponent {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@autocomplete='username']")
    WebElement loginInput;

    @FindBy(xpath = "//div[contains(@class,'MuiAlert-message')]//p")
    WebElement alertMessage;

    @FindBy(xpath = "//input[@id=':r1:']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;
    ;

    public MyCoursesPage loginWithValidCredentials(String userLogin, String userPassword){
        loginInput.sendKeys(userLogin);
        passwordInput.sendKeys(userPassword);
        loginBtn.click();

        return new MyCoursesPage(driver);
    }
    public String loginWithInvalidCredentials(String invalidLogin, String invalidPassword){
        loginInput.sendKeys(invalidLogin);
        passwordInput.sendKeys(invalidPassword);
        loginBtn.click();

        return getAlertText();

    }



    public void openWebsite(String URL){
        driver.get(URL);
    }

    public String getAlertText(){
        waitForElementToAppear(alertMessage);
        return alertMessage.getText();
    }
}
