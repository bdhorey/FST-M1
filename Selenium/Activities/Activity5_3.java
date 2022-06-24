package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
Activity 5-3
isEnabled() Method

Create a Package with a Class and a main() method
Create a WebDriver instance, named driver, with the FirefoxDriver().
Launch the web browser and open https://training-support.net/selenium/dynamic-controls using the get() method.
Get the page title and print it to the console.
Use findElement() to find the text field.
Use the isEnabled() method to check if the text field is enabled.
Click the "Enable Input" button to enable the input field.
Use the isEnabled() method again and print the result.
*/
public class Activity5_3 {

    public static void main(String[] args) {

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://training-support.net/selenium/dynamic-controls");

        //Find the checkbox
        WebElement textInput = driver.findElement(By.xpath("//input[@type='text']"));

        //Print status
        System.out.println("The checkbox is selected: " + textInput.isEnabled());

        driver.findElement(By.id("toggleInput")).click();

        //Print status
        System.out.println("The checkbox is selected: " + textInput.isEnabled());

        //Close the browser
        driver.close();

    }

}