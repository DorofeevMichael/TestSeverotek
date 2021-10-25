package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static WebDriver driver;
    public static PageLogin pageLogin;
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

        pageLogin = new PageLogin(driver);
        pageAddEntry = new PageAddEntry(driver);
        pageEntry = new PageEntry(driver);
        pageBlog = new PageBlog(driver);
        pageDeleteEntry = new PageDeleteEntry(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
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
        int panUpr = driver.findElements(By.xpath("//h1" + "" + "[text()='Панель управления']")).size();
        Assert.assertTrue(panUpr > 0);
        // click button Add
        pageAddEntry.clickAddBtn();
        // find Add Entry
        int addEntry = driver.findElements(By.xpath("//h1" + "" + "[text()='Добавить entry']")).size();
        Assert.assertTrue(addEntry > 0);
        // enter fields
        String inTitle = "title" + getRnd(10);
        pageEntry.inputTitle(inTitle);
        pageEntry.inputSlug("slug" + getRnd(10));
        pageEntry.inputTextM("text" + getRnd(10));
        pageEntry.inputText("Text" + getRnd(10));
        // click button Save
        pageEntry.clickSaveBtn();
        //transition to Blog
        driver.navigate().to(ConfProperties.getProperty("pageBlog"));
        // find saved Entry
        pageBlog.searchText(inTitle);
        //Assert.assertEquals(driver.findElement(By.xpath("//div[@id='entries']//a[@class='entry_title']")).getText(), inTitle);
        driver.navigate().to(ConfProperties.getProperty("pageBlogEntry"));
        // delete Entry
        pageBlog.deleteEntry(inTitle);
        pageBlog.delBtn();
        // confirm delete Entry
        pageDeleteEntry.delBtn();
    }
    @AfterClass
    public static void tearDown() {
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
