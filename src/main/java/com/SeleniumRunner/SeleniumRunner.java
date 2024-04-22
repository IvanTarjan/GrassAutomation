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
    public String chromePath;
    public WebDriverWait wait;

    public String username;

    public String password;


    public SeleniumRunner(String chromePath, String username, String password) {
        this.chromePath = chromePath;
        this.username = username;
        this.password = password;
    }

    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe"); //windows
//        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver"); //ubuntu
        ChromeOptions options = new ChromeOptions();
//        options.setBinary("./src/main/resources/chromedriver/chrome-linux64/chrome"); // ubuntu
        options.setBinary(chromePath); // windows
        options.addExtensions(new File("./src/main/resources/chromedriver/Grass-Extension.crx"));
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080","--ignore-certificate-errors","--no-sandbox", "--disable-dev-shm-usage");
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
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().to("chrome-extension://ilehaonighjijnmpnagapkhpcdbhclfg/index.html");
    }

}
