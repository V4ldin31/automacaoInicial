package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
private WebDriver driver;
	
	public LoginPage (WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void fazerLogin() {
		driver.findElement(By.xpath("//*[.='Inicie sessão']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("teste.login.nei");
		
		
		
	}
	
	

}
