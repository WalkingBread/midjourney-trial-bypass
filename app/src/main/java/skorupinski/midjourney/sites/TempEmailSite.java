package skorupinski.midjourney.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TempEmailSite extends Site {

    private static final String URL = "https://onetimemail.net";

    public TempEmailSite(WebDriver browser) {
        super(URL, browser);
    }

    public String getEmail() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_id")));

        WebElement emailDiv = browser.findElement(By.id("email_id"));
        String email = emailDiv.getText();

        String postfix = email.split("@")[1];

        if(postfix.split(".").length > 2) {
            WebElement deleteButton = browser.findElement(By.cssSelector("div[wire:click='deleteEmail']"));
            deleteButton.click();

            return getEmail();
        }

        return email;
    }

    public void confirmDiscordEmail() {
        waitInLoop(ExpectedConditions.presenceOfElementLocated(By.className("messages")));

        WebElement message = browser.findElement(By.className("messages"));
        message.click();
    }
}

