package com.qacart.todo.pages;

import com.qacart.todo.Utils.ConfigUtils;
import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {
    public NewTodoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement newTodoInput;

    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement submitButton;

    public NewTodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.NEW_TODO_ENDPOINT);
    return this;
    }

    @Step
    public TodoPage addNewTask(String todoText){
        newTodoInput.sendKeys(todoText);
        submitButton.click();
        return new TodoPage(driver);
    }





}
