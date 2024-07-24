package org.pageObjects;

import org.abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchedulePage extends AbstractComponent {
    private WebDriver driver;

    public SchedulePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//div[@class=\"MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb\"]")
    public WebElement dropdown;

    @FindBy (xpath = "//li[@data-value=\"dayGridMonth\"]")
    public WebElement monthDropdown;

    @FindBy (xpath = "//li[@data-value=\"timeGridWeek\"]")
    public WebElement weekDropdown;

    @FindBy (xpath = "//li[@data-value=\"timeGridDay\"]")
    public WebElement dayDropdown;

    @FindBy(xpath = "(//*[text()='Test event'])[1]")
    public WebElement eventTest;
    @FindBy(xpath = "(//*[text()='Test Shedule'])[1]")
    public WebElement testSchedule;
    @FindBy(xpath = "(//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium sc-eKJbhj kWQXzA css-1ua49gz\"])[2]")
    public WebElement nextButton;
    @FindBy(xpath = "//*[text()='Russ Testing']")
    public WebElement russTesting;
    @FindBy(xpath = "//div[@class=\"sc-iveFHk kqpnEj\"]")
    public WebElement kufhkButton;



}
