package hris.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class hris_Test {
WebDriver driver;
Login_page login=new Login_page(driver);

@FindBy(className="active")
WebElement link_Login;

@BeforeClass (description="Hit the URL")

public void Hit_URL(){ //This function Hit the URL
	System.setProperty("webdriver.chrome.driver","D:\\softwares\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
driver.get("https://hris.qainfotech.com");
}

@Test (description="Login with invalid credentials should show an error message") 
public void Login_With_Invalid_Credentials(){
login.Login_Credentials("akshat", "akshat"); //Sending Invalid Credentials 
login.Click_Signin_Button();
//link_Login.click();
Assert.assertTrue(driver.findElement(By.className("loginTxt txtHideDiv alert alert-error")).getText().contains("Invalid Login"));
}


@Test (description="Login without entering the password", dependsOnMethods="Login_With_Invalid_Credentials")
public void Login_Without_Password(){
login.Login_Credentials("akshat", " "); //Sending credentials without password
login.Click_Signin_Button();
link_Login.click();
Assert.assertTrue(driver.findElement(By.id("txtPassword")).getAttribute("style").contains("red"));
}

@Test (description="Login with valid credentials should redirect the user to Profile Page",dependsOnMethods="Login_Without_Password")

public void Login_With_Valid_Credentials(){
login.Login_Credentials("akshatrai","Qait@123"); //Sending Valid Credentials
login.Click_Signin_Button();
link_Login.click();
Assert.assertEquals(driver.getTitle(), "QAIT Resource Management Tool ");
}

}