package org.tests;

import org.abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pageObjects.MyCoursesPage;
import org.resources.Config;
import testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.WeakHashMap;

public class MyCoursesPageTest extends BaseTest {


    @Test (groups = {"regression"})
    public void testIfAnyClass() {
        MyCoursesPage page = loginPage.loginWithValidCredentials(Config.getProperty("studentLogin"),Config.getProperty("studentPassword"));
        boolean result = page.isElementPresent();
        Assert.assertTrue(result);
    }
    @Test (groups = {"regression"})
    public void testKufhkLink() {
        MyCoursesPage page = loginPage.loginWithValidCredentials(Config.getProperty("studentLogin"),Config.getProperty("studentPassword"));
        Assert.assertTrue(page.kufhkLink.isDisplayed());
    }

    @Test (groups = {"regression"})
    public void testIfNotificationBoxEmpty ()  {
        MyCoursesPage page = loginPage.loginWithValidCredentials(Config.getProperty("studentLogin"),Config.getProperty("studentPassword"));
        page.notificationIcon.click();
        String expectedMessage = "No notifications";
        String actualMessage = page.notificationBoxMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test (groups = {"regression"})
    public void testIfBackButtonWorking() {
        MyCoursesPage page = loginPage.loginWithValidCredentials(Config.getProperty("studentLogin"),Config.getProperty("studentPassword"));
        page.notificationIcon.click();
        String beforeClick = AbstractComponent.getCurrentUrl();
        page.settingsButton.click();
        page.backButton.click();
        String afterClick = AbstractComponent.getCurrentUrl();
        Assert.assertNotEquals(beforeClick, afterClick);
    }



    @Test
    public void testVideo() throws InterruptedException {
        MyCoursesPage page = loginPage.loginWithValidCredentials(Config.getProperty("studentLogin"),Config.getProperty("studentPassword"));
        page.clickOnCourseByTitle("Team5\n" +
                "2024-07-24");
        page.a();
//        Thread.sleep(10000);
//        page.clickOnLessonByTitle("Lesson1");
    }









}
