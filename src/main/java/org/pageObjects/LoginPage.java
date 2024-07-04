package org.pageObjects;

import org.abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage  extends AbstractComponent {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = ":r0:")
    WebElement loginInput;

    @FindBy(xpath = "//div[contains(@class,'MuiAlert-message')]//p")
    WebElement alertMessage;

    @FindBy(id = ":r1:")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

//    @FindBy(className = "MuiFormControl-root css-ccwj9y")
//    Select selectLanguage;
//
//    @FindBy(className = "sc-fnGiBr bAtogt")
//    WebElement forgotPasswordBtn;

    public MainPage loginWithValidCredentials(String userLogin, String userPassword){
        loginInput.sendKeys(userLogin);
        passwordInput.sendKeys(userPassword);
        loginBtn.click();

        return new MainPage(driver);
    }
    public void loginWithInvalidCredentials(String invalidLogin, String invalidPassword){
        loginInput.sendKeys(invalidLogin);
        passwordInput.sendKeys(invalidPassword);
        loginBtn.click();
    }



    public void openWebsite(String URL){
        driver.get(URL);
    }

    public String getAlertText(){
        waitForElementToAppear(alertMessage);
        return alertMessage.getText();
    }
}
