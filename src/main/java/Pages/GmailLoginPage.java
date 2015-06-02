package Pages;

import Configs.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by M. Shykov on 5/29/2015.
 * Gmail main page with login dialog
 */
public class GmailLoginPage {

    @FindBy(css = "#Email")
    WebElement emailField;

    @FindBy(css = "#next")
    WebElement nextButton;

    @FindBy(css = "#Passwd")
    WebElement passwordField;

    @FindBy(css = "#signIn")
    WebElement signInButton;

    public GmailLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        Configuration.driver.get(url);
    }

    @Step
    public void enterLoginName() {
        emailField.sendKeys(Configuration.loginName);
        nextButton.click();
    }

    @Step
    public void enterPassword(){
        passwordField.sendKeys(Configuration.password);
        signInButton.click();
    }
}
