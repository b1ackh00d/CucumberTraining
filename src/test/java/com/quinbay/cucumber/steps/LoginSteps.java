package com.quinbay.cucumber.steps;

import com.quinbay.cucumber.CucumberHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    CucumberHooks cucumberHooks = new CucumberHooks();
    WebDriver driver = cucumberHooks.getDriver();

    @Given("I am on facebook login page")
    public void iAmOnFacebookLoginPage() {
        System.out.println("Yes, I am in Login Page");
    }

    @When("I enter username as {string}")
    public void iEnterUsernameAs(String username) {
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys(username);
        System.out.println("Enter the Username");
    }

    @And("I enter password as {string}")
    public void iEnterPasswordAs(String password) {
        WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
        pass.sendKeys(password);
        System.out.println("Enter the Password");

    }

    @Then("Login should fail")
    public void loginShouldFail() {
        WebElement loginBtn = driver.findElement(By.xpath("//button[@id='loginbutton']"));
        loginBtn.click();

//        WebElement checkLogin = driver.findElement(By.xpath("//*[contains(text(), 'The password that yo')]"));
        WebElement checkLogin2 = driver.findElement(By.xpath("//div[@id='error_box']"));

        if(checkLogin2.isDisplayed()) {System.out.println("Login is successfully failed");}
        else { System.out.println("Test Case Failed"); }

    }

    @And("This is a test")
    public void thisIsATest() {

    }

}
