import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Teste123 {
	
	private WebDriver driver = new FirefoxDriver();
	
	
	@Before
	public void iniciar(){
	driver.get("https://www.google.com");
	driver.manage().window().maximize();
	}
	
	@After
	public void finalizar() {
	driver.close();
	}
	
	@Test
	public void acessarGoogle() throws InterruptedException {
		
		
		driver.findElement(By.name("q")).sendKeys("Brasil");
		driver.findElement(By.name("q")).submit();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class=\"eA0Zlc ivg-i PZPZlf GMCzAd\"]")).click();
		
		
		
	}
}
