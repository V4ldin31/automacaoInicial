import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TesteAjax {

private WebDriver driver;
	
	@Before
	public void Inicializar() {
		driver = new FirefoxDriver();
//		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=5d769");
	}
	
	@After
	public void Finalizar() {
//		driver.quit();
	}
	
	@Test
	public void testeAjax() {
		
		driver.findElement(By.id("j_idt303:name")).sendKeys("Teste");
		driver.findElement(By.id("j_idt303:j_idt307")).click();
		
		/* AGUARDANDO O SISTEMA ESCREVER O TEXTO DO TEXBOX NO SPAN QUE JA EXIXTE NA TELA */
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBe(By.id("j_idt303:display"), "Teste"));
		
		Assert.assertEquals("Teste", driver.findElement(By.id("j_idt303:display")).getText());
	}
	
}
