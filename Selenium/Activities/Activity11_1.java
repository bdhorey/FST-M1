package Activity;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
Activity 11-1
Create a Class and a main() method
For this activity import the following classes
org.openqa.selenium.support.ui.Alert
Create a WebDriver instance, named driver, with the FirefoxDriver().
Open a browser with https://www.training-support.net/selenium/javascript-alerts
Get the title of the page using driver.getTitle() and print out the title.
Use findElement() to find the button to open a SIMPLE alert and click it.
Switch the focus from the main window to the Alert box and get the text in it and print it.
Finally, close the alert with alert.accept() and close() the browser

Selenium provides us with an interface called Alert.
It is present in the org.openqa.selenium.Alert package.
Alert interface gives us following methods to deal with the alert:
accept() - To accept the alert. Same as clicking "OK"
dismiss() - To dismiss the alert. Same as clicking "Cancel"
getText() - To get the text of the alert
sendKeys() -To write some text to the alert
To switch focus to the alert box, use driver.switchTo().alert()*/

public class Activity11_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        //Open browser
        driver.get("https://www.training-support.net/selenium/javascript-alerts");

        //Click the button to open a simple alert
        driver.findElement(By.cssSelector("button#simple")).click();

        //Switch to alert window
        Alert simpleAlert = driver.switchTo().alert();

        //Get text in the alert box and print it
        String alertText = simpleAlert.getText();
        System.out.println("Alert text is: " + alertText);

        //Close the alert box
        simpleAlert.accept();

        //Close the Browser
        driver.close();
    }
}
