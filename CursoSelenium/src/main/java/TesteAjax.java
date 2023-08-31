import static br.ce.wcaquino.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.core.DriverFactory;

public class TesteAjax {
	

	private DSL dsl;	
		
		@Before
		public void inicializa(){
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=92319");
		dsl = new DSL();
		}


		@After
		public void finaliza() {
			DriverFactory.killdriver();
			
		}
		@Test
		public void testeAjax() {
			dsl.escreve("j_idt339:name", "Teste");
			dsl.clicarBotao("j_idt339:j_idt343");
			WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		//	wait.until(ExpectedConditions.textToBe(By.id("j_idt311:display"), "Teste"));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt98")));
			Assert.assertEquals("Teste", dsl.obterTexto("j_idt311:display"));
		}

}
