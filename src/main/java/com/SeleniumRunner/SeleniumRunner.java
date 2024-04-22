package com.SeleniumRunner;

import com.Page.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class SeleniumRunner {

    public WebDriver driver;
    public WebDriverWait wait;

    public String username;

    public String password;


    public SeleniumRunner( String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUp() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();

        options.addExtensions(new File("./src/main/resources/chromedriver/Grass-Extension.crx"));
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless=new", "--disable-gpu", "--window-size=1920,1080","--ignore-certificate-errors","--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        Login loginPage = new Login(driver, wait);
        loginPage.setup();
        loginPage.url("https://app.getgrass.io/");
    }

    public void login() {
        Login loginPage = new Login(driver , wait);
        loginPage.InsertUsername(username);
        loginPage.InsertPassword(password);
        loginPage.ClickLogin();
        System.out.println(loginPage.GetDashboardText());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().to("chrome-extension://ilehaonighjijnmpnagapkhpcdbhclfg/index.html");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(loginPage.GoToDashboardText());
    }

}
