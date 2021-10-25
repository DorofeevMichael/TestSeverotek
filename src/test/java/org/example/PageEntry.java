package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageEntry {
    public WebDriver driver;

    public PageEntry(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // check Control Panel
    @FindBy(xpath = "//*[contains(@id, 'content')]")
    private WebElement panelU;
}
