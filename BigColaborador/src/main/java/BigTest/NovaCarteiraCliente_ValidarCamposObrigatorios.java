package BigTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import BigPage.CarteiraDeClientesPage;
import BigPage.HomePage;
import BigPage.LoginPage;

public class NovaCarteiraCliente_ValidarCamposObrigatorios {
	
	private WebDriver driver;
	private LoginPage login;
	private HomePage home;
	private CarteiraDeClientesPage carteira;



	@Before
	public void inicializa(){
	//driver = new FirefoxDriver();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://stage-big-sempreit-front.azurefd.net/");
	login = new LoginPage(driver);
	home = new HomePage(driver);
	carteira = new CarteiraDeClientesPage(driver);
	}
	
	@Rule
	public TestName testName = new TestName();
	
	@After
	public void finaliza() throws IOException  {
		TakesScreenshot miScreen = ((TakesScreenshot)driver);
		File DestinoArquivo = new File("target" + File.separator + 
				"Evidencias" + File.separator + testName.getMethodName() + ".jpg");
		File arquivo = miScreen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, DestinoArquivo);
		
		driver.close();
	}
	
	@Test
	public void validarCamposObrigatorios() throws InterruptedException   {
		login.fazerLoginNoBig("valdinei.souza@sempreit.com.br", "Tr1mundial");
		home.acessarMenu();
		home.acessarComercial();
		home.acessarCarteiraCliente();
		carteira.clicarNovaCarteiraCliente();
		carteira.continuar();
			
		
		Assert.assertEquals("O nome da carteira deve ser preenchido.", 
					driver.findElement(By.xpath("//div[.='O nome da carteira deve ser preenchidoooo.']")).getText());
		
		Assert.assertEquals("Uma carteira deve ser selecionada.", 
				driver.findElement(By.xpath("//div[.='Uma carteira deve ser selecionada.']")).getText());
		
		Assert.assertEquals("Esse campo deve ser selecionado.", 
				driver.findElement(By.xpath("//div[.='Esse campo deve ser selecionado.']")).getText());
		
		Assert.assertEquals("Endereço é um campo obrigatório!", 
				driver.findElement(By.xpath("//div[.='Endereço é um campo obrigatório!']")).getText());
		
	}
	
}
