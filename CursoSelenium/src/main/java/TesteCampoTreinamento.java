
import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.ce.wcaquino.core.DriverFactory;

public class TesteCampoTreinamento {
	
	
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
	public void testeTextField() {
		dsl.escreve("elementosForm:nome", "Teste de escrita");	
		Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));
		
	}
	
	
	@Test
	public void deveInteragirComTesteTextArea() {
		dsl.escreve("elementosForm:sugestoes", "Teste");
		Assert.assertEquals("Teste", dsl.obterValorCampo("elementosForm:sugestoes"));
		
	}
	
	@Test
	public void testTextFieldDuplo() {
		dsl.escreve("elementosForm:nome", "VALDINEI");
		Assert.assertEquals("VALDINEI", dsl.obterValorCampo("elementosForm:nome"));
		dsl.escreve("elementosForm:nome", "ARAUJO");
		Assert.assertEquals("ARAUJO", dsl.obterValorCampo("elementosForm:nome"));
//		Assert.assertEquals("Teste", dsl.obterValorCampo("elementosForm:sugestoes"));
		
	}

	@Test
	public void deveInteragirComRadioButon() {
			
		dsl.clicarRadioButon("elementosForm:sexo:0");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
//		Assert.assertTrue(getDriver().findElement(By.id("elementosForm:sexo:0")).isSelected());
		
	}
	
	@Test
	public void deveInteragirComCheckBox() {
		dsl.clicarRadioButon("elementosForm:comidaFavorita:2");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:2"));
		
	}
	
	@Test
	public void deveInteragirComCombo() {
		dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
		Assert.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));

	}
	

	@Test
	public void deveVerificarValoresCombo() {
		
		WebElement element =  getDriver().findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		
		List<WebElement> options = combo.getOptions();   //Digitar: combo.getOptions(); e teclar CTRL + 1
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option: options ) {
			if(option.getText().equals("Mestrado"));{
				encontrou = true;
				break;
			
		}
		
		}
		Assert.assertTrue(encontrou);
	}
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		
		WebElement element =  getDriver().findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions(); // combo.getAllSelectedOptions() CTRL + 1
		Assert.assertEquals(3, allSelectedOptions.size());
		
		combo.deselectByVisibleText("Corrida"); //Comando para deselecionar uma op��o do Combo
		
		
	}
	
	@Test
	public void deveInteragirComBotoes() {
		dsl.clicarBotao("buttonSimple");				
		WebElement Botao = getDriver().findElement(By.id("buttonSimple"));	
		Assert.assertEquals("Obrigado!", Botao.getAttribute("value"));	
	}
	
	@Test
	public void deveInteragirComLinks() {
		dsl.clicarLink("Voltar");		
			
//		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
		
	//	Assert.fail();
	
	}
	

	@Test
	public void deveBuscarTextosNaTela() {
		
	//		Assert.assertTrue(getDriver().findElement(By.tagName("body"))
		//		.getText().contains("Campo de Treinamento"));
		
		Assert.assertEquals("Campo de Treinamento", 
				dsl.obterTexto(By.tagName("h3")));
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", 
				dsl.obterTexto(By.className("facilAchar")));
		
	}
	
	@Test
	public void testJavascript() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();	
//		js.executeScript("alert('Testando Js via Selenium')");
		js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via Js'");
		js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
		
		WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
		js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
	}
	
	@Test
	public void deveClicarBotaoTabela() {
		dsl.clicarBotaTabela("Escolaridade", "Mestrado", "Radio", "elementosForm:tableUsuarios");	
	}
}
