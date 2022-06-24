package Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
Activity 4-3
Create a Class and a main() method
Create a WebDriver instance, named driver, with the FirefoxDriver().
Open a browser with https://www.training-support.net/selenium/target-practice
Get the title of the page using driver.getTitle() and print out the title.
Use findElement() with xpath() to
Find the third header on the page.
Find the fifth header on the page and get it's 'colour' CSS Property.
Find the violet button on the page and print all the class attribute values.
Find the grey button on the page with Absolute XPath.
*/
public class Activity4_3 {

    public static void main(String[] args) {

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://www.training-support.net/selenium/target-practice");

        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        //Find the third header
        String thirdHeader = driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
        System.out.println("Third header text is: " + thirdHeader);

        //Find the fifth header and get it's colour
        String fifthHeaderColour = driver.findElement(By.xpath("//h5")).getCssValue("color");
        System.out.println("Fith header's colour is: " + fifthHeaderColour);

        //Find the violet button and print it's classes
        String violetButtonClasses = driver.findElement(By.xpath("//button[contains(text(), 'Violet')]")).getAttribute("class");
        System.out.println("Violet button's classes are: " + violetButtonClasses);

        //Find the grey button with Absolute XPath
        String greyButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText();
        System.out.println("The grey button's text is: " + greyButton);

        //Close the browser
        driver.close();

    }

}