import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TesteFramesEJanelas {
	
	@Test
	public void deveInteragirComFrames() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		
//		MUDANDO PARA O ALERT		
		Alert alert = driver.switchTo().alert(); //CTRL + 1
		String mensagem = alert.getText();
		Assert.assertEquals("Frame OK!", mensagem);
		alert.accept();

// 		VOLTANDO A PÁGINA PRINCIPAL		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(mensagem);
		
	}
	@Test
	public void deveInteragirComJanelas() {
//		WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("buttonPopUpEasy")).click();
		
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		driver.close();
		driver.switchTo().window("");
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("E agora");
		
		
	}
	@Test
	public void deveInteragirComJanelaSemTitulo() {
		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("buttonPopUpHard")).click();
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Deu Certo?");
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("E agora?");
//		driver.quit();
	}
	
	@Test
	public void dveInteragirComFrameEscondido() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		

		WebElement frame = driver.findElement(By.id("frame2"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
//		DAR SCROLL NA PÁGINA		
		js.executeScript("window.scrollBy(0, arguments[0])", frame.getLocation().y); 
		
		driver.switchTo().frame("frame2"); 
		driver.findElement(By.id("frameButton")).click();
		
		Alert alert = driver.switchTo().alert(); 
		String mensagem = alert.getText();
		Assert.assertEquals("Frame OK!", mensagem);
//		alert.accept();
		
	}
	
	@Test
	public void teste() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[8]/td[2]/table/tbody/tr[2]/td[5]/table/tbody/tr/td/input")).click();
		driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[8]/td[2]/table/tbody/tr[2]/td[3]/input")).click();
	}
}