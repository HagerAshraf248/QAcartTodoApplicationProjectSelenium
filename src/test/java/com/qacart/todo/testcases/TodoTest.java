package com.qacart.todo.testcases;

import com.qacart.todo.Utils.ConfigUtils;
import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TaskApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Feature("Todo Feature")
public class TodoTest extends BaseTest {

    @Story("Add Todo")
    @Test (description = "Should be able to create a new todo Correctly")
    public void ShouldBeAbleToAddNewTodo(){

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        NewTodoPage todoPage=new NewTodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
       String actualResult = todoPage
               .load()
               .addNewTask("Learn Selenium")
               .getTodoText();


        Assert.assertEquals(actualResult,"Learn Selenium");

        //Login Page before use API  // depend on user state AND application state : make tests flecky
//        LoginPage loginPage = new LoginPage(driver);
//        String actualResult = loginPage
//                .load()
//                .login(ConfigUtils.getInstance().getEmail(),ConfigUtils.getInstance().getPassword())
//                .clickOnPlusButton()
//                .addNewTask("Learn Selenium")
//                .getTodoText();

    }

    @Story("Delete Todo")
    @Test (description = "Should be able to delete Todo Correctly")
    public void shouldBeAbleToDeleteTodo(){
        RegisterApi registerApi=new RegisterApi();
        registerApi.register();

        TaskApi taskApi=new TaskApi();
        taskApi.addTask(registerApi.getToken());

        TodoPage todoPage=new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
       boolean isNoTodoMessageDisplayed = todoPage
               .load()
                       .clickOnDeleteButton()
                       .isNoTodoMessageDisplyed();

        //Login Page
//        LoginPage loginPage = new LoginPage(driver);
//        boolean isNoTodoMessageDisplayed =  loginPage
//                .load()
//                .login(ConfigUtils.getInstance().getEmail(),ConfigUtils.getInstance().getPassword())
//                .clickOnPlusButton()
//                .addNewTask("Learn Selenium")
//                .clickOnDeleteButton()
//                .isNoTodoMessageDisplyed();

        Assert.assertTrue(isNoTodoMessageDisplayed);

    }
}
