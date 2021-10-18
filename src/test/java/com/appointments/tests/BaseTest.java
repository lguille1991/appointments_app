package com.appointments.tests;

import com.appointments.pages.AppointmentsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost:3000/";
    protected AppointmentsPage appointmentsPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        appointmentsPage = new AppointmentsPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
