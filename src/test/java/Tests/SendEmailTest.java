package Tests;

import Configs.Configuration;
import Pages.GmailInboxPage;
import Pages.GmailLoginPage;
import Pages.GmailSearchResultPage;
import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by M. Shykov on 5/29/2015.
 * Test Cases
 */
public class SendEmailTest {

    @Before
    public void setup() {
        Configuration.driver = new FirefoxDriver();
        Configuration.driver.manage().window().maximize();
        Configuration.driver.manage().timeouts().implicitlyWait(Configuration.timeout, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        Configuration.driver.quit();
    }

    @Test
    public void sendEmailToHimself() {

        GmailLoginPage loginPage = new GmailLoginPage(Configuration.driver);
        loginPage.open(Configuration.gmailUrl);
        loginPage.enterLoginName();
        loginPage.enterPassword();

        GmailInboxPage inboxPage = new GmailInboxPage(Configuration.driver);
        assertEquals(inboxPage.getcomposeButtonName(), "COMPOSE");
        inboxPage.fillInAndSendEmail();

        GmailSearchResultPage searchResultPage = new GmailSearchResultPage(Configuration.driver);
        searchResultPage.searchEmailInInbox();
        assertEquals(searchResultPage.getSearchResult(), 1);
    }
}
