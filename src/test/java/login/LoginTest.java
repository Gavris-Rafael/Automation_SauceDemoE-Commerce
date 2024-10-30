package login;

import base.BaseTests;
import org.testng.annotations.Test;

import static constants.LoginData.*;
import static constants.URLs.*;
import static constants.Message.*;
import static org.testng.Assert.*;

public class LoginTest extends BaseTests {

    @Test
    public void testSuccessfulLogin(){
        loginPage.login(STANDARD_USER, VALID_PASSWORD);
        assertEquals(driver.getCurrentUrl(), INVENTORY_URL, URL_MESSAGE);
    }

    @Test
    public void testIsPlaceHolderTextUsernameDisplayed(){
        assertEquals(loginPage.isPlaceHolderTextUsernameFieldDisplayed(), "Username", WRONG_TEXT_MESSAGE);
    }

    @Test
    public void testIsPlaceHolderTextPasswordDisplayed(){
        assertEquals(loginPage.isPlaceHolderTextPasswordFieldDisplayed(), "Password", WRONG_TEXT_MESSAGE);
    }

    @Test
    public void testLockedOutUser(){
        loginPage.login(LOCKED_OUT_USER, VALID_PASSWORD);
        assertEquals(loginPage.getErrorMessages(),
                "Epic sadface: Sorry, this user has been locked out.",
                WRONG_TEXT_ERROR_MESSAGE);
    }

    @Test
    public void testWrongCredentialLoginMessages(){
        loginPage.login(INVALID_USERNAME, INVALID_PASSWORD);
        assertEquals(loginPage.getErrorMessages(),
                "Epic sadface: Username and password do not match any user in this service",
                WRONG_TEXT_ERROR_MESSAGE);
    }

    @Test
    public void testEmptyFieldsLogin(){
        loginPage.login(EMPTY_USERNAME_FIELD, EMPTY_PASSWORD_FIELD);
        assertEquals(loginPage.getErrorMessages(),
                "Epic sadface: Username is required",
                WRONG_TEXT_ERROR_MESSAGE);
    }

    @Test
    public void testIsErrorIconDisplayed(){
        loginPage.login(INVALID_USERNAME, INVALID_PASSWORD);
        assertTrue(loginPage.isErrorIconsFieldsDisplayed());
    }

}
