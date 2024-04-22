package com.Page;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BasePage {

    private final By usernameField = By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div/form/div[2]/div[1]/div/input");

    private final By passwordField = By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div/form/div[2]/div[2]/div/input");

    private final By loginButton = By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div/form/button");

    private final By dashboardText = By.xpath("/html/body/div[1]/div[1]/aside/div[2]/div/div[1]/a[1]/div[2]/div/p");

    private final By goToDashboard = By.xpath("//*[@id=\"root\"]/div/div/main/div/div[2]/div[3]/a/button");

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

    public String GetDashboardText(){
        return this.getText(dashboardText);
    }

    public String GoToDashboardText(){
        return this.getText(goToDashboard);
    }
}
