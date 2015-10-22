/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saucelabs;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Raghava
 */
  public class TestStep {
        public String Action;
        public String Field;
        public String FieldType;
        public String Associate;
        public WebDriver Driver;
        public TestStep(WebDriver driver) {
            this.Driver = driver;
        }

    void Execute() {
        
        switch(this.Action){
            case "browse":this.Browse();break;
            case "click":this.Click();break;
            case "verify":this.Verify();break;
            case "enter":this.Enter();break;
            default: break;
        }
       }

    private void Browse() {Driver.get(this.Associate);Driver.manage().window().maximize(); }

    private void Enter() {
        Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement w = Driver.findElement(By.cssSelector(this.Field));
        w.sendKeys(this.Associate);
    }

    private void Verify() {
         Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement w = Driver.findElement(By.cssSelector(this.Field));
        assertEquals(w.getText(),this.Associate);
    }

    private void Click() {
        Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement w = Driver.findElement(By.cssSelector(this.Field));
        w.click();
    }
    }
