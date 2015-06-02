package Tests;

import Configs.Configuration;
import Pages.GmailInboxPage;
import Pages.GmailLoginPage;
import Pages.GmailSearchResultPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by M. Shykov on 5/29/2015.
 * Test Cases
 */
public class SendEmailTest {

    @BeforeClass
    public static void setup() {
        Configuration.driver = new FirefoxDriver();
        Configuration.driver.manage().window().maximize();
        Configuration.driver.manage().timeouts().implicitlyWait(Configuration.timeout, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() {
        Configuration.driver.quit();
    }

    @Test
    public void sendEmailToHimself() {

        GmailLoginPage loginPage = new GmailLoginPage(Configuration.driver);
        loginPage.open("https://www.gmail.com");
        loginPage.enterLoginName();
        loginPage.enterPassword();

        GmailInboxPage inboxPage = new GmailInboxPage(Configuration.driver);
        inboxPage.fillInAndSendEmail();

        GmailSearchResultPage searchResultPage = new GmailSearchResultPage(Configuration.driver);
        searchResultPage.searchEmailInInbox();
        assertEquals(searchResultPage.getSearchResult(), 1);
    }
}
