import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {
	
private WebDriver driver;
private DSL dsl;	
	
	@Before
	public void inicializa(){
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	dsl = new DSL(driver);
	}


	@After
	public void finaliza() {
		driver.close();
	}
	
	@Test
	public void deveInteragirComAlertSimples() {
		
		dsl.clicarBotao("alert");
//		driver.findElement(By.id("alert")).click();
		
		// Para interagir com o Alert, devemos mudar o foco do Selenium para ele.
		
		Alert alert = driver.switchTo().alert(); //CTRL + 1
		String Texto = alert.getText();
		Assert.assertEquals("Alert Simples", Texto);
		alert.accept();
		
		dsl.escreve("elementosForm:nome", Texto);
//		driver.findElement(By.id("elementosForm:nome")).sendKeys(Texto);
		
	}
	
	@Test
	public void deveInteragirComAlertConfirm() {
		dsl.clicarBotao("confirm");	
//		driver.findElement(By.id("confirm")).click();
		
		Alert alert = driver.switchTo().alert();	
		Assert.assertEquals("Confirm Simples", alert.getText());
		System.out.println(alert.getText());
		alert.accept();
		
		Assert.assertEquals("Confirmado", alert.getText());
		System.out.println(alert.getText());
		alert.accept();
		
		dsl.clicarBotao("confirm");
//		driver.findElement(By.id("confirm")).click();
		
		alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		System.out.println(alert.getText());
		alert.dismiss();
		
		Assert.assertEquals("Negado", alert.getText());
		System.out.println(alert.getText());
		alert.dismiss();
	
	}
	

	@Test
	public void deveInteragirComAlertPrompt() {
		dsl.clicarBotao("prompt");	
//		driver.findElement(By.id("prompt")).click();
		
		Alert alert = driver.switchTo().alert();
	
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("12");
		alert.accept();
		Assert.assertEquals("Era 12?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
		
	}

}
