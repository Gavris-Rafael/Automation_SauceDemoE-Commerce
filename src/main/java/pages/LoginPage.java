package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By buttonLogin = By.id("login-button");
    private final By errorMessage = By.cssSelector("div.error-message-container.error > h3");
    private final By errorIcons = By.cssSelector("div[class='form_group']");


    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void login(String username, String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(buttonLogin).click();
    }

    public String getErrorMessages(){
        String errorMessages = "";
        errorMessages = driver.findElement(errorMessage).getText();
        return errorMessages;
    }

    public boolean isErrorIconsFieldsDisplayed(){
        List<WebElement> icons = driver.findElements(errorIcons);
        for (WebElement element : icons) {
            if (element.isDisplayed()){
                return true;
            }
        }
        return false;
    }

    public String isPlaceHolderTextUsernameFieldDisplayed(){
        String textUsernameField = "";
        textUsernameField = driver.findElement(usernameField).getAttribute("placeholder");
        return textUsernameField;
    }

    public String isPlaceHolderTextPasswordFieldDisplayed(){
        String textPasswordField = "";
        textPasswordField = driver.findElement(passwordField).getAttribute("placeholder");
        return textPasswordField;
    }

}
