package base;

import com.google.common.collect.Lists;
import driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Configuration;

import java.time.Duration;
import java.util.Objects;

public class BaseTest {

    protected long DEFAULT_WAIT = Configuration.instance().getIntegerValueOfProp("wait.time");
    protected long DEFAULT_SLEEP_IN_MILLIS = 500;

    private WebDriverWait getWait() {
        return new WebDriverWait(DriverManager.instance().getDriver(), Duration.ofSeconds(DEFAULT_WAIT), Duration.ofMillis(DEFAULT_SLEEP_IN_MILLIS));
    }

    protected void waitUntilPageLoad() {
        getWait().until((ExpectedCondition<Boolean>) driver ->
                String.valueOf(((JavascriptExecutor) Objects.requireNonNull(driver))
                                .executeScript("return document.readyState"))
                        .equals("complete"));
    }

    protected WebElement elementToBeClickable(WebElement elm) {
        return getWait().until(ExpectedConditions.elementToBeClickable(elm));
    }

    protected WebElement waitVisibleOfElement(WebElement elm) {
        return getWait().until(ExpectedConditions.visibilityOf(elm));
    }

    protected void clickElement(WebElement element) {
        elementToBeClickable(element).click();
    }

    protected void clickWithJavaScript(WebElement element) {
        executeJavascript("arguments[0].click()", element);
    }

    protected String getText(WebElement element) {
        return waitVisibleOfElement(element).getText();
    }

    protected void executeJavascript(String script, Object... objects) {
        ((JavascriptExecutor) DriverManager.instance().getDriver()).executeScript(script, objects);
    }

    protected void switchToFrame(WebElement element) {
        DriverManager
                .instance()
                .getDriver()
                .switchTo()
                .frame(element);
    }

    protected void sendKeys(WebElement element, String keys) {
        elementToBeClickable(element).sendKeys(keys);
    }

    protected void sendKeysCharByChar(WebElement element, String keys) {
        Lists.charactersOf(keys)
                .stream()
                .map(i -> String.valueOf(i))
                .forEach(i -> elementToBeClickable(element).sendKeys(i));
    }

    protected void switchToDefaultContent() {
        DriverManager
                .instance()
                .getDriver()
                .switchTo()
                .defaultContent();
    }

    protected void waitInvisibleOfElement(WebElement elm) {
        getWait().until(ExpectedConditions.invisibilityOf(elm));
    }
}
