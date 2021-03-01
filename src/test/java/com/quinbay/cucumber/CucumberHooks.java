package com.quinbay.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class CucumberHooks {
    static WebDriver driver;
    @Before
    public void testBefore(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.facebook.com/login/web/");
        System.out.println("This is a demo of before hook");
    }

    public WebDriver getDriver() {
        return driver;
    }

    @After
    public void testAfter(){
        getDriver().quit();
        System.out.println("This is a demo of after hook");
    }



}
