package com.Page;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BasePage {

    private final By usernameField = By.name("user");

    private final By passwordField = By.name("password");

    private final By loginButton = By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div/form/button");

    public Login(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void InsertUsername(String username) {
        this.sendKey(username, usernameField);
    }

    public void InsertPassword(String password){
        this.sendKey(password, passwordField);
    }

    public void ClickLogin(){
        this.clickear(loginButton);
    }
}
