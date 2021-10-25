package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageControlPanel {
    public WebDriver driver;

    public PageControlPanel(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='content']/h1[@class='dashboard-title']")
    private WebElement title;

    @FindBy(xpath = "//a[text()= 'Entries']/following-sibling::ul//span[text()= 'Добавить']")
    private WebElement clickLink;


    public String getTitle(){
        return title.getText();
    }

    // enter Add
    public void clickAddBtn() {
        clickLink.click();
    }

}