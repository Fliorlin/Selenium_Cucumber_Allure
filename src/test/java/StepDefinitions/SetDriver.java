package StepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.ConfProperties;
import pageObjects.LoginPage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.time.Duration;


public class SetDriver {
    public static LoginPage loginPage;
    public static WebDriver driver;

    @Before
    @Step("Setup driver")
    public  void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(" --ignore-certificate-errors");
        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get(ConfProperties.getProperty("loginpage"));
    }
    @After(order = 1)
    public void onTestFailure (Scenario scenario) {
        if (scenario.isFailed()) {
            String fileName = scenario.getName();
            InputStream targetStream = new ByteArrayInputStream((((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            Allure.addAttachment(fileName, "image/png", targetStream, "png");

        }
    }
    @After(order = 0)
    @Step("TearDown")
    public void tearDown() {
        driver.close();

    }

}
