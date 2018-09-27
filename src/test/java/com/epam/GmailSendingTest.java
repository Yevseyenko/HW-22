package com.epam;


import com.epam.Pob.GmailEmailPage;
import com.epam.Pob.GmailLoginPage;
import com.epam.Pob.GmailPasswordPage;
import com.epam.driverConfig.DriverConfiguration;
import com.epam.pageParameters.PageParameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GmailSendingTest {
    private PageParameters pageParameters = new PageParameters();
    private DriverConfiguration config = new DriverConfiguration();
    private WebDriver driver = config.configureDriver();
    private String login = pageParameters.getPageParams("login");
    private String password = pageParameters.getPageParams("password");
    private String reciver = pageParameters.getPageParams("receiver");
    private String subject = pageParameters.getPageParams("subject");
    private String text = pageParameters.getPageParams("text");

    @Test
    public void sendingEmail() {

        GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
        GmailPasswordPage gmailPasswordPage = new GmailPasswordPage(driver);
        GmailEmailPage gmailEmailPage = new GmailEmailPage(driver);
        gmailLoginPage.clickingingEmail();
        gmailLoginPage.enteringLogin(login);
        gmailLoginPage.clickingLoginNextBtn();
        gmailPasswordPage.enterPassword(password, driver);
        gmailPasswordPage.clickingPasswordNextBtn();
        gmailEmailPage.clickingMailBtn();
        gmailEmailPage.clickingWriteBtn();
        gmailEmailPage.enteringEmail(reciver, subject, text);
        gmailEmailPage.clickingEmailSendBtn();
        gmailEmailPage.gettingSent(driver);
        gmailEmailPage.enteringFirstLetter(driver);
        gmailEmailPage.verifyingSentLetter(subject, text);
        Assert.assertEquals(subject, gmailEmailPage.gettingSubject());
        gmailEmailPage.deletingDeliveredMessage(driver);
        driver.close();
        driver.quit();
    }
}
