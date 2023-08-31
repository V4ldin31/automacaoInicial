package BigPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;
	
	public HomePage (WebDriver driver)	{
		this.driver = driver;
	}
	
	
	
	public void acessarMenu() throws InterruptedException {
		driver.findElement(By.className("v-btn__content")).click();
		Thread.sleep(2000);
	}
	
	public void acessarComercial() throws InterruptedException {
		driver.findElement(By.xpath("//*[contains(text(),'Comercial')]")).click();
		Thread.sleep(1000);
	}
	
	public void acessarCarteiraCliente() throws InterruptedException {
		driver.findElement(By.xpath("(//*[contains(text(),'Carteira de Clientes')])[1]")).click();
		Thread.sleep(5000);
	}
}
