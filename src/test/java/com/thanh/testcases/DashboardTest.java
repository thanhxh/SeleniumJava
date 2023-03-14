package com.thanh.testcases;

import com.thanh.common.BaseTest;
import com.thanh.pages.DashboardPage;
import com.thanh.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void testOpenProject() {
        //Tạo sự liên kết trang thông qua gán dấu = từ đối tượng trang = hàm đã liên kết
        //Không cần khởi tạo trang từ đầu (dashboardPage = new DashboardPage(driver))
        dashboardPage = loginPage.logIn("frances.burns", "frances.burns"); //DashboardPage sẽ khởi tạo khi Login thành công
        dashboardPage.openProject();
    }

    @Test(priority = 2)
    public void testNavigateToProject() {
        dashboardPage = loginPage.logIn("frances.burns", "frances.burns");
        dashboardPage.openProject();
    }
}
