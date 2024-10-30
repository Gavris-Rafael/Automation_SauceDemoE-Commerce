package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OverviewPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By finishButton = By.cssSelector("[class='cart_footer'] > #finish");
    private final By titlePage = By.cssSelector("[class='title']");
    private final By cardItem = By.cssSelector("[class ='shopping_cart_link'");
    private final By cancelButton = By.cssSelector("[class='cart_footer'] > #cancel");
    private final By cartItem = By.cssSelector("[class='inventory_item_price']");
    private final By totalItemsPrice = By.cssSelector("[class='summary_total_label']");
    private final By tax = By.cssSelector("[class='summary_tax_label']");
    private final By paymentInformation = By.cssSelector("[class='summary_info'] > div:nth-child(1)");
    private final By shippingInformation = By.cssSelector("[class='summary_info'] > div:nth-child(3)");
    private final By priceTotal = By.cssSelector("[class='summary_info'] > div:nth-child(5)");


    public OverviewPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }

    public String getTitlePage(){
        return driver.findElement(titlePage).getText();
    }

    public void clickItemCard(){
        driver.findElement(cardItem).click();
    }

    public void clickCancelButton(){
        driver.findElement(cancelButton).click();
    }

    public boolean isCartItemDisplayed(){
        return driver.findElement(cardItem).isDisplayed();
    }

    public double getCartItemsPrice(){
        double totalItemsPrice = 0;
        List<WebElement> prices = driver.findElements(cartItem);
        for (WebElement element : prices) {
            String priceText = element.getText();
            priceText = priceText.replace("$", "");
            totalItemsPrice += Double.parseDouble(priceText);
        }
        String taxText = driver.findElement(tax).getText();
        double taxNumber = Double.parseDouble(taxText.replace("Tax: $", ""));

        return (totalItemsPrice+taxNumber);
    }

    public double getTotalItemsPrice(){
        String priceText = driver.findElement(totalItemsPrice).getText();
        priceText = priceText.replace("Total: $", "");
        return Double.parseDouble(priceText);
    }

    public String getPaymentInformationText(){
        return driver.findElement(paymentInformation).getText();
    }

    public String getShippingInformationText(){
        return driver.findElement(shippingInformation).getText();
    }

    public String getPriceTotalText(){
        return driver.findElement(priceTotal).getText();
    }
}
