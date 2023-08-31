import static br.ce.wcaquino.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;

import br.ce.wcaquino.core.DriverFactory;

public class DesafioTestarRegrasDeNegocio {


private DSL dsl;
private CampoTreinamentoPage page;	
	
	@Before
	public void inicializa(){
	getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	dsl = new DSL();
	page = new CampoTreinamentoPage();
	}


	@After
	public void finaliza() {
		DriverFactory.killdriver();
	}
	
	@Test
	public void deveValidarNomeObrigatorio() {
		page.cadastrar();
//		dsl.clicarBotao("elementosForm:cadastrar");		
//		getDriver().findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = getDriver().switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		alert.accept();
		
	}
	
	@Test
	public void deveValidarSobrenomeObrigatorio() {
		
		page.setNome("Ronaldinho");
//		dsl.escreve("elementosForm:nome", "Ronaldinho");
//		getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Ronaldinho");
		
		page.cadastrar();
//		dsl.clicarBotao("elementosForm:cadastrar");	
//		getDriver().findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = getDriver().switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		alert.accept();
		
	}
	
	@Test
	public void deveValidarSexonomeObrigatorio() {
		page.setNome("Ronaldinho");
//		dsl.escreve("elementosForm:nome", "Ronaldinho");		
//		getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Ronaldinho");
		
		page.setSobrenome("Gaucho");
//		dsl.escreve("elementosForm:sobrenome", "Gaucho");
//		getDriver().findElement(By.id("elementosForm:sobrenome")).sendKeys("Gaucho");
		
		page.cadastrar();
//		dsl.clicarBotao("elementosForm:cadastrar");
//		getDriver().findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = getDriver().switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		alert.accept();
		
	}
	
	@Test
	public void deveValidarComidaFavorita() {
		page.setNome("Ronaldinho");
//		dsl.escreve("elementosForm:nome", "Ronaldinho");		
//		getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Ronaldinho");
		
		page.setSobrenome("Gaucho");
//		dsl.escreve("elementosForm:sobrenome", "Gaucho");
//		getDriver().findElement(By.id("elementosForm:sobrenome")).sendKeys("Gaucho");
		
		page.setSexoMasculino();
//		dsl.clicarRadioButon("elementosForm:sexo:0");
//		getDriver().findElement(By.id("elementosForm:sexo:0")).click();
		
		page.setComidaCarne();
//		dsl.clicarRadioButon("elementosForm:comidaFavorita:0");
//		getDriver().findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		page.setComidaVagetariano();
//		dsl.clicarRadioButon("elementosForm:comidaFavorita:3");
//		getDriver().findElement(By.id("elementosForm:comidaFavorita:3")).click();

		page.cadastrar();
//		dsl.clicarBotao("elementosForm:cadastrar");
//		getDriver().findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = getDriver().switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		alert.accept();
	
	}
	
	@Test
	public void deveValidarEsportistaIndeciso() {
		page.setNome("Ronaldinho");
//		dsl.escreve("elementosForm:nome", "Ronaldinho");	
//		getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Ronaldinho");
		
		page.setSobrenome("Gaucho");
//		dsl.escreve("elementosForm:sobrenome", "Gaucho");
//		getDriver().findElement(By.id("elementosForm:sobrenome")).sendKeys("Gaucho");
		
		page.setSexoMasculino();
//		dsl.clicarRadioButon("elementosForm:sexo:0");
//		getDriver().findElement(By.id("elementosForm:sexo:0")).click();
		
		page.setComidaCarne();
//		dsl.clicarRadioButon("elementosForm:comidaFavorita:0");
//		getDriver().findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		page.setEsporte("Natacao", "O que eh esporte?");
//		dsl.selecionarCombo("elementosForm:esportes", "Natacao");		
//		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
//		Select selecionarEsporte = new Select(getDriver().findElement(By.id("elementosForm:esportes")));
//		selecionarEsporte.selectByVisibleText("Natacao");
//		selecionarEsporte.selectByVisibleText("O que eh esporte?");
		
		page.cadastrar();
//		dsl.clicarBotao("elementosForm:cadastrar");
//		getDriver().findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = getDriver().switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
		alert.accept();
	
	}
}
