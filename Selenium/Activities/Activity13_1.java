package Activity;
import java.time.Duration;
import java.util.List;
import java.util.Set;

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


import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
/*
In this activity, we use OpenCSV to read from a CSV file and print it's contents.

First create a CSV file with the following contents:
	Create a Java class with the main method.
	Create an object for the OpenCSV Class with the file path of the CSV as its parameter.
	//Load CSV file
	CSVReader reader = new CSVReader(new FileReader("src/resources/sample.csv"));
	Use the readAll() method to read the contents of the CSV file.
	Use the size() method to count the number of rows in the CSV file.
	Create an iterator to iterate through the list and and print all the rows of the file.*/

public class Activity13_1 {
	public static void main(String[] args) throws IOException, CsvException {
		//Load CSV file
        CSVReader reader = new CSVReader(new FileReader("src/test/resources/sample.csv"));

        //Load content into list
        List<String[]> list = reader.readAll();
        System.out.println("Total number of rows are: " + list.size());

        //Create Iterator reference
        Iterator<String[]> itr = list.iterator();

        //Iterate all values
        while(itr.hasNext()) {
            String[] str = itr.next();

            System.out.print("Values are: ");
            for(int i=0;i<str.length;i++) {
                System.out.print(" " + str[i]);
            }
            System.out.println(" ");
        }
        
        reader.close();
	}
}