package com.thanh.testcases;

import com.thanh.common.BaseTest;
import com.thanh.driver.DriverManager;
import com.thanh.helpers.CaptureHelpers;
import com.thanh.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LearnScreenshot extends BaseTest {

    @BeforeClass
    public void setUpClass() {
        CaptureHelpers.startRecord("LearnScreenshot");
    }


//    @Test(priority = 1, dataProvider = "data_provider_login", dataProviderClass = DataProviderManager.class)
//    public void testLoginValid(String username, String password) {
//        getLoginPage().logIn(username, password);
//        CaptureHelpers.takeScreenshot("testLoginValid");
//    }
//
//    @Test(priority = 2, dataProvider = "data_provider_login_from_excel", dataProviderClass = DataProviderManager.class)
//    public void testLoginProviderFromExcel(String username, String password, String result) {
//        loginPage.logIn(username, password);
//    }

//    @Test(priority = 3, dataProvider = "data_provider_login_from_excel_by_row", dataProviderClass = DataProviderManager.class)
//    public void testLoginProviderFromExcelByRow(Hashtable<String, String> data) {
//        getLoginPage().logIn(data.get("username"), data.get("password"));
//    }

    @Test(priority = 2)
    public void homePage() {
        WebUI.openURL("https://anhtester.com");
        //step này cố tình Fail để chụp màn hình lại
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Anh Tester - Automation Testing");
    }

    @Test(priority = 3)
    public void loginPage() {
        WebUI.openURL("https://anhtester.com");
        WebUI.clickElement(By.id("btn-login"));
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Selenium");
    }

    @AfterClass
    public void afterClass() {
        CaptureHelpers.stopRecord();
    }
}