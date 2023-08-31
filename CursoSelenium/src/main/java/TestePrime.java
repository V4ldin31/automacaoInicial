
import static br.ce.wcaquino.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.wcaquino.core.DriverFactory;



public class TestePrime {
	
	
	private DSL dsl;

		
		@Before
		public void inicializa(){
		dsl = new DSL();
		} 

		@After
		public void finaliza() {
			DriverFactory.killdriver();
		}
	
	@Test
	public void deveInteragirComRadioPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=85ee4");
		/********* XPath através do ID  ***********/
		dsl.clicarRadioButon(By.xpath("//*[@id='j_idt312:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt312:console:0"));
		
		/********* XPath através do Label  ***********/
		dsl.clicarRadioButon(By.xpath("//label[.='Option2']/..//Span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt312:console:1"));	
	}
	
	@Test
	public void deveInteragirComSelectPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=3d90c");	
		dsl.clicarRadioButon(By.xpath("//*[@id='j_idt311:option_label']"));
		dsl.clicarRadioButon(By.xpath("//*[@id='j_idt311:option_items']//li[.='Option2']"));
		
		Assert.assertEquals("Option2", dsl.obterTexto("j_idt311:option_label"));
	}

}
