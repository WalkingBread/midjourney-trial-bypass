package skorupinski.midjourney.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Keys;
import skorupinski.midjourney.user.DiscordUser;
import skorupinski.midjourney.utils.Date;

import java.util.List;

public class MidjourneyDiscordSite extends Site {

    private static final String URL = "https://discord.com/invite/midjourney";

    public MidjourneyDiscordSite(WebDriver browser) {
        super(URL, browser);
    }

    private void handleUsernameInput(String username) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inputDefault-3FGxgL")));

        sleep(2);

        WebElement usernameInput = browser.findElement(By.className("inputDefault-3FGxgL"));
        //usernameInput.sendKeys(user.username);
        typeLikeHuman(usernameInput, username);

        sleep(1);

        WebElement consentInput = browser.findElement(By.className("inputDefault-2F39XG"));
        consentInput.click();

        sleep(2);

        WebElement submitButton = browser.findElement(By.className("button-1cRKG6"));
        submitButton.click();
    }

    private void handleCaptcha() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("h-captcha-response")));
        waitInLoop(ExpectedConditions.invisibilityOfElementLocated(By.className("flexCenter-1Mwsxg")));
    }

    private void handleDateInput(Date date) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inputs-3ELGTz")));

        WebElement dayInputDiv = browser.findElement(By.className("day-1uOKpp"));
        dayInputDiv.findElement(By.tagName("input")).sendKeys(date.day);

        WebElement monthInputDiv = browser.findElement(By.className("month-1Z2bRu"));
        monthInputDiv.findElement(By.tagName("input")).sendKeys(date.month);
        monthInputDiv.sendKeys(Keys.ENTER);

        WebElement yearInputDiv = browser.findElement(By.className("year-3_SRuv"));
        yearInputDiv.findElement(By.tagName("input")).sendKeys(date.year);

        WebElement dateFormDiv = browser.findElement(By.className("focusLock-2tveLW"));
        dateFormDiv.findElement(By.tagName("button")).click();
    }

    private void handleRegisterInput(String email, String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("formContent-lOuJHy")));

        WebElement loginForm = browser.findElement(By.className("formContent-lOuJHy"));
        List<WebElement> inputs = browser.findElements(By.tagName("input"));

        WebElement loginInput = inputs.get(0);
        loginInput.sendKeys(email);

        WebElement passwordInput = inputs.get(1);
        passwordInput.sendKeys(password);

        loginForm.findElement(By.tagName("button")).click();
    }

    public void registerAccount(DiscordUser user, TempEmailSite tempMail) {
        handleUsernameInput(user.username);
        handleCaptcha();
        handleDateInput(user.date);
        handleRegisterInput(user.email, user.password);
    }
}
