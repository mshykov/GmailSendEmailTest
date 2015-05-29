package Tests;

import Configs.Configuration;
import Pages.GmailLoginPage;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by M. Shykov on 5/29/2015.
 * Test Cases
 */
public class SendEmailTest {

    @BeforeClass
    public static void setup() {
        Configuration.driver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDown() {
        Configuration.driver.close();
    }

    @Test
    public void loginToGmail() {
        GmailLoginPage loginPage = new GmailLoginPage(Configuration.driver);
        loginPage.open("https://www.gmail.com");


        Configuration.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
