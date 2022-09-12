package skorupinski.midjourney.sites;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Site {

    protected final String URL;

    protected final WebDriver browser;

    protected final WebDriverWait wait;

    public Site(String URL, WebDriver browser) {
        this.URL = URL;
        this.browser = browser;
        wait = new WebDriverWait(browser, 10);
        browser.get(URL);
    }

    protected void waitInLoop(ExpectedCondition<?> ec)  {
        try {
            wait.until(ec);
        } catch (TimeoutException e) {
            waitInLoop(ec);
        }
    }

    protected void typeLikeHuman(WebElement element, String text) {
        for(char c : text.toCharArray()) {
            element.sendKeys(Character.toString(c));
        }
    }

    protected void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

