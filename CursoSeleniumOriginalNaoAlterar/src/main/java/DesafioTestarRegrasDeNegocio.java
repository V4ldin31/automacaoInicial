import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DesafioTestarRegrasDeNegocio {

private WebDriver driver;
private DSL dsl;
private CampoTreinamentoPage page;	
	
	@Before
	public void inicializa(){
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	dsl = new DSL(driver);
	page = new CampoTreinamentoPage(driver);
	}


	@After
	public void finaliza() {
//		driver.close();
	}
	
	@Test
	public void deveValidarNomeObrigatorio() {
		page.cadastrar();
//		dsl.clicarBotao("elementosForm:cadastrar");		
//		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		alert.accept();
		
	}
	
	@Test
	public void deveValidarSobrenomeObrigatorio() {
		
		page.setNome("Ronaldinho");
//		dsl.escreve("elementosForm:nome", "Ronaldinho");
//		driver.findElement(By.id("elementosForm:nome")).sendKeys("Ronaldinho");
		
		page.cadastrar();
//		dsl.clicarBotao("elementosForm:cadastrar");	
//		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		alert.accept();
		
	}
	
	@Test
	public void deveValidarSexonomeObrigatorio() {
		page.setNome("Ronaldinho");
//		dsl.escreve("elementosForm:nome", "Ronaldinho");		
//		driver.findElement(By.id("elementosForm:nome")).sendKeys("Ronaldinho");
		
		page.setSobrenome("Gaucho");
//		dsl.escreve("elementosForm:sobrenome", "Gaucho");
//		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gaucho");
		
		page.cadastrar();
//		dsl.clicarBotao("elementosForm:cadastrar");
//		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		alert.accept();
		
	}
	
	@Test
	public void deveValidarComidaFavorita() {
		page.setNome("Ronaldinho");
//		dsl.escreve("elementosForm:nome", "Ronaldinho");		
//		driver.findElement(By.id("elementosForm:nome")).sendKeys("Ronaldinho");
		
		page.setSobrenome("Gaucho");
//		dsl.escreve("elementosForm:sobrenome", "Gaucho");
//		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gaucho");
		
		page.setSexoMasculino();
//		dsl.clicarRadioButon("elementosForm:sexo:0");
//		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		page.setComidaCarne();
//		dsl.clicarRadioButon("elementosForm:comidaFavorita:0");
//		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		page.setComidaVagetariano();
//		dsl.clicarRadioButon("elementosForm:comidaFavorita:3");
//		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();

		page.cadastrar();
//		dsl.clicarBotao("elementosForm:cadastrar");
//		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		alert.accept();
	
	}
	
	@Test
	public void deveValidarEsportistaIndeciso() {
		page.setNome("Ronaldinho");
//		dsl.escreve("elementosForm:nome", "Ronaldinho");	
//		driver.findElement(By.id("elementosForm:nome")).sendKeys("Ronaldinho");
		
		page.setSobrenome("Gaucho");
//		dsl.escreve("elementosForm:sobrenome", "Gaucho");
//		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gaucho");
		
		page.setSexoMasculino();
//		dsl.clicarRadioButon("elementosForm:sexo:0");
//		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		page.setComidaCarne();
//		dsl.clicarRadioButon("elementosForm:comidaFavorita:0");
//		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		page.setEsporte("Natacao", "O que eh esporte?");
//		dsl.selecionarCombo("elementosForm:esportes", "Natacao");		
//		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
//		Select selecionarEsporte = new Select(driver.findElement(By.id("elementosForm:esportes")));
//		selecionarEsporte.selectByVisibleText("Natacao");
//		selecionarEsporte.selectByVisibleText("O que eh esporte?");
		
		page.cadastrar();
//		dsl.clicarBotao("elementosForm:cadastrar");
//		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
		alert.accept();
	
	}
}
