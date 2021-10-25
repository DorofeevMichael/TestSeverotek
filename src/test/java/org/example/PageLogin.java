package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin {
    public WebDriver driver;
    public PageLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    //field USERNAME
    @FindBy(xpath = "//input[contains(@id,'id_username')]")
    private WebElement loginField;

    //field PASSWORD
    @FindBy(xpath = "//input[contains(@id, 'id_password')]")
    private WebElement passwdField;

    //buttonLOGIN
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginBtn;

    //Input login
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    //Input password
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }
    //input button Login
    public void clickLoginBtn() {
        loginBtn.click();
    }
}
