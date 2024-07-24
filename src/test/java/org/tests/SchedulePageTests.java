package org.tests;

import org.abstractComponents.AbstractComponent;
import org.pageObjects.MyCoursesPage;
import org.pageObjects.SchedulePage;
import org.resources.Config;
import testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SchedulePageTests extends BaseTest {
    @Test (groups = {"regression"})
    public void testSuccessfulLogOut(){
        MyCoursesPage MyCoursesPage = loginPage.loginWithValidCredentials(Config.getProperty("studentLogin"),Config.getProperty("studentPassword"));
        String urlBeforeLogout = AbstractComponent.getCurrentUrl();
        AbstractComponent.goToSchedulePage();
        AbstractComponent.logOut();
        String urlAfterLogout = AbstractComponent.getCurrentUrl();
        Assert.assertNotEquals(urlBeforeLogout,urlAfterLogout);
    }
    @Test (groups = {"regression"})
    public void testWithClickingOutsideBox(){
        MyCoursesPage MyCoursesPage = loginPage.loginWithValidCredentials(Config.getProperty("studentLogin"),Config.getProperty("studentPassword"));
        AbstractComponent.goToSchedulePage();

        AbstractComponent.openLogoutWindow();
        String urlBefore = AbstractComponent.getCurrentUrl();

        System.out.println(urlBefore);

        int xOfLogoutWindow = AbstractComponent.getXofElement(AbstractComponent.getLogoutWindow());
        int yOfLogoutWindow = AbstractComponent.getYofElement(AbstractComponent.getLogoutWindow());

        // clicking out of logout window
        AbstractComponent.moveAndClick(xOfLogoutWindow - 50, yOfLogoutWindow - 50);
        String urlAfter = AbstractComponent.getCurrentUrl();
        System.out.println(urlAfter);

        Assert.assertNotEquals(urlBefore,urlAfter);
    }

    @Test(groups = {"regression"})
    public void testIsSchedulePresentsMonth() {
        MyCoursesPage MyCoursesPage = loginPage.loginWithValidCredentials(Config.getProperty("studentLogin"), Config.getProperty("studentPassword"));
        AbstractComponent.goToSchedulePage();
        SchedulePage schedulePage = AbstractComponent.goToSchedulePage();
        Assert.assertTrue(schedulePage.eventTest.getText().contains("Test event"));

    }

    @Test(groups = {"regression"})
    public void testURLChanges() throws InterruptedException {
        MyCoursesPage MyCoursesPage = loginPage.loginWithValidCredentials(Config.getProperty("studentLogin"), Config.getProperty("studentPassword"));
        AbstractComponent.goToSchedulePage();
        SchedulePage schedulePage = AbstractComponent.goToSchedulePage();
        String urlBefore = AbstractComponent.getCurrentUrl();
        System.out.println(urlBefore+"URL Before click Button");
        Thread.sleep(1000);
        schedulePage.kufhkButton.click();
        String urlAfter = AbstractComponent.getCurrentUrl();
        System.out.println(urlAfter + "URL AFTER click Button");
        Assert.assertNotEquals(urlBefore,(urlAfter));

    @Test
    public void testMonth() {
        MyCoursesPage MyCoursesPage = loginPage.loginWithValidCredentials(Config.getProperty("studentLogin"),Config.getProperty("studentPassword"));
        AbstractComponent.goToSchedulePage();
        SchedulePage schedulePage = new SchedulePage();

    }



    }
    @Test(groups = {"regression"})
    public void testIsSchedulePresentsWeek() {
        MyCoursesPage MyCoursesPage = loginPage.loginWithValidCredentials(Config.getProperty("studentLogin"), Config.getProperty("studentPassword"));
        AbstractComponent.goToSchedulePage();
        SchedulePage schedulePage = AbstractComponent.goToSchedulePage();
        schedulePage.dropdown.click();
        schedulePage.weekDropdown.click();
        Assert.assertTrue(schedulePage.testSchedule.getText().contains("Test Shedule"));

    }

    @Test(groups = {"regression"})
    public void testIsSchedulePresentsDay() {
        MyCoursesPage MyCoursesPage = loginPage.loginWithValidCredentials(Config.getProperty("studentLogin"), Config.getProperty("studentPassword"));
        AbstractComponent.goToSchedulePage();
        SchedulePage schedulePage = AbstractComponent.goToSchedulePage();
        schedulePage.dropdown.click();
        schedulePage.dayDropdown.click();
        schedulePage.nextButton.click();
        System.out.println(schedulePage.russTesting.getText());
        Assert.assertEquals("Russ Testing", schedulePage.russTesting.getText());

    }
}