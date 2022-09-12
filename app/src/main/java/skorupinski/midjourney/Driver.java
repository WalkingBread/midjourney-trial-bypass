package skorupinski.midjourney;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import skorupinski.midjourney.sites.MidjourneyDiscordSite;
import skorupinski.midjourney.sites.TempEmailSite;
import skorupinski.midjourney.user.DiscordUser;
import skorupinski.midjourney.utils.Date;

import java.util.Collections;

public class Driver {

    private static final String CHROME_DRIVER_PATH = "/src/main/resources/chromedriver.exe";

    private static WebDriver initChrome() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-blink-features");
        options.addArguments("--disable-blink-features=AutomationControlled");

        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
        return driver;
    }

    public static void main(String[] args) {
        WebDriver chrome1 = initChrome();

        TempEmailSite tes = new TempEmailSite(chrome1);
        String email = tes.getEmail();

        WebDriver chrome2 = initChrome();

        MidjourneyDiscordSite mdjrn = new MidjourneyDiscordSite(chrome2);
        mdjrn.registerAccount(new DiscordUser("dupa123", email, "dupa133787", new Date(23, 11, 2000)), tes);
    }
    
}
