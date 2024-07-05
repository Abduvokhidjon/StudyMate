package org.Tests;

import org.abstractComponents.AbstractComponent;
import org.pageObjects.MyCoursesPage;
import org.resources.Config;
import org.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void negativeLoginTest(){
        String alertMsg = loginPage.loginWithInvalidCredentials(Config.getProperty("invalidLogin"),Config.getProperty("invalidPassword"));
        Assert.assertEquals(alertMsg, "User with email " + Config.getProperty("invalidLogin") + " not found");
    }
    @Test
    public void loginAsStudent(){
        MyCoursesPage mainPage = loginPage.loginWithValidCredentials(Config.getProperty("studentLogin"),Config.getProperty("studentPassword"));
        AbstractComponent.waitForSeconds(2);
        Assert.assertEquals(mainPage.getUserStatus(), Config.getProperty("userStatus"));
    }
}
