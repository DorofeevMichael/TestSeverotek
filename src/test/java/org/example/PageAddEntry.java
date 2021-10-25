package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAddEntry {
    public WebDriver driver;
    public PageAddEntry(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // find Control Panel
    //public boolean findCP() {
    //    panUpr = driver.findElements(By.xpath("//h1" + "" + "[text()='Панель управления']")).size();
    //    return panUpr;
    //}

    // find "Blog-Entries-Добавить"
    // тута нада нормальный икспасс
    @FindBy(xpath = "//*[@id=\"module_2\"]/div/ul[1]/li[1]/ul/li[1]/a/span")
    private WebElement clickLink;

    // enter Add
    public void clickAddBtn() {
        clickLink.click();
    }

}