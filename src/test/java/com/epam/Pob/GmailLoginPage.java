package com.epam.Pob;

import com.epam.customElement.Button;
import com.epam.customElement.Input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage {
    @FindBy(css = "a.gb_we.gb_Aa.gb_Fb[target='_top']")
    public Button mailBtn;
    @FindBy(id = "identifierId")
    public Input emailInput;
    @FindBy(id = "identifierNext")
    public Button nextLoginBtn;

    public GmailLoginPage(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public void inputLoginAndSubmit(String login) {
        mailBtn.click();
        emailInput.sendKeys(login);
        nextLoginBtn.click();
    }
}
