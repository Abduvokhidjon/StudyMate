package org.pageObjects;

import org.abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractComponent {
    WebDriver driver;

    @FindBy(xpath = "//p[@class='sc-iTFTee jnrlga']")
    WebElement user;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUserStatus(){
        return user.getText();
    }

}
