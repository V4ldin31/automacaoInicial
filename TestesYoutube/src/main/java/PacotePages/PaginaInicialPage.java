package PacotePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaInicialPage {

	private WebDriver driver;
	public PaginaInicialPage(WebDriver driver) {
		this.driver = driver;
	}

	public void inserirTextoBusca(String textoBusca) {
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(textoBusca);
		driver.findElement(By.xpath("//input[@id='search']")).submit();
	}
	
	public void clicarBuscar() {
		driver.findElement(By.id("search-icon-legacy")).click();
	}

}
