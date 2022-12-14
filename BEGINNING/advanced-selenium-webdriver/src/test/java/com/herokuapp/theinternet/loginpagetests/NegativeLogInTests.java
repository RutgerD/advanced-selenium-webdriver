package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLogInTests extends TestUtilities {

    @Parameters({ "username", "password", "expectedMessage" })
    @Test(priority = 1)
    public void negativeTest(String username, String password, String expectedErrorMessage) {
        log.info("Starting negativeTest");

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

        // enter username and password and click login button
        loginPage.negativeLogIn(username, password);

        // wait for error message and then get it
        loginPage.waitForErrorMessage();
        String actualErrorMessage = loginPage.getErrorMessageText();

        // Verification
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
                        + expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
    }



}
