import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestePrime {

	private WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=c480d");
		
	}
	
	@After
	public void finaliza() {
//		driver.quit();
	}
	
	@Test
	public void deveInteragirComRadioPrime() {
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div/form/table[1]/tbody/tr/td[1]/div/div[2]/span")).click();
		Assert.assertTrue(driver.findElement(By.id("j_idt303:console:0")).isSelected());
	}
	
	
	
}
