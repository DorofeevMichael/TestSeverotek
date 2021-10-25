package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageDeleteEntry {
    public WebDriver driver;
    public PageDeleteEntry(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@id='content']//input[@type='submit']")
    private WebElement delBtn;

    //submit Delete
    public void delBtn(){
        delBtn.click();
    }
}
