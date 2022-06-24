package Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*Activity 5-1
Create a Package with a Class and a main() method
Create a WebDriver instance, named driver, with the FirefoxDriver().
Launch the web browser and open https://training-support.net/selenium/dynamic-controls using the get() method.
Get the page title and print it to the console.
Use findElement() to find the checkbox input element.
Use the isDisplayed() method to check if it is visible on the page.
Click the "Remove Checkbox".
Print the result of the isDisplayed() method again.
*/
public class Activity5_1 {

    public static void main(String[] args) {

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://www.training-support.net/selenium/dynamic-controls");

        //Find the checkbox
        WebElement checkboxInput = driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("The checkbox Input is displayed: " + checkboxInput.isDisplayed());

        driver.findElement(By.id("toggleCheckbox")).click();

        System.out.println("The checkbox Input is displayed: " + checkboxInput.isDisplayed());

        //Close the browser
        driver.close();

    }

}
