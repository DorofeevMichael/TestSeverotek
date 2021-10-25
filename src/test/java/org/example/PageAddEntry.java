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

    // find "Blog-Entries-Add"
    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement title;

    // find fields
    @FindBy(xpath = "//*[contains(@id, 'id_title')]")
    private WebElement titleField;

    @FindBy(xpath = "//*[contains(@id, 'id_slug')]")
    private WebElement slugField;

    @FindBy(xpath = "//textarea[@id='id_text_markdown']")
    private WebElement textmField;

    @FindBy(xpath = "//*[@id='id_text']")
    private WebElement textField;

    // find button Save
    @FindBy(xpath = "//div[@class='submit-row']/input[@name='_save']")
    private WebElement saveBtn;

    public void clickSaveBtn() {
        saveBtn.click();}

    public String getTitle(){
        return title.getText();
    }
    //Input fields
    public void inputTitle(String title) {
        titleField.sendKeys(title);
    }

    public void inputSlug(String slug) {
        slugField.clear();
        slugField.sendKeys(slug);
    }

    public void inputTextM(String textm) {
        textmField.sendKeys(textm);
    }

    public void inputText(String inText) {
        textField.sendKeys(inText);
    }
}