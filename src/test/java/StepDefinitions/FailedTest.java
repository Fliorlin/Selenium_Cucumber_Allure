package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;

import static StepDefinitions.SetDriver.loginPage;

public class FailedTest {
    @Given("Checkbox must be checked")
    @Step("Checkbox must be checked")
    public void textAreaTest() throws InterruptedException {
        loginPage.getCheckBox();
      Thread.sleep(7000);
    }

}
