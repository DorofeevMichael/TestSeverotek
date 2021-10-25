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
    public void searchText(String inText) {
        WebElement searchField = driver.findElements(By.linkText(inText)).get(0);
        searchField.click();
    }
    public void deleteEntry(){
        WebElement searchField = driver.findElements(By.linkText("Удалить")).get(0);
        searchField.click();
    }
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/input[2]")
    private WebElement delBtn;

    public void delBtn(){
        delBtn.click();
    }
    // подтверждаем удаление
    //*[@id="content"]/form/div/input[2]
    //<input type="submit" value="Да, я уверен">

}
