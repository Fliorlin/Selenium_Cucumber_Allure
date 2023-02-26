package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;

import static StepDefinitions.SetDriver.loginPage;

public class FormTest {
    @Given("Fill TextField")
    @Step("Fill TextField")
    public void textAreaTest() {
        loginPage.fillText();
    }
    @Then("Fill Password")
    @Step("Fill Password")
    public void fillPassTest() {
        loginPage.fillPass();
    }
    @Then("Check disabled field")
    @Step("Check disabled field")
    public void disabledCheckTest() {
        loginPage.disabledCheck();
    }
    @Then("Click Submit button")
    @Step("Click Submit button")
    public void submitTest() {
        loginPage.clickSubmit();
    }
    @Then("Check Status Message")
    @Step("Check Status Message")
    public void statusTest() {
        loginPage.getMessage();
    }
}
