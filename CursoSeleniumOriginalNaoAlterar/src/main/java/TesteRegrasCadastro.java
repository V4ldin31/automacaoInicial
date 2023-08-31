import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class TesteRegrasCadastro {
	
	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String Sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String[] esportes;
	public String msg;
		
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
			driver.close();
		}
		
		@Parameters
		public static Collection<Object[]> getCollection(){
			return Arrays.asList(new Object[][]{
				{"","","",Arrays.asList(), new String[] {} /*"Nome eh obrigatorio"*/},
//				{"Ronaldinho","","",Arrays.asList(), new String[] {} "Sobrenome eh obrigatorio"},
//				{"Ronaldinho","Gaucho","",Arrays.asList(), new String[] {} "Sexo eh obrigatorio"},
//				{"Ronaldinho","Gaucho","Masculino",Arrays.asList("Carne","Vegetariano"), new String[] {} "Tem Certeza que voce é vegetariano?"},
//				{"Ronaldinho","Gaucho","Masculino",Arrays.asList("Carne"), new String[] {"Natacao","O que eh esporte?"} "Tvoce faz espporte ou nao?"},
			});	
		}
		
		@Test
	public void deveValidarRegras() {
		page.setNome(nome);
		page.setSobrenome(Sobrenome);
		
		if(sexo.equals("Masculino"))
			{page.setSexoMasculino();}
			else
				{page.setSexoFeminino();}
		
		if(comidas.contains("Carne")) page.setComidaCarne();
		if(comidas.contains("Pizza")) page.setComidaPizza();
		if(comidas.contains("Vegetariano")) page.setComidaVagetariano();
		page.setComidaCarne();
		page.setEsporte(esportes);
		page.cadastrar();
		
		
		
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		
		System.out.println(alert.getText());
		alert.accept();
		
	
	}
}
