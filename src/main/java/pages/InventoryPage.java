package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class InventoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By menuButton = By.id("react-burger-menu-btn");
    private final By closeMenuButton = By.id("react-burger-cross-btn");
    private final By buttonsInMenu = By.cssSelector("[class='bm-item menu-item']");
    private final By inventoryTitlePage = By.cssSelector("[class='title']");
    private final By shoppingCart = By.id("shopping_cart_container");
    private final By sortOptions = By.cssSelector("[class='select_container']");
    private final By optionsFromSort = By.cssSelector("[class='product_sort_container'] > option");
    private final By ascendingSort = By.cssSelector("[class='product_sort_container'] > option:nth-child(3)");
    private final By descendingSort = By.cssSelector("[class='product_sort_container'] > option:nth-child(4)");
    private final By productPrice = By.cssSelector("inventory_item_price");
    private final By aboutButton = By.id("about_sidebar_link");
    private final By logoutButton = By.id("logout_sidebar_link");
    private final By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    private final By bikeLightItem = By.id("add-to-cart-sauce-labs-bike-light");
    private final By jacketItem = By.id("add-to-cart-sauce-labs-fleece-jacket");


    public InventoryPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickOnTheMenuButton(){
        driver.findElement(menuButton).click();
    }

    public boolean closeTheMenu(){
        driver.findElement(menuButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeMenuButton));
        driver.findElement(closeMenuButton).click();
        return driver.findElement(closeMenuButton).isDisplayed();
    }

    public int getNumbersOfElementOfTheMenu(){
        int numberOfButtons = 0;
        List<WebElement> buttons = driver.findElements(buttonsInMenu);
        for (WebElement button : buttons){
            numberOfButtons ++;
        }
        return numberOfButtons;
    }

    public String getTitleSite(){
        return driver.getTitle();
    }

    public String getInventoryTitlePage(){
        return driver.findElement(inventoryTitlePage).getText();
    }

    public boolean isShoppingCartDisplayed(){
        if (driver.findElement(shoppingCart).isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean isSortOptionDisplayed(){
        if (driver.findElement(sortOptions).isDisplayed()){
            return true;
        }
        return false;
    }

    public int getNumbersOfOptionsFromSort(){
        driver.findElement(sortOptions).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionsFromSort));
        int numberOfOptions = 0;
        List<WebElement> options = driver.findElements(optionsFromSort);
        for (WebElement option : options){
            numberOfOptions ++;
        }
        return numberOfOptions;
    }

    public String clickOnTheAboutButton(){
        driver.findElement(menuButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutButton));
        driver.findElement(aboutButton).click();
        return driver.getCurrentUrl();
    }

    public String clickOnTheLogoutButton(){
        driver.findElement(menuButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
        return driver.getCurrentUrl();
    }

    public Integer clickAddToCartButton(){
        driver.findElement(addToCart).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCart));
        return Integer.parseInt(driver.findElement(shoppingCart).getText());
    }

    public void addMultipleProductsInCart(){
        driver.findElement(bikeLightItem).click();
        driver.findElement(jacketItem).click();
    }

    public boolean getSortProductsAscending(){
        driver.findElement(sortOptions).click();
        driver.findElement(ascendingSort).click();

        List<WebElement> products = driver.findElements(productPrice);
        List<Double> prices = new ArrayList<>();

        for (WebElement product : products) {
            WebElement priceElement = product.findElement(productPrice);
            String priceText = priceElement.getText();
            Double price = Double.parseDouble(priceText.replace("$", ""));
            prices.add(price);
        }

        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean getSortProductsDescending(){
        driver.findElement(sortOptions).click();
        driver.findElement(descendingSort).click();

        List<WebElement> products = driver.findElements(By.cssSelector("inventory_item_price"));
        List<Double> prices = new ArrayList<>();

        for (WebElement product : products) {
            WebElement priceElement = product.findElement(By.cssSelector("inventory_item_price"));
            String priceText = priceElement.getText();
            Double price = Double.parseDouble(priceText.replace("$", ""));
            prices.add(price);
        }

        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) < prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void clickCart(){
        driver.findElement(shoppingCart).click();
    }

}
