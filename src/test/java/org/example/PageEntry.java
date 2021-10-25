package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageEntry {
    public WebDriver driver;
    public PageEntry(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    // проверка на наличение заголовка
    @FindBy(xpath = "//*[contains(@id, 'content')]")
    private WebElement panelU;

    // ищем поля
    @FindBy(xpath = "//*[contains(@id, 'id_title')]")
    private WebElement titleField;

    @FindBy(xpath = "//*[contains(@id, 'id_slug')]")
    private WebElement slugField;

    @FindBy(xpath = "//*[contains(@id, 'id_text_markdown')]")
    private WebElement textmField;

    @FindBy(xpath = "//*[contains(@id, 'id_text')]")
    private WebElement textField;

    // ищем кнопку сохранить
    @FindBy(xpath = "//*[@id=\"entry_form\"]/div/div/input[1]")
    //*[@id="entry_form"]/div/div/input[1]
    // тут исправить на нормальный хпас
    private WebElement saveBtn;

    //Input fields
    public void inputTitle(String title) {
        titleField.sendKeys(title);
    }
    public void inputSlug(String slug) {
        slugField.sendKeys(slug);
    }
    public void inputTextM(String textm) {
        textmField.sendKeys(textm);
    }
    public void inputText(String inText) {
        textField.sendKeys(inText);
    }
    public void clickSaveBtn() {
        saveBtn.click();
    }
}
