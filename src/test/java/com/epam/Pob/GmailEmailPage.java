package com.epam.Pob;

import com.epam.customElement.Button;
import com.epam.customElement.Input;
import com.epam.customElement.Label;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GmailEmailPage {
    private static final Logger log = LogManager.getLogger("log4j2");
    @FindBy(xpath = "//a[@data-pid='23']")
    private Button mailBtn;
    @FindBy(xpath = "//div[@gh='cm']")
    private Button writeLetterBtn;
    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement receiverField;
    @FindBy(xpath = "//input[@name='subjectbox']")
    private Input subjectField;
    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement textMessage;
    @FindBy(xpath = "//table[@role='group']/tbody/tr/td/div/div[2][not(@aria-pressed) and not(@aria-hidden)]")
    private Button sendBtn;
    @FindBy(xpath = "//input[@class='gb_bf']")
    private Input input;
    @FindBy(css = "tbody>tr.zA.yO:nth-child(1)")
    private WebElement firstLetter;
    @FindBy(xpath = "//div[@gh='mtb']/div/div[2]/div[3]")
    private WebElement deleteBtn;
    @FindBy(xpath = "//table[@role='presentation']//h2")
    private Label letterSubj;
    @FindBy(xpath = "//table[@role='presentation']//div[@dir]")
    private Label letterTxt;

    public GmailEmailPage(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }


    public void enteringEmail(String receiver, String subject, String text) {
        log.info("Entering reciver "+ receiver+" subject "+subject+" text "+text);
        receiverField.sendKeys(receiver);
        subjectField.sendKeys(subject);
        textMessage.sendKeys(text);

    }

    public void clickingWriteBtn() {
        log.info("Clicking write button ");
        writeLetterBtn.click();
    }

    public void clickingMailBtn() {
        log.info("Clicking mail button ");
        mailBtn.click();
    }

    public void clickingEmailSendBtn() {
        log.info("Clicking mail button ");
        sendBtn.click();
    }

    public void gettingSent(WebDriver driver) {
        log.info("Entering to sent folder");
        input.sendKeys("in:sent" + Keys.ENTER);
    }

    public void enteringFirstLetter(WebDriver driver) {
        log.info("Entering to first Letter");
        waitForClickable(firstLetter, driver);
        firstLetter.click();
    }

    public void deletingDeliveredMessage(WebDriver driver)  {
        log.info("Deleting sent message");
        waitForVisibility(deleteBtn, driver);
        deleteBtn.click();

    }

    private void waitForVisibility(WebElement element, WebDriver driver) throws Error {
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(element));
    }


   private void waitForClickable(WebElement element, WebDriver driver) {
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void verifyingSentLetter(String subject, String text) {
        Assert.assertEquals(subject, letterSubj.getText());
        Assert.assertEquals(text, letterTxt.getText());
    }

    public String gettingSubject() {
        return letterSubj.getText();
    }

}
