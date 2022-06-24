package TestNGActivities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelenuimTestNGProj {
  
 WebDriver driver;	
 String sCRMUrl="https://alchemy.hguy.co/crm";
 
 public void Launchrowser()	{
	 driver = new FirefoxDriver();
	 driver.get(sCRMUrl);
 }
 
 public void LoginToSuiteCRM(String UName,String UPassword) throws InterruptedException {

	    WebElement wbuser_name_txtF = driver.findElement(By.id("user_name"));
	    WebElement wbpassword_txtF = driver.findElement(By.id("username_password"));
	    WebElement wbLogInBtn = driver.findElement(By.name("Login"));
	    
	   //Enter User Credentials
	    wbuser_name_txtF.sendKeys(UName);
	    wbpassword_txtF.sendKeys(UPassword);
	    
	    //Click Login
	    wbLogInBtn.submit();
	    
	    Thread.sleep(5000);
	  
}
	
 //@Test
  public void Test01_VerifyTheWebsiteTitle() { 	  
	  
	    Launchrowser();
        //Check the title of the page
        String title = driver.getTitle();
        //Print the title of the page
        System.out.println("Page title is: " + title);
        
        Assert.assertTrue(title.equals("SuiteCRM"), "Actual title: "+title+" does not match with expected title SuiteCRM" );
        
		//driver.close();
  }
  
 //@Test
  public void Test02_CaptureHeaderImgUrl() { 	  
	  
	 /* Get the url of the header image
	  Goal: Print the url of the header image to the console */
	  
	    Launchrowser();
	    WebElement image = driver.findElement(By.xpath("//div[@class='companylogo']/img"));
	    
	    //Get Image Attribute 
	    String ImageSrc = image.getAttribute("src");
	    
	    System.out.println("Company Logo Image source url is :-  " + ImageSrc);
	    
	  driver.close();
	    
  }
  
  //@Test
  public void Test03_CaptureFooterCopyrightText() { 	  
	  
	 /* Get the copyright text
		Goal: Print the first copyright text in the footer to the console */
	  
	    Launchrowser();
	    WebElement footerTextParent = driver.findElement(By.xpath("//div[@class='p_login_bottom']"));
	    List<WebElement> footerTextList = footerTextParent.findElements(By.xpath("./child::*"));
	    
	    //Capture all footer texts and Print
	    for (WebElement footer : footerTextList) {
	    	System.out.println("Capture footer text is :- "+footer.getText());
	    }
	    
	  driver.close();
	    
  }
  

  
  //@Test
  public void Test04_LoginAndVerify() throws InterruptedException { 	  
	  
	 /* Logging into the site
	  : Open the site and login with the credentials provided */
	 try { 
	  	String sUserName="admin";
	    Launchrowser();
	    LoginToSuiteCRM(sUserName,"pa$$w0rd");
	    
	    WebElement wbHome = driver.findElement(By.xpath("//button[@title='"+sUserName+"']"));
	   if( wbHome.isDisplayed()) {
		   System.out.println("Login Successfully to CRM Portal"); 
	   }else {
		   Assert.assertTrue(false, "Seems Some issue with login to CRM portal, Please check");
	   }		   
	 }finally{	 
	  driver.close();
	 }
  }
  
  //@Test
  public void Test05_GetColourOfNavMenu() throws InterruptedException { 	  
	  
	 /* Getting colors
	    Goal: Get the color of the navigation menu */
	 try { 
	  	String sUserName="admin";
	    Launchrowser();
	    LoginToSuiteCRM(sUserName,"pa$$w0rd");
	    
	    WebElement wbNavBar = driver.findElement(By.xpath("//div[@id='toolbar']"));
 		
		String scssColor= wbNavBar.getCssValue("color");
		System.out.println("Nav Bar CSS color is: "+scssColor); 
		
		//Below attributes returning null
	    String sbackground= wbNavBar.getAttribute("background");
		System.out.println("Nav Bar background is: "+sbackground); 
		
	    
	    String sbackgroundColor= wbNavBar.getAttribute("background-color");
		System.out.println("Nav Bar background color is: "+sbackgroundColor);
	   	   
	   	   
	 }finally{	 
	    driver.close();
	 }
  }
  
  @Test
  public void Test06_ActivitiesMenuExist() throws InterruptedException { 	  
	  
	 /* Menu checking
		Goal: Make sure that the “Activities” menu item exists and is clickable  */
	 try { 
	  	String sUserName="admin";
	    Launchrowser();
	    LoginToSuiteCRM(sUserName,"pa$$w0rd");
	    
	    WebElement wbActivitiesMenu = driver.findElement(By.xpath("//a[(contains(text(),'Activities') )]"));
 		
	   if ( wbActivitiesMenu.isEnabled()) {
		   wbActivitiesMenu.click();
		   System.out.println("Activity Menu is Enabled/Clickable"); 
	   }else {
		   Assert.assertTrue(false, "Activity Menu is NOT Enabled/Clickable");
	   }		   
	   	   
	   	   
	 }finally{	 
	 driver.close();
	 }
  }
  
  @Test
  public void Test07_ActivitiesMenuExist() throws InterruptedException { 	  
	  
	 /*  Reading additional information
		Goal: Reading a popup that contains additional information about the account/lead.  */
	 try { 
	  	String sUserName="admin";
	    Launchrowser();
	    LoginToSuiteCRM(sUserName,"pa$$w0rd");
	    
	    WebElement wbSalesMenu = driver.findElement(By.xpath("//a[(contains(text(),'Sales') )]"));
	    WebElement wbLeadsMenu = driver.findElement(By.xpath("//a[(contains(text(),'Leads') )]"));
	    WebElement wAdditionalInfo1 = driver.findElement(By.xpath("//tr[1]/td//span[@title='Additional Details']"));
 		
	    //Click on Sales Menu
	    wbSalesMenu.click();
	    
	    //Click on Leads Menu
	    wbLeadsMenu.click();
	    
	    //Click Additional Info
	    wAdditionalInfo1.click();
	    
	    
	    
	     
	   	   
	 }finally{	 
	 //driver.close();
	 }
  }
  
  
}//ClassEnd
