import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteCadastro {
	
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
	public void testeTextField() {
		page.setNome("Ronaldinho");
//		dsl.escreve("elementosForm:nome","Ronaldinho");		
//		driver.findElement(By.id("elementosForm:nome")).sendKeys("Ronaldinho");
		
		page.setSobrenome("Gaucho");
//		dsl.escreve("elementosForm:sobrenome","Gaucho");
//		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gaucho");
		
		page.setSexoMasculino();
//		dsl.clicarRadioButon("elementosForm:sexo:0");
//		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
//		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

		page.setComidaPizza();
//		dsl.clicarRadioButon("elementosForm:comidaFavorita:2");
//		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
//		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		
		page.setEscolaridade("Mestrado");
//		dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");
		
//		WebElement ComboEscolaridade = driver.findElement(By.id("elementosForm:escolaridade"));
//		Select SelecionarEscolaridade = new Select(ComboEscolaridade);
//		SelecionarEscolaridade.selectByVisibleText("Mestrado");
		
		// OU USAR A LINHA ABAIXO PARA SELECIONAR (MAIS SIMPLES)
//		new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Mestrado");
//		Assert.assertEquals("Mestrado", SelecionarEscolaridade.getFirstSelectedOption();
		
		page.setEsporte("Natacao");
//		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
//		WebElement ComboEsporte = driver.findElement(By.id("elementosForm:esportes"));
//		Select SelecionarEsporte = new Select(ComboEsporte);
//		SelecionarEsporte.selectByVisibleText("Natacao");
//		List<WebElement> allSelectedOptions = SelecionarEsporte.getAllSelectedOptions(); 
//		Assert.assertEquals(1, allSelectedOptions.size());
		
		page.cadastrar();
//		dsl.clicarBotao("elementosForm:cadastrar");
//		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
//		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado"));
//		Assert.assertTrue(dsl.obterTexto("resultado").startsWith("Cadastrado"));
//		Assert.assertEquals("Cadastrado!", driver.findElement(By.id("resultado"));
//		Assert.assertTrue(driver.findElement(By.id("resultado").startsWith("Cadastrado"));

		Assert.assertEquals("Ronaldinho", page.obterNomeCadastro());
//		Assert.assertTrue(page.obterNomeCadastro().endsWith("Ronaldinho"));
//		Assert.assertTrue(dsl.obterTexto("descNome").endsWith("Ronaldinho"));
//		Assert.assertEquals("Nome: Ronaldinho", driver.findElement(By.id("descNome"));
//		Assert.assertTrue(driver.findElement(By.id("descNome").endsWith("Ronaldinho"));
		
		Assert.assertEquals("Gaucho", page.obterSobrenomeCadastro());
//		Assert.assertEquals("Sobrenome: Gaucho", dsl.obterTexto("descSobrenome"));
		
		Assert.assertEquals("Masculino", page.obterSexoCadastro());
//		Assert.assertEquals("Sexo: Masculino", dsl.obterTexto("descSexo"));
		
		Assert.assertEquals("Pizza", page.obterComidaCadastro());
//		Assert.assertEquals("Comida: Pizza", dsl.obterTexto("descComida"));
		
		Assert.assertEquals("mestrado", page.obterEscolaridadeCadastro());
//		Assert.assertEquals("Escolaridade: mestrado", dsl.obterTexto("descEscolaridade"));
		
		Assert.assertEquals("Natacao", page.obterEsporteCadastro());
//		Assert.assertEquals("Esportes: Natacao", dsl.obterTexto("descEsportes"));
		
		Assert.assertEquals("", page.obterSugestoesCadastro());
//		Assert.assertEquals("Sugestoes:", dsl.obterTexto("descSugestoes"));
				
	}
}
