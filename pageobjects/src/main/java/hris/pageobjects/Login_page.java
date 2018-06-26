package hris.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login_page {
WebDriver driver;

@FindBy(id="txtUserName")
WebElement txt_Username; //Find Username Field

@FindBy(id="txtPassword")
WebElement txt_Password; //Find Password field

@FindBy(name="Submit")
WebElement btn_Signin; //Find Signin Button

@FindBy(className="active")
WebElement link_Login;

public Login_page(WebDriver driver){ //Constructor for Driver 
	System.setProperty("webdriver.chrome.driver","D:\\softwares\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
this.driver=driver;
PageFactory.initElements(driver, this);

}


public void Login_Credentials(String Username, String Password ){
link_Login.click();
txt_Username.sendKeys(Username); //send keys to the username field
txt_Password.sendKeys(Password); //send keys to the password field
}

public void Click_Signin_Button(){
btn_Signin.submit(); //Find the SignIn Button and clicks on it
}

public void Clear_Credentials_Field(){
txt_Username.clear(); //clear the username field
txt_Password.clear(); //clear the password field
}

}