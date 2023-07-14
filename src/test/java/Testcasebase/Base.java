package Testcasebase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base{
	
		public WebDriver driver;
		public Properties Prop = new Properties();
		public Properties Email = new Properties();


		
        public void loadPropertiesfile() {
			
			
//			String Filepathfordata = "\\src\\main\\java\\nopcommerce\\config\\testData.properties";
			
			File f =new File(System.getProperty("user.dir")+"\\src\\main\\java\\nopcommerce\\config\\testData.properties");
			try {
			FileInputStream fis = new FileInputStream(f);
			Prop.load(fis);
			fis.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			}
		
	
		public WebDriver InitialseBrowserandopenApp(String browserName) {
		
			
		
		
		if(browserName.equals("Chrome")) {
			
			driver = new ChromeDriver();
		}
		else if(browserName.equals("Edge"))
				{
			driver = new EdgeDriver();
			
		}
		else if(browserName.equals("Firefox")){
			driver = new FirefoxDriver();
			
		}
		
		
		
		driver.manage().window().maximize();
		
		
		return driver;
		
	
		
		
	}
		
		
	
       public String Generate_email_with_timestamp() {
		
		Date date =new Date();
		String timestamp = date.toString().replace(" ","_").replace(":","_");
		String NewEmail = "T1"+timestamp+"@gmail.com";
		
		 try {
		        
			 Email.setProperty("newUserEmailAddress",NewEmail);

		        String filePath = "D:\\eclipse mca\\selenium_ec_1\\src\\main\\java\\nopcommerce\\config\\config.properties";
		        FileOutputStream output = new FileOutputStream(filePath);

		        // Save the properties to the output stream
		        Email.store(output, "Email updated in properties file successfully");
		        output.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		        System.out.println("Failed to update email");
		    }

		
		
		return NewEmail;
		
		
		
		
	}
       
//       public void addTimestampToEmail() throws IOException {
//   	    //Date date = new Date();
//   	    //String timestamp = date.toString();
//   	//replace(" ", "_").replace(":", "_");
//   	    Random random = new Random();
//           
//           // Generate a random integer between 1 and 10
//        int random_number = random.nextInt(100);
//   	    String newEmail = "chand199809+" + random_number + "@yopmail.com";
//   	    System.out.println(newEmail);
//
//   	    
//   	        Properties properties = new Properties();
//   	     
//       }

	
}
