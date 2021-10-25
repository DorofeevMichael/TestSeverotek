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

    @FindBy(xpath = "//*[@id=\"entry_form\"]/div/div/p/a")
    private WebElement delBtn;

    public void searchText(String inText) {
        WebElement searchField = driver.findElements(By.linkText(inText)).get(0);
        searchField.click();
    }
    public void deleteEntry(String inText){
        WebElement searchField = driver.findElements(By.linkText(inText)).get(0);
        searchField.click();
    }

    public void delBtn(){
        delBtn.click();
    }


}
