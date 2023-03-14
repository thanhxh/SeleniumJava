package com.thanh.pages;

import com.thanh.helpers.PropertiesHelper;
import com.thanh.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends CommonPage {
    public LoginPage() {
    }

    //Login Pages
    private By pageText = By.xpath("//h4[@class='mb-3 f-w-600']");

    private By loginBtn = By.xpath("//button[@type='submit']");
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot password?']");
    private By inputUsername = By.id("iusername");
    private By inputPassword = By.id("ipassword");


    //Forgot Password Pages
    private By pageTextForgotPassword = By.xpath("//h4[normalize-space()='Reset your password']");
    private By inputEmailForgotPassword = By.xpath("//input[@placeholder='Email address']");
    private By buttonReset = By.xpath("//button[@type='submit']");
    private By linkClickHere = By.xpath("//a[normalize-space()='Click here']");
    private By alertMessage = By.xpath("//div[@class='toast-message']");


    public DashboardPage logIn(String username, String password) {
        WebUI.openURL(PropertiesHelper.getValue("url"));
        WebUI.verifyEquals(WebUI.getElementText(pageText), "Welcome to HRSALE", "Not Login Page");
        WebUI.setText(inputUsername, username);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(loginBtn);
        //wait.until(ExpectedConditions.presenceOfElementLocated(dashboardPage.menuHome));
        boolean homeCheck = WebUI.checkElementExist(getDashboardPage().menuHome);
        Assert.assertTrue(homeCheck, "Login failed. Not found menu Home");

        return new DashboardPage(); //Khởi tạo trang DashboardPage
    }

    public void loginWithUsernameInvalid(String username, String password) {
        WebUI.openURL(PropertiesHelper.getValue("url"));
        WebUI.setText(inputUsername, username);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(loginBtn);
        //Handling Assert
        boolean checkMessageError = WebUI.checkElementExist(alertMessage);
        Assert.assertTrue(checkMessageError, "Fail. Error alert isn't displayed");
        WebUI.verifyEquals(WebUI.getElementText(alertMessage), "Invalid Login Credentials.", "Invalid message alert error ");

    }

    public void loginWithPasswordInvalid(String username, String password) {
        WebUI.openURL(PropertiesHelper.getValue("url"));
        WebUI.setText(inputUsername, username);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(loginBtn);
        //Handling Assert
        boolean checkMessageError = WebUI.checkElementExist(alertMessage);
        Assert.assertTrue(checkMessageError, "Fail. Error alert isn't displayed");
        WebUI.verifyEquals(WebUI.getElementText(alertMessage), "Invalid Login Credentials.", "Invalid message alert error ");

    }

    public void resetPassword(String emailForgot) {
        WebUI.openURL(PropertiesHelper.getValue("url"));
        WebUI.clickElement(linkForgotPassword);
        WebUI.verifyEquals(WebUI.getElementText(pageTextForgotPassword), "Reset your password", "Not Forgot Password Page");
        WebUI.setText(inputEmailForgotPassword, emailForgot);
        WebUI.clickElement(buttonReset);
        WebUI.clickElement(linkClickHere);


    }
}
