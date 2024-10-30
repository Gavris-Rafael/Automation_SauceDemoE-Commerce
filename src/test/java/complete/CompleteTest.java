package complete;

import base.BaseTests;
import org.testng.annotations.Test;

import static constants.LoginData.*;
import static constants.CustomerInformation.*;
import static constants.URLs.*;
import static constants.Message.*;
import static org.testng.Assert.*;

public class CompleteTest extends BaseTests {

    @Test
    public void testClickBackHomeButton(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.successfulContinue(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        overviewPage.clickFinishButton();
        completePage.clickBackHomeButton();
        assertEquals(driver.getCurrentUrl(), INVENTORY_URL, URL_MESSAGE);
    }

    @Test
    public void testGetTitlePage(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.successfulContinue(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        overviewPage.clickFinishButton();
        assertEquals(completePage.getTitlePage(),"Checkout: Complete!", TITLE_MESSAGE);
    }

    @Test
    public void testGetCardItem(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.successfulContinue(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        overviewPage.clickFinishButton();
        completePage.clickItemCard();
        assertEquals(driver.getCurrentUrl(), CART_URL, URL_MESSAGE);
    }

    @Test
    public void testIsImageDisplayed(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.successfulContinue(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        overviewPage.clickFinishButton();
        assertTrue(completePage.isImageDisplayed());
    }

    @Test
    public void testGetThanksText(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.successfulContinue(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        overviewPage.clickFinishButton();
        assertEquals(completePage.getThanksText(), "Thank you for your order!", WRONG_TEXT_MESSAGE);
    }

    @Test
    public void testGetBodyText(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        inventoryPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.successfulContinue(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        overviewPage.clickFinishButton();
        assertEquals(completePage.getBodyText(),
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!",
                WRONG_TEXT_MESSAGE);
    }
}
