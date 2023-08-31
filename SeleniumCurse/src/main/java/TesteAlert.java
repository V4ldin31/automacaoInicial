import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TesteAlert {

	@Test
	public void deveInteragirComAlertSimples() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert(); //CTRL + 1
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	
	}
	@Test
	public void deveInteragirComAlertConfirm() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("confirm")).click();
		Alert alerta = driver.switchTo().alert();
		String txtAlerta = alerta.getText();
		Assert.assertEquals("Confirm Simples", txtAlerta);
		alerta.dismiss();
		Assert.assertEquals("Negado", alerta.getText());
//		alerta.accept();
	
	}
	@Test
	public void deveInteragirComAlertPrompt() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("prompt")).click();
		Alert alerta = driver.switchTo().alert();
		String txtAlert1 = alerta.getText();
		Assert.assertEquals("Digite um numero", txtAlert1);
		alerta.sendKeys("12");
		alerta.accept();
		
		
		
		String txtAlert2 = alerta.getText();
		Assert.assertEquals("Era 12?", txtAlert2);
		alerta.accept();
		
		
		String txtAlert3 = alerta.getText();
		Assert.assertEquals(":D", txtAlert3);
		alerta.accept();
		
//		driver.quit();
	}
}
