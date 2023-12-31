import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
	private WebDriver driver;
	private DSL dsl;
	
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	
	
	@Test
	public void TesteTextField() {
		dsl.escreve("elementosForm:nome", "Teste de escrita");
		Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));	
	}
	
	@Test
	public void TesteTextFieldDuplo() {
		dsl.escreve("elementosForm:nome", "Valdinei");
		Assert.assertEquals("Valdinei", dsl.obterValorCampo("elementosForm:nome"));
		dsl.escreve("elementosForm:nome", "Araujo");
		Assert.assertEquals("Araujo", dsl.obterValorCampo("elementosForm:nome"));
		
	}
	
	@Test
	public void deveInteragirComTextArea() {
		dsl.escreve("elementosForm:sugestoes", "Teste\nteste1\nteste2");
//		Assert.assertEquals("Teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		dsl.clicarRadio(("elementosForm:sexo:0"));
		
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));	
	}
	
	@Test
	public void deveInteragirComCheckBox() {
		dsl.clicarCheckBox("elementosForm:comidaFavorita:2");
		Assert.assertTrue(dsl.isChecBoxMarcado("elementosForm:comidaFavorita:2"));		
	}
	
	@Test
	public void deveInteragirComCombo() {
		
		dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
		Assert.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));	
	}
		
	@Test
	public void deveVerificarValorsCombo() { 
		
		WebElement element =  driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		java.util.List<WebElement> options = combo.getOptions(); //combo.getOptions(); CTRL + 1
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
		}
	
	@Test
	public void deveVerificarValorsComboMultiplo() { 
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");

		WebElement element =  driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
				
		java.util.List<WebElement> allSelectedOptions = combo.getAllSelectedOptions(); //combo.getAllSelectedOptions(); CTRL + 1
		Assert.assertEquals(3, allSelectedOptions.size());
		
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions(); //combo.getAllSelectedOptions(); CTRL + 1
		Assert.assertEquals(2, allSelectedOptions.size());
		
		
		
	}
	@Test
	public void deveInteragirComBotoes() { 
		dsl.clicarBotao("buttonSimple");
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));		
	}
	
	@Test
	
	public void deveInteragirComLinks() { 
		
		dsl.clicarLink("Voltar");
		
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));		
	}
	
	@Test
		public void deveBuscarTextosNaPagina() { 
		
		
//		Assert.assertTrue(driver.findElement(By.tagName("Body")).getText().contains("Campo de Treinamento"));
		
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
				
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", 
				dsl.obterTexto(By.className("facilAchar"))	);
				
	}
}
