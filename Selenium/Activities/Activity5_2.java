package Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


/*Activity 5-2
Create a Package with a Class and a main() method
Create a WebDriver instance, named driver, with the FirefoxDriver().
Launch the web browser and open https://training-support.net/selenium/dynamic-controls using the get() method.
Get the page title and print it to the console.
Use findElement() to find the checkbox input element.
Use the isSelected() method to check if the checkbox is selected.
Click the checkbox to select it.
Use the isSelected() method again and print the result.*/


public class Activity5_2 {

    public static void main(String[] args) {

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://www.training-support.net/selenium/dynamic-controls");

        //Find the checkbox
        WebElement checkboxInput = driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("The checkbox is selected: " + checkboxInput.isSelected());

        //Select the checkbox
        checkboxInput.click();

        //Print status
        System.out.println("The checkbox is selected: " + checkboxInput.isSelected());

        //Close the browser
        driver.close();

    }

}