
import Configs.Configuration;
import Pages.GmailLoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by M. Shykov on 5/29/2015.
 * Test Cases
 */
public class GmailSendEmailTest {

    @Before
    public void openBrowser() {
        Configuration.driver = new ChromeDriver();
    }

    @After
    public void closeBrowser() {
        Configuration.driver.close();
    }

    @Test
    public void loginToGmail() {
        GmailLoginPage loginPage = new GmailLoginPage(Configuration.driver);

        Configuration.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
