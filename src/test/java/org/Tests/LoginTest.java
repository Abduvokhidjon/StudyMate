package org.Tests;

import org.pageObjects.MainPage;
import org.resources.Config;
import org.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginAsStudent(){
        MainPage mainPage = loginPage.loginWithValidCredentials(Config.getProperty("studentLogin"),Config.getProperty("studentPassword"));
        Assert.assertEquals(mainPage.getUserStatus(), Config.getProperty("userStatus"));
    }

    @Test
    public void negativeLoginTest(){
        loginPage.loginWithInvalidCredentials(Config.getProperty("invalidLogin"),Config.getProperty("invalidPassword"));
        Assert.assertEquals(loginPage.getAlertText(), "User with email " + Config.getProperty("invalidLogin") + " not found");
    }
}
