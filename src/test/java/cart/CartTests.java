package cart;

import base.BaseTests;
import org.testng.annotations.Test;

import static constants.LoginData.*;
import static constants.URLs.*;
import static constants.Message.*;
import static org.testng.Assert.*;

public class CartTests extends BaseTests {

    @Test
    public void testGetTitlePage(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        assertEquals(cartPage.getTitlePage(),"Your Cart", TITLE_MESSAGE);
    }

    @Test
    public void testIsCardItemDisplayed(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickAddToCartButton();
        inventoryPage.clickCart();
        assertTrue(cartPage.isItemCardDisplayed());
    }

    @Test
    public void testClickRemoveButton(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickAddToCartButton();
        inventoryPage.clickCart();
        assertTrue(cartPage.clickRemoveProductButton());
    }

    @Test
    public void testClickContinueShoppingButton(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickContinueShoppingButton();
        assertEquals(driver.getCurrentUrl(), INVENTORY_URL, URL_MESSAGE);
    }

    @Test
    public void testClickCheckoutButton(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        assertEquals(driver.getCurrentUrl(), INFORMATION_CHECKOUT_ULR, URL_MESSAGE);
    }
}
