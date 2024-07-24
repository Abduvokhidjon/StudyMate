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

    @FindBy(xpath = "//div[contains(@class,'MuiPaper-root')]")
    private List<WebElement> listOfCourses;

    @FindBy(xpath = "//div[@class='sc-iWOQzb UgwiX']")
    private List<WebElement> listOfLessons;

    @FindBy(xpath = "//div[@class='sc-gInZnl caKcFY']")
    private List<WebElement> listOfVideo;

    @FindBy(xpath = "//div[@class='sc-byHATT CXCYm']")
    private List<WebElement> listOfPresentations;

    @FindBy(xpath = "//div[@class='sc-dvEHMn lhFLMT']")
    private List<WebElement> listOfTask;

    @FindBy(xpath = "//div[@class='sc-dvEHMn lhFLMT']")
    private List<WebElement> listOfLinks;

    @FindBy(xpath = "//div[@class='sc-dvEHMn lhFLMT']")
    private List<WebElement> listOfTests;



    @FindBy(xpath = "//div[@class='MuiTabs-flexContainer css-k008qs']//a[contains(text(), 'Video lesson')]")
    private WebElement videoLessonTab;

    @FindBy(xpath = "//div[@class='MuiTabs-flexContainer css-k008qs']//a[contains(text(), 'Presentation')]")
    private WebElement presentationTab;

    @FindBy(xpath = "//div[@class='MuiTabs-flexContainer css-k008qs']//a[contains(text(), 'Task')]")
    private WebElement taskTab;

    @FindBy(xpath = "//div[@class='MuiTabs-flexContainer css-k008qs']//a[contains(text(), 'Link')]")
    private WebElement linkTab;

    @FindBy(xpath = "//div[@class='MuiTabs-flexContainer css-k008qs']//a[contains(text(), 'Test')]")
    private WebElement testTab;


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



    public void clickOnCourseByTitle(String title){
        for (WebElement courseCard: listOfCourses){
            String courseName = courseCard.findElement(By.xpath("//div[@class='sc-eYqcxL eElFlV']")).getText().split(" ")[0];
            if (courseName.equals(title)) courseCard.click();
        }
    }
    public void clickOnLessonByTitle(String title) throws InterruptedException {
        Thread.sleep(10000);
        for (WebElement lesson: listOfLessons){
            String lessonTitle = lesson.findElement(By.xpath("//p[@class='sc-uokDu bjaFwe']")).getText();
            System.out.println(lessonTitle);
//            if (lessonTitle.equals(title)) lesson.click();
        }
    }
    public void a(){
        listOfLessons.get(0).click();
    }

    public void clickOnVideoByTitle(String title){
        videoLessonTab.click();
        for (WebElement videoCard: listOfVideo){
            String videoTitle = videoCard.findElement(By.xpath("//p[@class='sc-hlzHbZ icenxl']")).getText();
            if (videoTitle.equals(title)) videoCard.click();
        }
    }
    public void clickOnPresentationByTitle(String title){
        presentationTab.click();
        for (WebElement presentationCard: listOfPresentations){
            String presentationTitle = presentationCard.findElement(By.xpath("//p[@class='sc-PBEJI cTzOMf']")).getText();
            if (presentationTitle.equals(title)) presentationCard.click();
        }
    }

    public void clickOnTaskByTitle(String title){
        taskTab.click();
        for (WebElement taskCard: listOfTask){
            String taskTitle = taskCard.findElement(By.xpath("//h2")).getText();
            if (taskTitle.equals(title)) taskCard.click();
        }
    }

    public void clickOnLinkByTitle(String title){
        linkTab.click();
        for (WebElement linkCard: listOfLinks){
            String link = linkCard.findElement(By.xpath("//a")).getText();
            if (link.equals(title)) linkCard.click();
        }
    }

    public void clickOnTestByTitle(String title){
        testTab.click();
        for (WebElement testCard: listOfTests){
            String testName = testCard.findElement(By.xpath("//div[@class='sc-ckLdoV fvWzOW']//h2")).getText();
            if (title.equals(testName)) testCard.findElement(By.xpath("//button")).click();
        }

    }







}
