package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By titlePage = By.cssSelector("[class='title']");
    private final By cardItem = By.cssSelector("[class ='cart_item'");
    private final By removeButton = By.id("remove-sauce-labs-backpack");
    private final By continueShoppingButton = By.id("continue-shopping");
    private final By checkoutButton = By.id("checkout");

    public CartPage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getTitlePage(){
        return driver.findElement(titlePage).getText();
    }

    public boolean isItemCardDisplayed(){
        return driver.findElement(cardItem).isDisplayed();
    }

    public boolean clickRemoveProductButton(){
        int countButtons = 0;
        driver.findElement(removeButton).click();
        List<WebElement> rButtons = driver.findElements(removeButton);
        for (WebElement buttons : rButtons) {
            countButtons++;
        }
        if (countButtons == 0){
            return true;
        }
        return false;
    }

    public void clickContinueShoppingButton(){
        driver.findElement(continueShoppingButton).click();
    }

    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }

}
