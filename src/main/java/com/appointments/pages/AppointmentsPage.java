package com.appointments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AppointmentsPage extends BasePage {

    private By txtPetName = By.cssSelector("input[data-testid='pet']");
    private By txtOwnerName = By.cssSelector("input[data-testid='owner']");
    private By txtDate = By.cssSelector("input[data-testid='date']");
    private By txtTime = By.cssSelector("input[data-testid='time']");
    private By txtSymptoms = By.cssSelector("textarea[data-testid='symptoms']");
    private By btnAddAppointment = By.cssSelector("button[data-testid='btn-submit']");
    private By msgRequiredFields = By.cssSelector("p[data-testid='alert']");
    private By divAppSummary = By.cssSelector("div[data-testid='appointment']");
    private By titleAppSummary = By.cssSelector("h2[data-testid='dynamic-title']");
    private By btnDelete = By.cssSelector("button[data-testid='btn-delete']");

    public AppointmentsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method expects a list of strings to set the following values petName, ownerName, date, time and symptoms.
     *
     * @param details
     */
    public void fillOutAppointment(List<String> details) {
        type(details.get(0), txtPetName);
        type(details.get(1), txtOwnerName);
        type(details.get(2), txtDate);
        type(details.get(3), txtTime);
        type(details.get(4), txtSymptoms);
        clickSubmitAppointment();
    }

    public void setTxtPetName(String petName) {
        type(petName, txtPetName);
    }

    public void setTxtOwnerName(String owner) {
        type(owner, txtOwnerName);
    }

    public void setTxtDate(String date) {
        type(date, txtDate);
    }

    public void setTxtTime(String time) {
        type(time, txtTime);
    }

    public void setTxtSymptoms(String symptoms) {
        type(symptoms, txtSymptoms);
    }

    public void clickSubmitAppointment() {
        click(btnAddAppointment);
    }

    public String getAppointmentDetailsTitle() {
        return find(titleAppSummary).getText();
    }

    public Boolean reqFieldsAlertIsDisplayed() {
        return find(msgRequiredFields).isDisplayed();
    }

    public void clickDeleteAppointment() {
        click(btnDelete);
    }

    public List<String> getAppointmentDetails() {
        List<WebElement> summaryContainers = findMany(divAppSummary);
        List<WebElement> summaryDetails = summaryContainers.get(0).findElements(By.tagName("p"));
        List<String> actualDetails = new ArrayList<>();
        for (WebElement detail : summaryDetails) {
            actualDetails.add(detail.getText());
        }
        return actualDetails;
    }
}
