import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteAjax {
	
	private WebDriver driver;
	private DSL dsl;	
		
		@Before
		public void inicializa(){
	//	driver = new ChromeDriver();
		driver = new FirefoxDriver();	
		driver.manage().window().maximize();
		driver.get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=92319");
		dsl = new DSL(driver);
		}


		@After
		public void finaliza() {
//			driver.close();
			
		}
		@Test
		public void testeAjax() {
			dsl.escreve("j_idt311:name", "Teste");
			dsl.clicarBotao("j_idt311:j_idt315");
			WebDriverWait wait = new WebDriverWait(driver, 30);
		//	wait.until(ExpectedConditions.textToBe(By.id("j_idt311:display"), "Teste"));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt98")));
			Assert.assertEquals("Teste", dsl.obterTexto("j_idt311:display"));
		}

}
