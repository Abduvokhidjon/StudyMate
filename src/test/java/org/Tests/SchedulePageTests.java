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
        MyCoursesPage MyCoursesPage = loginPage.loginWithValidCredentials(Config.getProperty("studentLogin"),Config.getProperty("studentPassword"));
        String urlBeforeLogout = AbstractComponent.getCurrentUrl();
        AbstractComponent.logOut();
        String urlAfterLogout = AbstractComponent.getCurrentUrl();
        Assert.assertNotEquals(urlBeforeLogout,urlAfterLogout);
    }
    @Test
    public void testWithClickingOutsideBox(){
        MyCoursesPage MyCoursesPage = loginPage.loginWithValidCredentials(Config.getProperty("studentLogin"),Config.getProperty("studentPassword"));
        AbstractComponent.goToMyCoursesPage();
        String urlBefore = AbstractComponent.getCurrentUrl();
        AbstractComponent.openLogoutWindow();


        int xOfLogoutWindow = AbstractComponent.getXofElement(AbstractComponent.getLogoutWindow());
        int yOfLogoutWindow = AbstractComponent.getYofElement(AbstractComponent.getLogoutWindow());

        // clicking out of logout window
        AbstractComponent.moveAndClick(xOfLogoutWindow - 10, yOfLogoutWindow - 10);
        String urlAfter = AbstractComponent.getCurrentUrl();


        Assert.assertEquals(urlBefore,urlAfter);

    }
}
