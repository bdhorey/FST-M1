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
Activity11_3
Create a Package with a Class and a main() method
For this activity import the following classes
org.openqa.selenium.support.ui.Alert
Create a WebDriver instance, named driver, with the FirefoxDriver().
Open a browser with https://www.training-support.net/selenium/javascript-alerts
Get the title of the page using driver.getTitle() and print out the title.
Also use findElement() to find the button to open a PROMPT alert and click it.
Switch the focus from the main window to the Alert box.
Use sendKeys() to type in "Yes, you are!".
Close the alert with alert.accept().
Finally, close() the browser.*/

public class Activity11_3 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        //Open browser
        driver.get("https://www.training-support.net/selenium/javascript-alerts");

        //Print title of page and heading on page
        System.out.println("Page title is: " + driver.getTitle());

        //Click the button to open a prompt
        driver.findElement(By.cssSelector("button#prompt")).click();

        //Switch to prompt window
        Alert promptAlert = driver.switchTo().alert();

        //Get text in the prompt box and print it
        String alertText = promptAlert.getText();
        System.out.println("Alert text is: " + alertText);

        //Type "Awesome!" into the prompt
        promptAlert.sendKeys("Awesome!");

        //Close the prompt
        promptAlert.accept();

        //Close the Browser
        driver.close();
    }
}