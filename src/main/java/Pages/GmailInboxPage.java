package Pages;

import Configs.Configuration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by M. Shykov on 5/29/2015.
 * Gmail inbox page
 */
public class GmailInboxPage {

    @FindBy(xpath = "//*[contains(text(),'COMPOSE')]")
    WebElement composeButton;

    @FindBy(name = "to")
    WebElement toLine;

    @FindBy(name = "subjectbox")
    WebElement emailSubject;

    @FindBy(css = "div[aria-label='Message Body']")
    WebElement emailBody;

    @FindBy(xpath = "//*[contains(text(),'Send')]")
    WebElement sendButton;

    public GmailInboxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getcomposeButtonName() {
        new WebDriverWait(Configuration.driver, Configuration.timeout).until(
                ExpectedConditions.textToBePresentInElement(composeButton, "COMPOSE"));
        return composeButton.getText();
    }

    @Step
    public void openNewEmailForm() {
        composeButton.click();
    }

    @Step
    public void fillInToLine() {
        toLine.sendKeys(Configuration.loginName + Keys.TAB);
    }

    @Step
    public void fillInSubject() {
        emailSubject.sendKeys(Configuration.subject + Keys.TAB);
    }

    @Step
    public void fillInBody() {
        emailBody.sendKeys("Hello World");
    }

    @Step
    public void sendEmail() {
        sendButton.click();
    }

    public void fillInAndSendEmail() {
        openNewEmailForm();
        fillInToLine();
        fillInSubject();
        fillInBody();
        sendEmail();
    }
}
