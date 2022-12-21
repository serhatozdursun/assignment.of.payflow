package pages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BaseTest implements Page {
    private String titleValue;
    private String welcomeMsg;
    private String repeatErrorMsg;
    public RegisterPage() {
        initPage(this);
    }

    @FindBy(id = "customer.firstName")
    private WebElement firstname;
    @FindBy(id = "customer.lastName")
    private WebElement lastname;
    @FindBy(id = "customer.address.street")
    private WebElement address;
    @FindBy(id = "customer.address.city")
    private WebElement city;
    @FindBy(id = "customer.address.state")
    private WebElement state;
    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCode;
    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneNumber;
    @FindBy(id = "customer.ssn")
    private WebElement ssn;
    @FindBy(id = "repeatedPassword")
    private WebElement repeatedPassword;
    @FindBy(id = "customer.password")
    private WebElement password;
    @FindBy(id = "customer.username")
    private WebElement username;
    @FindBy(css = "input[value='Register']")
    private WebElement registerButton;
    @FindBy(tagName = "h1")
    private WebElement title;
    @FindBy(css = "#rightPanel p")
    private WebElement welcome;
    @FindBy(id = "repeatedPassword.errors")
    private WebElement repeatError;

    public RegisterPage typeFirstName(String firstnameValue) {
        sendKeys(firstname, firstnameValue);
        return this;
    }

    public RegisterPage typeLastname(String lastnameValue) {
        sendKeys(lastname, lastnameValue);
        return this;
    }

    public RegisterPage typeAddress(String addressValue) {
        sendKeys(address, addressValue);
        return this;
    }

    public RegisterPage typeCity(String cityValue) {
        sendKeys(city, cityValue);
        return this;
    }

    public RegisterPage typeState(String stateValue) {
        sendKeys(state, stateValue);
        return this;
    }

    public RegisterPage typePhoneNumber(String phoneNumberValue) {
        sendKeys(phoneNumber, phoneNumberValue);
        return this;
    }

    public RegisterPage typeSNN(String snnValue) {
        sendKeys(ssn, snnValue);
        return this;
    }

    public RegisterPage typeRepeatedPassword(String repeatedPasswordValue) {
        sendKeys(repeatedPassword, repeatedPasswordValue);
        return this;
    }

    public RegisterPage typeUsername(String UsernameValue) {
        sendKeys(username, UsernameValue);
        return this;
    }

    public RegisterPage typePassword(String passwordValue) {
        sendKeys(password, passwordValue);
        return this;
    }

    public RegisterPage typeZipcode(String zipcodeValue) {
        sendKeys(zipCode, zipcodeValue);
        return this;
    }

    public RegisterPage clickRegisterButton(){
        clickElement(registerButton);
        return this;
    }

    public RegisterPage fetchTitle(){
        titleValue=getText(title);
        return this;
    }

    public RegisterPage fetchWelcomeMessage(){
        welcomeMsg=getText(welcome);
        return this;
    }

    public RegisterPage fetchRepeatedPasswordError(){
        repeatErrorMsg=getText(repeatError);
        return this;
    }
    public String getTitleValue(){
        return titleValue;
    }

    public String getWelcomeMsg(){
        return welcomeMsg;
    }

    public String getRepeatErrorMsg(){
        return repeatErrorMsg;
    }
}
