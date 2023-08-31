package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage {
	
	private WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setEmailouTelefone(String emailOuTelefone) {
				driver.findElement(By.id("username")).sendKeys(emailOuTelefone);
	}
	
	public void setSenha(String senha) {
		driver.findElement(By.id("password")).sendKeys(senha);
}
	public void clicarEntrar() {
		driver.findElement(By.xpath("//button[contains(text(),'Entrar')]")).click();
	}

}
