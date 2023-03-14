package com.thanh.testcases;

import com.thanh.common.BaseTest;
import com.thanh.dataprovider.DataProviderManager;
import com.thanh.helpers.ExcelHelpers;
import com.thanh.helpers.PropertiesHelper;
import com.thanh.pages.LoginPage;
import com.thanh.utils.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class LoginTest extends BaseTest {

    public LoginPage loginPage;


    @BeforeMethod
    public void loginTest() {
        loginPage = new LoginPage(); //=getLoginPage();

    }

    @Test(priority = 1, dataProvider = "data_provider_login", dataProviderClass = DataProviderManager.class)
    public void testLoginValid(String username, String password) {
        getLoginPage().logIn(username, password);
        Log.info(username + " - " + password);
    }

    @Test(priority = 7, dataProvider = "data_provider_login_from_excel", dataProviderClass = DataProviderManager.class)
    public void testLoginProviderFromExcel(String username, String password, String result) {
        loginPage.logIn(username, password);
    }

    @Test(priority = 8, dataProvider = "data_provider_login_from_excel_by_row", dataProviderClass = DataProviderManager.class)
    public void testLoginProviderFromExcelByRow(Hashtable<String, String> data) {
        loginPage.logIn(data.get("username"), data.get("password"));
    }

    @Test(priority = 5)
    public void testLoginTestValidEXCEL() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("datatest/Login.xlsx", "Sheet1"); //Khai baáo file và sheet
        loginPage.logIn(excelHelpers.getCellData("username", 1), excelHelpers.getCellData("password", 1));
    }

    @Test(priority = 6)
    public void testGetAllDataEXCEL() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("datatest/Login.xlsx", "Sheet1"); //Khai baáo file và sheet

        for (int i = 1; i <= excelHelpers.getLastRowNum(); i++) {
            System.out.println(excelHelpers.getCellData("username", i));
            System.out.println(excelHelpers.getCellData("password", i));
            System.out.println(excelHelpers.getCellData("result", i));
        }
        excelHelpers.setCellData("passed", 2, "result");
    }

    @Test(priority = 2)
    public void testLoginWithUsernameInvalid() {

        loginPage.loginWithUsernameInvalid(PropertiesHelper.getValue("usernameInvalid"), PropertiesHelper.getValue("password"));
    }

    @Test(priority = 3)
    public void testLoginWithPasswordInvalid() {

        loginPage.loginWithPasswordInvalid(PropertiesHelper.getValue("username"), PropertiesHelper.getValue("passwordInvalid"));
    }

    @Test(priority = 4)
    public void testForgotPassword() {
        loginPage.resetPassword("thanhdangxh@gmail.com");
    }
}
