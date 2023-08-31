package PacotePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdutosPage {
	private WebDriver driver;
	
	public ProdutosPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clicarAdicionar() {
		driver.findElement(By.xpath("//button[.='Adicionar']")).click();
	}

}
