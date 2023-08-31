import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestePrime {
	
	private WebDriver driver;
	private DSL dsl;

		
		@Before
		public void inicializa(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		dsl = new DSL(driver);
		} 

		@After
		public void finaliza() {
//			driver.close();
		}
	
	@Test
	public void deveInteragirComRadioPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=85ee4");
		/********* XPath atrav�s do ID  ***********/
		dsl.clicarRadioButon(By.xpath("//*[@id='j_idt312:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt312:console:0"));
		
		/********* XPath atrav�s do Label  ***********/
		dsl.clicarRadioButon(By.xpath("//label[.='Option2']/..//Span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt312:console:1"));	
	}
	
	@Test
	public void deveInteragirComSelectPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=3d90c");	
		dsl.clicarRadioButon(By.xpath("//*[@id='j_idt311:option_label']"));
		dsl.clicarRadioButon(By.xpath("//*[@id='j_idt311:option_items']//li[.='Option2']"));
		
		Assert.assertEquals("Option2", dsl.obterTexto("j_idt311:option_label"));
	}

}
