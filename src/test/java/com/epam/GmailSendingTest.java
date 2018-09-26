package com.epam;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.epam.Pob.GmailEmailPage;
import com.epam.Pob.GmailLoginPage;
import com.epam.Pob.GmailPasswordPage;
import com.epam.driverConfig.DriverConfiguration;
import com.epam.pageParameters.PageParameters;

@Test
public class GmailSendingTest {
    public void sendingEmail() throws InterruptedException {
        DriverConfiguration config = new DriverConfiguration();
        WebDriver driver = config.configureDriver();
        PageParameters pageParameters = new PageParameters();
        GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
        gmailLoginPage.inputLoginAndSubmit(pageParameters.getPageParams("login"));
        GmailPasswordPage gmailPasswordPage = new GmailPasswordPage(driver);
        gmailPasswordPage.inputPasswordAndSubmit(pageParameters.getPageParams("password"), driver);
        GmailEmailPage gmailEmailPage = new GmailEmailPage(driver);
        gmailEmailPage.writingLetterAndSubmit(pageParameters.getPageParams("receiver"),
                pageParameters.getPageParams("subject"),
                pageParameters.getPageParams("text"));
        gmailEmailPage.gettingSent(driver);
        gmailEmailPage.verifyingSentLetter(pageParameters.getPageParams("subject"),
                pageParameters.getPageParams("text"));
        gmailEmailPage.deletingDeliveredMessage();
        driver.quit();
    }
}
