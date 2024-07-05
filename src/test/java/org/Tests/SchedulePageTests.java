package org.Tests;

import org.abstractComponents.AbstractComponent;
import org.pageObjects.MyCoursesPage;
import org.resources.Config;
import org.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SchedulePageTests extends BaseTest {
    @Test
    public void testSuccessfulLogOut(){
        MyCoursesPage homePage = loginPage.loginWithValidCredentials(Config.getProperty("studentLogin"),Config.getProperty("studentPassword"));
        String urlBeforeLogout = AbstractComponent.getCurrentUrl();
        AbstractComponent.logOut();
        String urlAfterLogout = AbstractComponent.getCurrentUrl();
        Assert.assertNotEquals(urlBeforeLogout,urlAfterLogout);

    }
}
