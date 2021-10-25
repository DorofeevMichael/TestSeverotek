package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageBlog {
    public WebDriver driver;

    public PageBlog(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='submit-row']//a[@class='deletelink']")
    private WebElement delBtn;

    @FindBy(xpath = "//div[@id='entries']//a[@class='entry_title']")
    private WebElement title;

    public String getTitle() {
        return title.getText();
    }

    public void searchText(String inText) {
        WebElement searchField = driver.findElements(By.linkText(inText)).get(0);
        searchField.click();
    }

    public void deleteEntry(String inText) {
        WebElement searchField = driver.findElements(By.linkText(inText)).get(0);
        searchField.click();
    }

    public void delBtn() {
        delBtn.click();
    }

}
