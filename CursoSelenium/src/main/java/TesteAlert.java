import static br.ce.wcaquino.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;

import br.ce.wcaquino.core.DriverFactory;

public class TesteAlert {
	
	
private DSL dsl;	
	
	@Before
	public void inicializa(){
	getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	dsl = new DSL();
	}


	@After
	public void finaliza() {
		DriverFactory.killdriver();
	}
	
	@Test
	public void deveInteragirComAlertSimples() {
		
		dsl.clicarBotao("alert");
//		getDriver().findElement(By.id("alert")).click();
		
		// Para interagir com o Alert, devemos mudar o foco do Selenium para ele.
		
		Alert alert = getDriver().switchTo().alert(); //CTRL + 1
		String Texto = alert.getText();
		Assert.assertEquals("Alert Simples", Texto);
		alert.accept();
		
		dsl.escreve("elementosForm:nome", Texto);
//		getDriver().findElement(By.id("elementosForm:nome")).sendKeys(Texto);
		
	}
	
	@Test
	public void deveInteragirComAlertConfirm() {
		dsl.clicarBotao("confirm");	
//		getDriver().findElement(By.id("confirm")).click();
		
		Alert alert = getDriver().switchTo().alert();	
		Assert.assertEquals("Confirm Simples", alert.getText());
		System.out.println(alert.getText());
		alert.accept();
		
		Assert.assertEquals("Confirmado", alert.getText());
		System.out.println(alert.getText());
		alert.accept();
		
		dsl.clicarBotao("confirm");
//		getDriver().findElement(By.id("confirm")).click();
		
		alert = getDriver().switchTo().alert();
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
//		getDriver().findElement(By.id("prompt")).click();
		
		Alert alert = getDriver().switchTo().alert();
	
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("12");
		alert.accept();
		Assert.assertEquals("Era 12?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
		
	}

}
