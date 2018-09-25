package com.epam.Pob;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPasswordPage {
    @FindBy(css = "input[name=\"password\"]")
    public WebElement passwordInput;
    @FindBy(id = "passwordNext")
    public WebElement passwordNextBtn;

    public GmailPasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void inputPasswordAndSubmit(String password, WebDriver driver) {
        passwordInput.sendKeys(password);
        waitForClickable(passwordNextBtn, driver);
        passwordNextBtn.click();
    }

    void waitForClickable(WebElement element, WebDriver driver) {
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(element));
    }
}
