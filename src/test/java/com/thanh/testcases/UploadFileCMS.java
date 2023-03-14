package com.thanh.testcases;

import com.thanh.common.BaseTest;
import com.thanh.helpers.Helpers;
import com.thanh.pages.UploadFileCMSPage;
import com.thanh.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class UploadFileCMS extends BaseTest {
    @Test
    public void testUploadFileWithSendKeys() throws InterruptedException {
        WebUI.openURL("https://cgi-lib.berkeley.edu/ex/fup.html");
        WebUI.waitForPageLoaded();
        By inputFileUpload = By.xpath("//input[@name='upfile']");

        //DriverManager.getDriver().findElement(inputFileUpload).sendKeys(Helpers.getCurrentDir() + "datatest/Selenium4_Upload.png");
        WebUI.setText(inputFileUpload, Helpers.getCurrentDir() + "datatest/Selenium4_Upload.jpg");
        Thread.sleep(3000);
    }

    @Test
    public void testUploadFileInCategoryCMS() {
        UploadFileCMSPage uploadFileCMSPage = new UploadFileCMSPage();
        uploadFileCMSPage.loginCMS();
        uploadFileCMSPage.uploadFileInCategory();
    }

}
