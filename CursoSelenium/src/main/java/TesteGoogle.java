import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	
private WebDriver driver;
	
	
	@Before
	public void inicializa(){
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://www.google.com");
	}


	@After
	public void finaliza() {
		driver.close();
	}
	
	@Test
	public void teste() throws InterruptedException {
		
		Assert.assertEquals("Google", driver.getTitle());
		
	driver.findElement(By.name("q")).sendKeys("teste de gravidez");
//	driver.findElement(By.name("q")).submit();
		
	}

}
