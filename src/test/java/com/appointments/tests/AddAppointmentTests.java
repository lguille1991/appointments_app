package com.appointments.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddAppointmentTests extends BaseTest {

    @Test(groups = "positive")
    public void validateAppointmentAdded() {
        appointmentsPage.setTxtPetName("Spunky");
        appointmentsPage.setTxtOwnerName("Guillermo Martinez");
        appointmentsPage.setTxtDate("10/15/2021");
        appointmentsPage.setTxtTime("2:00 PM");
        appointmentsPage.setTxtSymptoms("Walks with a limp");
        appointmentsPage.clickSubmitAppointment();
        String actualTitle = appointmentsPage.getAppointmentDetailsTitle();
        Assert.assertEquals(actualTitle, "MANAGE YOUR APPOINTMENTS");
    }

    @Test(groups = "positive")
    public void validateRequiredFieldsErrorMessage() {
        appointmentsPage.clickSubmitAppointment();
        appointmentsPage.reqFieldsAlertIsDisplayed();
        String actualTitle = appointmentsPage.getAppointmentDetailsTitle();
        Assert.assertEquals(actualTitle, "THERE ARE NO APPOINTMENTS");
    }

    @Test(groups = "positive")
    public void validateAppointmentIsDeleted() {
        appointmentsPage.fillOutAppointment(List.of("Spunky"
                , "Guillermo Martinez"
                , "10/15/2021"
                , "02:00 PM"
                , "Walks with a limp"));
        appointmentsPage.clickDeleteAppointment();
        String actualTitle = appointmentsPage.getAppointmentDetailsTitle();
        Assert.assertEquals(actualTitle, "THERE ARE NO APPOINTMENTS");
    }

    @Test(groups = "positive")
    public void validateAppointmentDetails() {
        List<String> expectedDetails = List.of("Pet: Spunky", "Owner: Guillermo Martinez", "Date: 2021-12-10", "Time: 02:00", "Symptoms: Walks with a limp");
        appointmentsPage.fillOutAppointment(List.of("Spunky"
                , "Guillermo Martinez"
                , "10/15/2021"
                , "02:00 PM"
                , "Walks with a limp"));
        List<String> actualDetails = appointmentsPage.getAppointmentDetails();
        Assert.assertEquals(actualDetails, expectedDetails);
    }
}
