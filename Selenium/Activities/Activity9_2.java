package Activity;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Activity 9-2
Multi-Select

Create a Class and a main() method
Create a WebDriver instance, named driver, with the FirefoxDriver().
Open the browser with https://training-support.net/selenium/selects using the get() method.
Use findElement() to find the multi-select WebElement on the page.
Create a new Select class object with the WebElement.
Check if the HTML element is a multi-list. Proceed with other actions if it is.
Select the 'JavaScript' option by visible text.
Select the 'NodeJS' option by value.
Select the 4th, 5th, and the 6th options by index.
Deselect the 'NodeJS' option by value attribute.
Deselect the 7th option by index.
Print the first selected option.
Print all selected options one by one and deselect all options.
*
*/


public class Activity9_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        //Open browser
        driver.get("https://training-support.net/selenium/selects");

        //Chosen option
        WebElement chosen = driver.findElement(By.id("multi-value"));
        
        //Find multiList
        Select multiList = new Select(driver.findElement(By.id("multi-select")));
        
        if(multiList.isMultiple()) {
        
            //Select 'JavaScript' by Visible text
            multiList.selectByVisibleText("Javascript");
            System.out.println(chosen.getText());
    
            //Select 'NodeJS' by value
            multiList.selectByValue("node");
            System.out.println(chosen.getText());
            
            //Select 4,5, and 6 options by index
            for(int i=4; i<=6; i++) {
                multiList.selectByIndex(i);
            }
            System.out.println(chosen.getText());
    
            //Deselect 'NodeJS' by value
            multiList.deselectByValue("node");
            System.out.println(chosen.getText());
            
            //Deselect 7th opttion by index
            multiList.deselectByIndex(7);
            System.out.println(chosen.getText());
            
            //Get all selected options
            List<WebElement> selectedOptions = multiList.getAllSelectedOptions();
            //Print all selected options
            for(WebElement selectedOption : selectedOptions) {
                System.out.println("Selected option: " + selectedOption.getText());
            }
            
            //Deselect all options
            multiList.deselectAll();
            System.out.println(chosen.getText());
        }        
        //Close browser
        driver.close();
    }
}