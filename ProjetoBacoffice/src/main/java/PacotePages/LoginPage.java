package PacotePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void fazerLogin() throws InterruptedException {
		driver.findElement(By.xpath("//span[.='Entrar com KeyCloak']")).click();
		driver.findElement(By.id("social-adfs-pagol")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='contentWrapper']//input[@id='userNameInput']")));	
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='contentWrapper']//input[@id='userNameInput']")).sendKeys("sempreit.vsouza@ext.pagol.com.br");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='contentWrapper']//input[@id='passwordInput']")).sendKeys("Tr1mundial4");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='contentWrapper']//span[@id='submitButton']")).click();

	}
}

