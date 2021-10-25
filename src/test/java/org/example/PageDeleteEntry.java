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
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/input[2]")
    private WebElement delBtn;

    //подтверждаем удаление
    public void delBtn(){
        delBtn.click();
    }
}
