import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class DesafioTestePrime {
	
	private WebDriver driver;
	
	@Before
	public void inicializa() {
//		driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=37ad3");
		
	}
	
	@After
	public void finaliza() {
//		driver.quit();
	}
	
	@Test
	public void selecionarCombo() {
		
		driver.findElement(By.xpath("//*[@id=\"j_idt303:option\"]/div[3]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"j_idt303:option_2\"]")).click();
		Assert.assertEquals("Option2", driver.findElement(By.xpath("//*[@id=\"j_idt303:option_label\"]")).getText());
				
	}

}
