package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePage {
	private WebDriver driver;
	public  HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void clicarEntrar() {
		driver.findElement(By.xpath("//*[contains(text(),'Entrar')]")).click();
	}

}
