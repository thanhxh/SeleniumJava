package com.thanh.pages;

import com.thanh.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CommonPage {

    public CommonPage() {
    }

    //Khai báo đối tượng cho class chung
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public ProjectPage projectPage;
    public TaskPage taskPage;
    public LoginHRMPage loginHRMPage;

    //common object
    public By headerPage = By.xpath("//li[@class='nav-item active']/a");
    public By buttonLogOut = By.xpath("//div[@class='page-header']//a[normalize-space()='Logout']");
    private By menuProject = By.xpath("//span[normalize-space()='Projects']");
    private By menuTasks = By.xpath("//span[normalize-space()='Tasks']");

    public LoginPage logOut() {
        WebUI.clickElement(buttonLogOut);
        return new LoginPage();
    }

    public ProjectPage openProject() {

        WebUI.clickElement(menuProject);
        boolean checkPage = WebUI.checkElementExist(headerPage);
        Assert.assertTrue(checkPage, "Fail.Not open project page,Element not found" + headerPage + "");
        String checkText = WebUI.getElementText(headerPage);
        Assert.assertTrue(checkText.contains(getProjectPage().pageText), "Fail. Text of header Project page not match");
        return new ProjectPage();

    }

    public TaskPage openTask() {
        WebUI.clickElement(menuTasks);
        boolean checkPage = WebUI.checkElementExist(headerPage);
        Assert.assertTrue(checkPage, "Fail.Not open project page,Element not found" + headerPage + "");
        String checkText = WebUI.getElementText(headerPage);
        Assert.assertTrue(checkText.contains(getTaskPage().pageText), "Fail. Text of header Project page not match");
        return new TaskPage();

    }

    //Khởi tạo giá trị cho tất cả đối tượng class ở trên
    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public DashboardPage getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public ProjectPage getProjectPage() {
        if (projectPage == null) {
            projectPage = new ProjectPage();
        }
        return projectPage;
    }

    public TaskPage getTaskPage() {
        if (taskPage == null) {
            taskPage = new TaskPage();
        }
        return taskPage;
    }

    public LoginHRMPage getLoginHRMPage() {
        if (loginHRMPage == null) {
            loginHRMPage = new LoginHRMPage();
        }
        return loginHRMPage;
    }
}
