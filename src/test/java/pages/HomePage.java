package pages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseTest implements Page {

    public HomePage() {
        initPage(this);
    }

    @FindBy(xpath = "//div[@id='leftPanel']//a[text()='Register']")
    public WebElement register;

    public RegisterPage clickRegister() {
        clickElement(register);
        return new RegisterPage();
    }
}
