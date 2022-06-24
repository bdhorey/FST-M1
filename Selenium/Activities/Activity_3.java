package Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*//Activity 3
//Create a Class with a main() method.
//Create a WebDriver instance, named driver, with the FirefoxDriver().
//Open a browser with https://training-support.net/selenium/simple-form
//Get the title of the page using driver.getTitle() and print out the title.
//Use findElement() with name() to find the text fields - firstname and lastname.
//Use WebElement.sendKeys() to type in those text fields.
//Similarly, find and type into the email and contact number fields.
//Finally, submit the form by clicking the Submit button.
//Close the browser with driver.close()
//Activity 3
//There is a way to pause the execution to see the result of the execution - Thread.sleep().
//This is rarely used, as it always force the browser to wait for a specific time.
//Thread.sleep() is never a good idea.
//This is used simply for you to see the test type in the text field. It should not be used in an actual test script.
//When adding Thread.sleep(), make sure the main() function throws InterruptedException.
*/
public class Activity_3 {
    public static void main(String[] args) {

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
    
        //Open the browser
        driver.get("https://www.training-support.net/selenium/simple-form");
        
        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        
        //Find the input fields
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        //Enter text
        firstName.sendKeys("Saahil");
        lastName.sendKeys("Sharma");
        
        //Enter the email
        driver.findElement(By.id("email")).sendKeys("test@example.com");
        
        //Enter the contact number
        driver.findElement(By.id("number")).sendKeys("1234567890");
        
        //Click Submit
        driver.findElement(By.cssSelector(".ui.green.button")).click();
    
        //Close the browser
        driver.close();
    }
}