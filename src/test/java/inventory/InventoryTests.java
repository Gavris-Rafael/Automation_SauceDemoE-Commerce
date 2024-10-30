package inventory;

import base.BaseTests;
import org.testng.annotations.Test;

import static constants.LoginData.*;
import static constants.URLs.*;
import static constants.Message.*;
import static org.testng.Assert.*;

public class InventoryTests extends BaseTests {

    @Test
    public void testNumberOfButtonsOfTheMenu(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickOnTheMenuButton();
        assertEquals(inventoryPage.getNumbersOfElementOfTheMenu(), 4, "Wrong numbers of buttons!");
    }

    @Test
    public void testMenuNotDisplayedAfterClose(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        assertTrue(inventoryPage.closeTheMenu());
    }

    @Test
    public void testTitleSiteIsCorrect(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        assertEquals(inventoryPage.getTitleSite(), "Swag Labs", TITLE_MESSAGE);
    }

    @Test
    public void testGetInventoryTitlePage(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        assertEquals(inventoryPage.getInventoryTitlePage(), "Products", TITLE_MESSAGE);
    }

    @Test
    public void testIsShoppingCardDisplayed(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        assertTrue(inventoryPage.isShoppingCartDisplayed());
    }

    @Test
    public void testGetSortOptionIsDisplayed(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        assertTrue(inventoryPage.isSortOptionDisplayed());
    }

    @Test
    public void testGetNumberOfOptionFromSort(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        assertEquals(inventoryPage.getNumbersOfOptionsFromSort(), 4, "The number of options are not equals!");
    }

    @Test
    public void testClickAboutButton(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        assertEquals(inventoryPage.clickOnTheAboutButton(), ABOUT_URL, URL_MESSAGE);
    }

    @Test
    public void testClickLogoutButton(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        assertEquals(inventoryPage.clickOnTheLogoutButton(), LOGIN_URL, URL_MESSAGE);
    }

    @Test
    public void testClickAddToCartButton(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        assertEquals(inventoryPage.clickAddToCartButton(), 1, "Wrong!");
    }

    @Test
    public void testGetSortProductsAscending(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        assertTrue(inventoryPage.getSortProductsAscending());
    }

    @Test
    public void testGetSortProductsDescending(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        assertTrue(inventoryPage.getSortProductsDescending());
    }

    @Test
    public void testClickCart(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        assertEquals(driver.getCurrentUrl(), CART_URL, URL_MESSAGE);
    }
}
