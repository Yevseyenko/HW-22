package com.epam.customElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Element {
    protected WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }
   public void click(){
webElement.click();
    }
    public  void clear(){
        webElement.clear();
    }
    public void isDisplayed(){
        webElement.isDisplayed();
    }
    public void sendKeys(CharSequence... keys){
        webElement.sendKeys(keys);
    }
    public void submit(){
        webElement.submit();
    }
    public String getText() {
       return webElement.getText();
    }
    public String getAttribute(String a){
       return webElement.getAttribute(a);
    }

    public WebElement getWebElement() {
        return webElement;
    }
    public WebElement findElement(By selector){
       return webElement.findElement(selector);
    }
}
