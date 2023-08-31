import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RespostaDemorada {
	
private WebDriver driver;
	
	@Before
	public void Inicializar() {
		driver = new FirefoxDriver();
//		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void Finalizar() {
//		driver.quit();
	}

	@Test
	public void deveUtilizarEsperaFixa() throws InterruptedException {
		
		driver.findElement(By.id("buttonDelay")).click();
		
		/** FAZENDO O SISTEMA AGUARDAR O CAMPO SER CARREGADO NA TELA**/
		Thread.sleep(5000); //CTRL + 1
		
		driver.findElement(By.id("novoCampo")).sendKeys("Deu Bom?");
	}
	
	@Test
	public void deveUtilizarEsperaImplicita() throws InterruptedException {
		
		driver.findElement(By.id("buttonDelay")).click();
		
		/** FAZENDO O SISTEMA AGUARDAR O CAMPO SER CARREGADO NA TELA**/
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.id("novoCampo")).sendKeys("Deu Bom?");
		
		/** DESLIGANDO A ESPERA**/
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void deveUtilizarEsperaExplicita() throws InterruptedException {
		
		driver.findElement(By.id("buttonDelay")).click();
		
		/** FAZENDO O SISTEMA AGUARDAR O CAMPO SER CARREGADO NA TELA**/
		WebDriverWait esperar = new WebDriverWait(driver, 30);
		
		esperar.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		
		driver.findElement(By.id("novoCampo")).sendKeys("Deu Bom?");
		
		
	}
}