package Configs;

import org.openqa.selenium.WebDriver;

import java.util.UUID;

/**
 * Created by M. Shykov on 5/29/2015.
 * Configurations
 */
public class Configuration {
    public static WebDriver driver;
    public static int timeout = 15;
    public static String gmailUrl = "https://www.gmail.com";
    public static String loginName = "max.itlabs.net@gmail.com";
    public static String password = "qweasdzxc!23";
    public static String subject = UUID.randomUUID().toString();
}
