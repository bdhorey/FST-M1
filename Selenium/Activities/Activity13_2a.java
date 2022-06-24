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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*1.
In this activity, we use POI to write to an Excel file.

The input that will be used is shown below:
List<String[]> data = new ArrayList<String[]>();
String[] heading = {"ID", "First Name", "Last Name", "Email", "Ph.No."};
String[] row1 = {"1", "Satvik", "Shah", "satshah@example.com", "4537829158"};
String[] row2 = {"2", "Avinash", "Kati", "avinashK@example.com", "4892184058"};
String[] row3 = {"3", "Lahri", "Rath", "lahri.rath@example.com", "4528727830"};
In the class, create three methods
To write to the Excel file: writeExcel(String filePath)
To read from the Excel file: readExcel(String filePath)
Main method: public static void main(String args[])

2.
In the writeExcel() method:

Since we will be using a .xlsx file, create objects for XSSFWorkbook and XSSFSheet.
Use add() methods add the arrays to the List
//Creating data
List<String[]> data = new ArrayList<String[]>();
String[] heading = {"ID", "First Name", "Last Name", "Email", "Ph.No."};
String[] row1 = {"1", "Satvik", "Shah", "satshah@example.com", "4537829158"};
String[] row2 = {"2", "Avinash", "Kati", "avinashK@example.com", "4892184058"};
String[] row3 = {"3", "Lahri", "Rath", "lahri.rath@example.com", "4528727830"};

//Add it to the List
data.add(heading);
data.add(row1);
data.add(row2);
data.add(row3);

3.
The snippet below shows how to add data to the cells in the Excel sheet:

	//Iterate over data and write to sheet
	int rownum = 0;
	for (String[] rowData : data) {
	    //Creates a new row in the sheet
	    Row row = sheet.createRow(rownum++);
	    int cellnum = 0;
	    for (String cellData : rowData) {
	        //Creates a cell in the next column of that row
	        Cell cell = row.createCell(cellnum++);
	        cell.setCellValue(cellData);
	    }
	}
	
4.
In a try block, add FileOutputStream to write the data to the Excel sheet.

Finally, close the output stream and the workbook.

FileOutputStream out = new FileOutputStream(new File(filePath));
workbook.write(out);
out.close();
workbook.close();
		
5.
In the readExcel() method: (All of the code in this method is in a try block)

Open a FileInputStream with the filePath to read data from Excel sheet.
Create XSSFWorkbook and XSSFSheet objects.
Create an iterator that will loop through each row:
//Iterate through each rows one by one
Iterator<Row> rowIterator = sheet.iterator();
Use a while loop with the row iterator and in the loop, create a cell iterator as well.
Finally, close the input stream and the workbook.
Add a catch block to handle IOException.

6.
The iterators will look like this:

while (rowIterator.hasNext()) {
    Row row = rowIterator.next();
    //For each row, iterate through all the columns
    Iterator<Cell> cellIterator = row.cellIterator();

    while (cellIterator.hasNext()) {
        Cell cell = cellIterator.next();
        //Check the cell type and format accordingly
        switch (cell.getCellType()) {
        case NUMERIC: 
            System.out.print(cell.getNumericCellValue() + " \t ");
            break;
        case STRING: 
            System.out.print(cell.getStringCellValue() + " \t ");
            break;
        default:
            System.out.println("Invalid value");
            break;
        }
    }
    System.out.println("");
}

7.
In the main() method:

Create a String variable to save the file path.
Best practice is to save the file in the project, under resources folder.
If the methods are not static, create an object for the class and use it to call the readExcel() and writeExcel() methods.
public static void main(String args[]) throws IOException {
    //Prepare the path of excel file
    String filePath = "src/test/resources/sample.xlsx";

    //Create an object of current class
    ReadWriteExcel objExcelFile = new ReadWriteExcel();

    //Write the file using file name, sheet name and the data to be filled
    objExcelFile.writeExcel(filePath);
    
    //Call read file method of the class to read data
    objExcelFile.readExcel(filePath);
}*/

public class Activity13_2a {
    //Write Excel
    public void writeExcel(String filePath) throws IOException {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        //This data needs to be written (Object[])
        List<String[]> data = new ArrayList<String[]>();
        String[] heading = {"ID", "First Name", "Last Name", "Email", "Ph.No."};
        String[] row1 = {"1", "Satvik", "Shah", "satshah@example.com", "4537829158"};
        String[] row2 = {"2", "Avinash", "Kati", "avinashK@example.com", "4892184058"};
        String[] row3 = {"3", "Lahri", "Rath", "lahri.rath@example.com", "4528727830"};
        
        data.add(heading);
        data.add(row1);
        data.add(row2);
        data.add(row3);

        //Iterate over data and write to sheet
        int rownum = 0;
        for (String[] rowData : data) {
            //Creates a new row in the sheet
            Row row = sheet.createRow(rownum++);
            int cellnum = 0;
            for (String cellData : rowData) {
                //Creates a cell in the next column of that row
                Cell cell = row.createCell(cellnum++);
                cell.setCellValue(cellData);
            }
        }
        try {
            //this Writes to the workbook
            FileOutputStream out = new FileOutputStream(new File(filePath));
            workbook.write(out);
            out.close();
            workbook.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Read Excel
    public void readExcel(String filePath) {
        try {
            FileInputStream file = new FileInputStream(filePath);

            //Create Workbook instance holding reference to Excel file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                    case NUMERIC: 
                        System.out.print(cell.getNumericCellValue() + " \t ");
                        break;
                    case STRING: 
                        System.out.print(cell.getStringCellValue() + " \t ");
                        break;
                    default:
                        System.out.println("Invalid value");
                        break;
                    }
                }
                System.out.println("");
            }
            file.close();
            workbook.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws IOException {
        //Prepare the path of excel file
        String filePath = "src/test/resources/sample.xlsx";

        //Create an object of current class
        Activity13_2a objExcelFile = new Activity13_2a();

        //Write the file using file name, sheet name and the data to be filled
        objExcelFile.writeExcel(filePath);
        
        //Call read file method of the class to read data
        objExcelFile.readExcel(filePath);
    }
}