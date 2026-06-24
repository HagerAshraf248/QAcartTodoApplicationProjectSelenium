package com.qacart.todo.testcases;

import com.qacart.todo.Utils.ConfigUtils;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Feature("Auth Feature")
public class LoginTest extends BaseTest {

    @Story("Login")
    @Description("It will login by filling email and password and navigate to the todo page")

    @Test (description = "Test the Login Functionality using email and password")
    public void shouldBeAbleToLoginWithEmailAndPassword(){

        LoginPage loginPage = new LoginPage(getDriver());
        boolean isWelcomDisplayed =
                loginPage
                        .load()
                        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                        .isWelcomMessageDisplayed();

       Assert.assertTrue(isWelcomDisplayed);


    }
}
