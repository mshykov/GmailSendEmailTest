package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by M. Shykov on 5/29/2015.
 * Gmail inbox page
 */
public class GmailInboxPage {

    @FindBy(css = "[text='COMPOSE']")
    WebElement composeButton;

    @FindBy(name = "to")
    WebElement toLine;

    @FindBy(name = "subjectbox")
    WebElement emailSubject;

    @FindBy(css = "[aria-label='Message Body']")
    WebElement emailBody;

    @FindBy(css = "[text='Send']")
    WebElement sendButton;

    public GmailInboxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
