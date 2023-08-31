package PacoteTests;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PacotePages.AdicionarProdutoPage;
import PacotePages.HomePage;
import PacotePages.LoginPage;
import PacotePages.ProdutosPage;

public class ValidarCadastroProdutos {
	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage home;
	private ProdutosPage produtos;
	private AdicionarProdutoPage adicionarProduto;

	@Before
	public void iniciar() {
		driver = new FirefoxDriver();
		driver.get("https://backoffice.hml.bank.pagol.com.br/");
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		home = new HomePage(driver);
		produtos = new ProdutosPage(driver);
		adicionarProduto = new AdicionarProdutoPage(driver);
	}
	
	@Rule
	public TestName testName = new TestName();
	
	@After
	public void finaliza() throws IOException  {
		TakesScreenshot miScreen = ((TakesScreenshot)driver);
		File DestinoArquivo = new File("C:" + File.separator + 
				"TestesBackoffice" + File.separator + testName.getMethodName() + ".jpg");
		File arquivo = miScreen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, DestinoArquivo);
		
		//driver.close();
	}
	
	@Test
	public void ValidarTelaProdutos() throws InterruptedException {
		Thread.sleep(4000);
		loginPage.fazerLogin();
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[.='Produtos']")));	
		home.acessarProdutos();
		
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[.='Adicionar']")));	
		produtos.clicarAdicionar();
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//label[.='Pacote de serviços']/../div/div")));	
		adicionarProduto.selecionarPacoteServicos("//*[.='Ferro']");
		adicionarProduto.inserirNomeDoProduto("Teste de Automação");
		adicionarProduto.selecionarProduto("//*[.='Transferência de milhas']");
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[.='Base']")));
		adicionarProduto.selecionarTipoDePonto("//*[.='Base']");
		adicionarProduto.inserirValorDoPonto("0,041");
		adicionarProduto.inserirFareValuesSmiles("0,077");
		adicionarProduto.inserirInicioDaVigencia("10/10/2025");
		adicionarProduto.inserirFimDaVigencia("11/11/2025");
		Thread.sleep(5000);
		adicionarProduto.cancelar();
		
		
		Assert.assertEquals("ADICIONAR", driver.findElement(By.xpath("//button[.='Adicionar']")).getText());
		
	}
		
}
