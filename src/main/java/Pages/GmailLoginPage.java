package Pages;

import Configs.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by M. Shykov on 5/29/2015.
 * Gmail main page with login dialog
 */
public class GmailLoginPage {

    @FindBy(css = "#Email")
    WebElement emailField;

    @FindBy(css = "#next")
    WebElement nextButton;

    @FindBy(css = "#Password")
    WebElement passwordField;

    @FindBy(css = "#signIn")
    WebElement signInButton;

    public GmailLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        Configuration.driver.get(url);
    }

    public void enterString(WebElement element, String string) {

    }
}
