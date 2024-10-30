package overview;

import base.BaseTests;
import org.testng.annotations.Test;

import static constants.LoginData.*;
import static constants.CustomerInformation.*;
import static constants.URLs.*;
import static constants.Message.*;
import static org.testng.Assert.*;

public class OverviewTest extends BaseTests {

    @Test
    public void testClickFinishButton(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickAddToCartButton();
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.successfulContinue(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        overviewPage.clickFinishButton();
        assertEquals(driver.getCurrentUrl(), COMPLETE_CHECKOUT_URL, URL_MESSAGE);
    }

    @Test
    public void testGetTitlePage(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.successfulContinue(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        assertEquals(overviewPage.getTitlePage(),"Checkout: Overview", TITLE_MESSAGE);
    }

    @Test
    public void testClickCardItem(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.successfulContinue(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        overviewPage.clickItemCard();
        assertEquals(driver.getCurrentUrl(), CART_URL, URL_MESSAGE);
    }

    @Test
    public void testClickCancelButton(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.successfulContinue(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        overviewPage.clickCancelButton();
        assertEquals(driver.getCurrentUrl(), INVENTORY_URL, URL_MESSAGE);
    }

    @Test
    public void testCartItemIsDisplayed(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.successfulContinue(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        assertTrue(overviewPage.isCartItemDisplayed());
    }

    @Test
    public void testTotalItemsPrice(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.addMultipleProductsInCart();
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.successfulContinue(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        assertEquals(overviewPage.getCartItemsPrice(),
                overviewPage.getTotalItemsPrice(),
                "The prices is not the same!");
    }

    @Test
    public void testGetPaymentInformationText(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.successfulContinue(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        assertEquals(overviewPage.getPaymentInformationText(), "Payment Information:", WRONG_TEXT_MESSAGE);
    }

    @Test
    public void testGetShippingInformationText(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.successfulContinue(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        assertEquals(overviewPage.getShippingInformationText(), "Shipping Information:", WRONG_TEXT_MESSAGE);
    }

    @Test
    public void testGetPriceTotalText(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.successfulContinue(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        assertEquals(overviewPage.getPriceTotalText(), "Price Total", WRONG_TEXT_MESSAGE);
    }
}
