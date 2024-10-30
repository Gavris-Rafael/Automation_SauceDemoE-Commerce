package checkout;

import base.BaseTests;
import org.testng.annotations.Test;

import static constants.LoginData.*;
import static constants.CustomerInformation.*;
import static constants.URLs.*;
import static constants.Message.*;
import static org.testng.Assert.*;

public class CheckoutTest extends BaseTests {

    @Test
    public void testSuccessfulContinue(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickAddToCartButton();
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.successfulContinue(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        assertEquals(driver.getCurrentUrl(), OVERVIEW_CHECKOUT_URL, URL_MESSAGE);
    }

    @Test
    public void testGetTitlePage(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        assertEquals(checkoutFirstStepPage.getTitlePage(),"Checkout: Your Information", TITLE_MESSAGE);
    }

    @Test
    public void testClickCardItem(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        assertEquals(checkoutFirstStepPage.clickItemCard(), CART_URL, URL_MESSAGE);
    }

    @Test
    public void testContinueWithEmptyFields(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        assertEquals(checkoutFirstStepPage.continueWithEmptyFields(),
                "Error: First Name is required",
                "Wrong text error messages!");
    }

    @Test
    public void testContinueWithOnlyFirstNameFiled(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        assertEquals(checkoutFirstStepPage.continueWithOnlyFirstNameFiled(FIRST_NAME),
                "Error: Last Name is required",
                "Wrong text error messages!");
    }

    @Test
    public void testContinueWithOnlyLastNameFiled(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        assertEquals(checkoutFirstStepPage.continueWithOnlyLastNameFiled(LAST_NAME),
                "Error: First Name is required",
                "Wrong text error messages!");
    }

    @Test
    public void testContinueWithOnlyPostalCodeFiled(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        assertEquals(checkoutFirstStepPage.continueWithOnlyPostalCodeFiled(POSTAL_CODE),
                "Error: First Name is required",
                WRONG_TEXT_ERROR_MESSAGE);
    }

    @Test
    public void testContinueWithFirstNameFiledAndLastNameFiled(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        assertEquals(checkoutFirstStepPage.continueWithFirstNameFiledAndLastNameFiled(FIRST_NAME, LAST_NAME),
                "Error: Postal Code is required",
                WRONG_TEXT_MESSAGE);
    }

    @Test
    public void testIsErrorIconFieldsDisplayed(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.continueWithEmptyFields();
        assertTrue(checkoutFirstStepPage.isErrorIconFieldsDisplayed());
    }

    @Test
    public void testClickCancelButton(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.clickCancelButton();
        assertEquals(driver.getCurrentUrl(), CART_URL, URL_MESSAGE);
    }

    @Test
    public void testIsPlaceHolderTextFirstNameDisplayed(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        assertEquals(checkoutFirstStepPage.isPlaceHolderTextFirstNameFieldDisplayed(), "First Name", WRONG_TEXT_MESSAGE);
    }

    @Test
    public void testIsPlaceHolderTextLastNameDisplayed(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        assertEquals(checkoutFirstStepPage.isPlaceHolderTextLastNameFieldDisplayed(), "Last Name", WRONG_TEXT_MESSAGE);
    }

    @Test
    public void testIsPlaceHolderTextPostalCodeDisplayed(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        assertEquals(checkoutFirstStepPage.isPlaceHolderTextPostalCodeFieldDisplayed(), "Zip/Postal Code", WRONG_TEXT_MESSAGE);
    }

    @Test
    public void testCloseTheMessagesButton(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.continueWithEmptyFields();
        assertTrue(checkoutFirstStepPage.closeTheErrorMessages());
    }

}
