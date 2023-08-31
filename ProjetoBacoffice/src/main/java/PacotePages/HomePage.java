package PacotePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void acessarProdutos() {
		driver.findElement(By.xpath("//span[.='Produtos']")).click();
	}
	
	public void acessarProdutoConversaoDeMilhas() {
		driver.findElement(By.xpath("//*[.='CONVERSÃO DE MILHAS']/../div/div[1]/a")).click();
	}
	
	/********Dica do Danilo Zagato
	  public WebElement acessarProdutoConversaoDeMilhas() {
		 return driver.findElement(By.xpath("//*[.='CONVERSÃO DE MILHAS']/../div/div[1]/a"));  
	**/
}
