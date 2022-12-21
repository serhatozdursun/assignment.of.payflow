package steps.registerStep;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterStepDef {
    private String userName;

    @Given("The user that already has a bank account on register page")
    public void theUserThatAlreadyHasABankAccount(List<List<String>> data) {
        // first check if data.get(1).get(7) snn exists
        new HomePage()
                .clickRegister()
                .typeFirstName(data.get(1).get(0))
                .typeLastname(data.get(1).get(1))
                .typeAddress(data.get(1).get(2))
                .typeCity(data.get(1).get(3))
                .typeState(data.get(1).get(4))
                .typeZipcode(data.get(1).get(5))
                .typePhoneNumber(data.get(1).get(6))
                .typeSNN(data.get(1).get(7));
    }

    @And("With valid user name and {string} as password")
    public void withVALID_USER_NAMEAndVALID_PASSWORD(String password) {
        var faker = new Faker();
        new RegisterPage()
                .typeUsername(userName = faker.name().username())
                .typePassword(password)
                .typeRepeatedPassword(password);
    }

    @And("Type a {string} as username")
    public void typeUserName(String userName) {
        var faker = new Faker();
        new RegisterPage()
                .typeUsername(userName);
    }

    @And("Type a {string} as password")
    public void typePassword(String password) {
        var faker = new Faker();
        new RegisterPage()
                .typePassword(password);
    }

    @And("Type a {string} as Confirm password")
    public void typeRepPass(String password) {
        var faker = new Faker();
        new RegisterPage()
                .typeRepeatedPassword(password);
    }

    @When("Fill out the register form and click register button.")
    public void fillOutTheRegisterFormAndClickRegisterButton() {
        new RegisterPage()
                .clickRegisterButton();
    }

    @Then("Should be register successful")
    public void shouldBeRegisterSuccessful() {
        var registerPage = new RegisterPage();
        registerPage.fetchTitle().fetchWelcomeMessage();

        assertEquals("Welcome " + userName, registerPage.getTitleValue(),
                "The page title is wrong after successful registration");

        assertEquals("Your account was created successfully. You are now logged in.", registerPage.getWelcomeMsg(),
                "The successful register message is wrong after successful registration");
    }

    @Then("The repeat password error should be display on the page as {string}")
    public void theRepeatPasswordErrorShouldBeDisplayOnThePageAs(String errorMessage) {
        var registerPage = new RegisterPage();
        registerPage.fetchRepeatedPasswordError();
        assertEquals(errorMessage, registerPage.getRepeatErrorMsg(),
                "Invalid repeat error message");
    }
}
