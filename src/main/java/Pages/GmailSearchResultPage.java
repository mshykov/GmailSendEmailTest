package Pages;

import Configs.Configuration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by M. Shykov on 5/31/2015.
 * Page with search results
 */
public class GmailSearchResultPage {

    @FindBy(name ="q")
    WebElement searchLine;

    @FindBy(css = ".BltHke.nH.oy8Mbf[role='main']>div[gh='tl'] tbody>tr")
    List<WebElement> searchResult;

    public GmailSearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step
    public void searchEmailInInbox() {
        searchLine.sendKeys("label:inbox " + Configuration.subject + Keys.ENTER);
    }

    public int getSizeOfSearchResult() {
        try {
            Thread.sleep(1500); //milliseconds
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return searchResult.size();
    }
}
