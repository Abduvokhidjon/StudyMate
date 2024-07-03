package org.Tests;

import org.pageObjects.MainPage;
import org.resources.Config;
import org.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginAsStudent(){
        MainPage mainPage = loginPage.login(Config.getProperty("studentLogin"),Config.getProperty("studentPassword"));
//        mainPage.getUserStatus();
        // assert
        Assert.assertEquals(mainPage.getUserStatus(), Config.getProperty("userStatus"));
    }
}
