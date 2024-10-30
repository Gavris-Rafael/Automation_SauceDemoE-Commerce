package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompletePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By BackHomeButton = By.id("back-to-products");
    private final By titlePage = By.cssSelector("[class='title']");
    private final By cardItem = By.cssSelector("[class ='shopping_cart_link'");
    private final By image = By.cssSelector("[class='pony_express']");
    private final By thankYouText = By.cssSelector("[class='complete-header']");
    private final By bodyText = By.cssSelector("[class='complete-text']");

    public CompletePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickBackHomeButton(){
        driver.findElement(BackHomeButton).click();
    }

    public String getTitlePage(){
        return driver.findElement(titlePage).getText();
    }

    public void clickItemCard(){
        driver.findElement(cardItem).click();
    }

    public boolean isImageDisplayed(){
        return driver.findElement(image).isDisplayed();
    }

    public String getThanksText(){
        return driver.findElement(thankYouText).getText();
    }

    public String getBodyText(){
        return driver.findElement(bodyText).getText();
    }
}
