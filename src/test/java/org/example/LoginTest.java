package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static WebDriver driver;
    public static PageLogin pageLogin;
    public static PageControlPanel pageControlPanel;
    public static PageAddEntry pageAddEntry;
    public static PageEntry pageEntry;
    public static PageBlog pageBlog;
    public static PageDeleteEntry pageDeleteEntry;

    @BeforeClass
    public static void setup() {
        // choosing a browser to use
        if (System.getProperty("mbrowser").equals("chrome")){
            System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
            driver = new ChromeDriver();
        } else if (System.getProperty("mbrowser").equals("firefox")) {
            System.setProperty("webdriver.firefox.driver", ConfProperties.getProperty("geckodriver"));
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));

        pageControlPanel = new PageControlPanel(driver);
        pageLogin = new PageLogin(driver);
        pageAddEntry = new PageAddEntry(driver);
        pageEntry = new PageEntry(driver);
        pageBlog = new PageBlog(driver);
        pageDeleteEntry = new PageDeleteEntry(driver);
    }
    @Test
    public void loginTest() {
        // enter Login
        pageLogin.inputLogin(ConfProperties.getProperty("login"));
        // enter password
        pageLogin.inputPasswd(ConfProperties.getProperty("passwd"));
        // enter button
        pageLogin.clickLoginBtn();
        // find Control Panel
        Assert.assertEquals("Title not displayed for Control Panel page", pageControlPanel.getTitle(), "Панель управления");
        // click button Add
        pageControlPanel.clickAddBtn();
        // find Add Entry
        Assert.assertEquals("Title not displayed for AddEntry page", pageAddEntry.getTitle(), "Добавить entry");
        // enter fields
        String inTitle = "title" + getRnd(10);
        pageAddEntry.inputTitle(inTitle);
        pageAddEntry.inputSlug("slug" + getRnd(10));
        pageAddEntry.inputTextM("text" + getRnd(10));
        pageAddEntry.inputText("Text" + getRnd(10));
        // click button Save
        pageAddEntry.clickSaveBtn();
        //transition to Blog
        driver.navigate().to(ConfProperties.getProperty("pageBlog"));
        // find saved Entry
        Assert.assertEquals("Title not displayed for Blog page", pageBlog.getTitle(), inTitle);
        pageBlog.searchText(inTitle);
        //transition to BlogEntry
        driver.navigate().to(ConfProperties.getProperty("pageBlogEntry"));
        // delete Entry
        pageBlog.deleteEntry(inTitle);//
        pageBlog.delBtn();//
        // confirm delete Entry
        pageDeleteEntry.delBtn();
    }
    @AfterClass
    public static void exitSite() {
        driver.quit();
    }

    // generating random
    private String getRnd(int num) {
        String rnd = "";
        Random srnd = new Random();
        for (int i = 1; i <= 6; i++) {
            rnd = rnd + srnd.nextInt(10);
        }
        return rnd;
    }
}
