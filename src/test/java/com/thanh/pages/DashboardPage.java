package com.thanh.pages;

import org.openqa.selenium.By;

public class DashboardPage extends CommonPage {


    public DashboardPage() {

    }


    private By buttonLogOut = By.xpath("//a[@class='btn btn-smb btn-outline-primary rounded-pill']");
    public By menuHome = By.xpath("//span[normalize-space()='Home']");


}
