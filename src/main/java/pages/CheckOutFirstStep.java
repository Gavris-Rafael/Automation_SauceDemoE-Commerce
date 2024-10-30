package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckOutFirstStep {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By titlePage = By.cssSelector("[class='title']");
    private final By cardItem = By.cssSelector("[class ='shopping_cart_link']");
    private final By continueButton = By.cssSelector("[class='checkout_buttons'] > #continue");
    private final By errorMessage = By.cssSelector("[class='error-message-container error']");
    private final By errorIcons = By.cssSelector("[class='svg-inline--fa fa-times-circle fa-w-16 error_icon']");
    private final By cancelButton = By.cssSelector("[class='btn btn_secondary back btn_medium cart_cancel_link']");
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By cancelErrorMessages = By.className("error-button");

    public CheckOutFirstStep (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void successfulContinue(String firstName, String lastName, String postalCode){
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
        driver.findElement(continueButton).click();
    }

    public String getTitlePage(){
        return driver.findElement(titlePage).getText();
    }

    public String clickItemCard(){
        driver.findElement(cardItem).click();
        return driver.getCurrentUrl();
    }

    public String continueWithEmptyFields(){
        driver.findElement(continueButton).click();
        return driver.findElement(errorMessage).getText();
    }

    public String continueWithOnlyFirstNameFiled(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(continueButton).click();
        return driver.findElement(errorMessage).getText();
    }

    public String continueWithOnlyLastNameFiled(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(continueButton).click();
        return driver.findElement(errorMessage).getText();
    }

    public String continueWithOnlyPostalCodeFiled(String postalCode){
        driver.findElement(postalCodeField).sendKeys(postalCode);
        driver.findElement(continueButton).click();
        return driver.findElement(errorMessage).getText();
    }

    public String continueWithFirstNameFiledAndLastNameFiled(String firstName, String lastName){
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(continueButton).click();
        return driver.findElement(errorMessage).getText();
    }

    public boolean isErrorIconFieldsDisplayed(){
        List<WebElement> icons = driver.findElements(errorIcons);
        for (WebElement element : icons) {
            if (element.isDisplayed()){
                return true;
            }
        }
        return false;
    }

    public void clickCancelButton(){
        driver.findElement(cancelButton).click();
    }

    public String isPlaceHolderTextFirstNameFieldDisplayed(){
        return driver.findElement(firstNameField).getAttribute("placeholder");
    }

    public String isPlaceHolderTextLastNameFieldDisplayed(){
        return driver.findElement(lastNameField).getAttribute("placeholder");
    }

    public String isPlaceHolderTextPostalCodeFieldDisplayed(){
        return driver.findElement(postalCodeField).getAttribute("placeholder");
    }

    public boolean closeTheErrorMessages(){
        int messagesDisplayed = 0;
        driver.findElement(cancelErrorMessages).click();
        List<WebElement> error = driver.findElements(cancelErrorMessages);
        for (WebElement errorMessages : error) {
            messagesDisplayed++;
        }
        if (messagesDisplayed == 0){
            return true;
        }
        return false;
    }
}
