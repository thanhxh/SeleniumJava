package com.thanh.testcases;

import com.thanh.common.BaseTest;
import com.thanh.pages.DashboardPage;
import com.thanh.pages.LoginPage;
import com.thanh.pages.ProjectPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public ProjectPage projectPage;

    @BeforeMethod
    public void setup() {

        loginPage = new LoginPage();
    }


    @Test(priority = 1)
    public void testAddProject() {
        dashboardPage = loginPage.logIn("frances.burns", "frances.burns");
        projectPage = dashboardPage.openProject();
        projectPage.addProject("THANHDT712A1", "Cedric Kelly", "100",
                "07", "20", "Note");
    }

    @Test(priority = 2)
    public void testNavigateToTask() {
        dashboardPage = loginPage.logIn("frances.burns", "frances.burns");
        projectPage = dashboardPage.openProject();
        projectPage.openTask();
    }

}
