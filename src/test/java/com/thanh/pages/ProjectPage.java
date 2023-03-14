package com.thanh.pages;

import com.thanh.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProjectPage extends CommonPage {

    public ProjectPage() {

    }

    public String pageText = "Projects";
    public By headerPage = By.xpath("//li[contains(text(),'Projects')]");
    private By addNewProject = By.xpath("//h5[contains(text(),'Add New')]");
    private By buttonAddProject = By.xpath("//a[normalize-space()='Add Project']");
    private By inputTitle = By.xpath("//input[@placeholder='Title']");
    private By dropdownClients = By.xpath("//span[@id='select2-client_id-container']");
    private By inputClients = By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']");
    private By estimatedHours = By.name("budget_hours");
    private By dropdownPriority = By.xpath("//label[normalize-space()='Priority']//following-sibling::span");
    private By inputPriority = By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']");
    private By startDateBtn = By.xpath("//label[contains(text(),'Start Date')]//following-sibling::div");
    private By endDateBtn = By.xpath("//label[contains(text(),'End Date')]//following-sibling::div");
    private By buttonOKStart = By.xpath("(//button[normalize-space()='OK'])[1]");
    private By buttonOkEnd = By.xpath("(//button[normalize-space()='OK'])[2]");
    private By inputSummary = By.name("summary");
    private By buttonSave = By.xpath("//span[normalize-space()='Save']");


    public void clickButtonAddProject() {
        WebUI.clickElement(buttonAddProject);
    }

    public void startAndEndDate(String startDate, String endDate) {
        WebUI.clickElement(startDateBtn);
        WebUI.clickElement(By.xpath("//a[normalize-space()='" + startDate + "']"));
        WebUI.clickElement(buttonOKStart);
        WebUI.clickElement(endDateBtn);
        WebUI.clickElement(By.xpath("(//a[normalize-space()='" + endDate + "'])[2]"));
        WebUI.clickElement(buttonOkEnd);
    }

    public void addProject(String title, String client, String estimated, String startDate, String endDate, String summary) {
        clickButtonAddProject();
        Assert.assertEquals(WebUI.getElementText(addNewProject), "Add New Project", "Fail.Not Add New Project page");
        enterValues(title, client, estimated);
        startAndEndDate(startDate, endDate);
        WebUI.setText(inputSummary, summary);
        WebUI.scrollToElement(buttonSave);
        WebUI.clickElement(buttonSave);
    }

    public void enterValues(String title, String client, String estimated) {
        WebUI.setText(inputTitle, title);
        WebUI.clickElement(dropdownClients);
        WebUI.setText(inputClients, client);
        WebUI.pressENTER();
        WebUI.setText(estimatedHours, estimated);

    }


}
