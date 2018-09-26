package com.epam.Pob;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage {
    @FindBy(css = "a.gb_we.gb_Aa.gb_Fb[target='_top']")
    public WebElement mailBtn;
    @FindBy(id = "identifierId")
    public WebElement emailInput;
    @FindBy(id = "identifierNext")
    public WebElement nextLoginBtn;

    public GmailLoginPage(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);;
    }

    public void inputLoginAndSubmit(String login) {
        mailBtn.click();
        emailInput.sendKeys(login);
        nextLoginBtn.click();
    }
}
