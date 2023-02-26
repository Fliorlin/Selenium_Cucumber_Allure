package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LoginPage {
    public WebDriver driver ;

    public LoginPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(name = "my-text" )
    public WebElement textBox;
    @FindBy(css = "button")
    public  WebElement submitButton;
    @FindBy(name = "my-password" )
    public WebElement passwordField;
    @FindBy(name = "my-disabled" )
    public WebElement disabledField;
    @FindBy(id = "message" )
    public WebElement message;
    @FindBy(id = "my-check-1")
    public WebElement checkbox;
    @FindBy(id = "my-check-2")
    public WebElement checkbox2;

   public void fillText(){
       textBox.sendKeys("Selenium");
    }
    public void fillPass(){
       passwordField.sendKeys(ConfProperties.getProperty("password"));
    }

    public void disabledCheck(){
    String prop = disabledField.getAttribute("disabled");
    assertTrue(Boolean.parseBoolean(prop));}

    public void clickSubmit(){
        submitButton.click();
   }
    public void getMessage(){
    String value = message.getText();
    System.out.println(value);
    assertEquals("Received!", value);
    }
    public void getCheckBox(){
       String prop = checkbox.getAttribute("checked");
        assertTrue(Boolean.parseBoolean(prop));
        String prop2 = checkbox2.getAttribute("checked");
        assertTrue(Boolean.parseBoolean(prop2));
    }
}
