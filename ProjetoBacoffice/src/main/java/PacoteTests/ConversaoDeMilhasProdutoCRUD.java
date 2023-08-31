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

import PacotePages.ConversaoDeMilhas_ProdutosPage;
import PacotePages.HomePage;
import PacotePages.LoginPage;

public class ConversaoDeMilhasProdutoCRUD {

	
		private WebDriver driver;
		private LoginPage loginPage;
		private HomePage home;
		private ConversaoDeMilhas_ProdutosPage conv_produtosPage;

		@Before
		public void iniciar() {
			driver = new FirefoxDriver();
			driver.get("https://backoffice.hml.bank.pagol.com.br/");
			driver.manage().window().maximize();
			loginPage = new LoginPage(driver);
			home = new HomePage(driver);
			conv_produtosPage = new ConversaoDeMilhas_ProdutosPage(driver);
		}
		
		@Rule
		public TestName testName = new TestName();
		
		@After
		public void finaliza() throws IOException  {
			TakesScreenshot miScreen = ((TakesScreenshot)driver);
			File DestinoArquivo = new File("C:" + File.separator + 
					"TestesBackoffice" + File.separator + "ConversaoDeMilhas" + File.separator +testName.getMethodName() + ".jpg");
			File arquivo = miScreen.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, DestinoArquivo);
			
			//driver.close();
		}
		
		@Test
		public void ValidarCrud() throws InterruptedException {
			Thread.sleep(2000);
			loginPage.fazerLogin();
//			WebDriverWait wait = new WebDriverWait(driver, 20);
//			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[.='CONVERSÃO DE MILHAS']/../div/div[1]")));	
			Thread.sleep(5000);
			home.acessarProdutoConversaoDeMilhas();
			Thread.sleep(3000);
			
			/********* CRIAR PRODUTO ***********/
			conv_produtosPage.clicarBtnAdicionar();
			conv_produtosPage.adicionarPacoteDeServico("//*[.='Turbo Milhas']");
			conv_produtosPage.adicionarLotesDeMilhas("9999");
			conv_produtosPage.adicionarCustoDeMilha("1");
			conv_produtosPage.adicionarFareValueSmiles("0,999");
			conv_produtosPage.clicarBtnAdicionar();
			Thread.sleep(1500); 
			Assert.assertEquals("Produto criado com sucesso!", 
					driver.findElement(By.xpath("//span[.='Produto criado com sucesso!']")).getText());
			
			/******** EDITAR PRODUTO ************/
			conv_produtosPage.editarProduto("//div[@data-value='9999']/../div[4]");
			conv_produtosPage.editarLotesDeMilhas("8888");
			conv_produtosPage.editarCustoDeMilha("2");
			conv_produtosPage.editarFareValueSmiles("0,8888");
			conv_produtosPage.clicarBtnSalvar();
			Thread.sleep(1500);  
			Assert.assertEquals("Produto editado com sucesso!", 
					driver.findElement(By.xpath("//span[.='Produto editado com sucesso!']")).getText());
			
			/******** REMOVER PRODUTO ************/
			conv_produtosPage.editarProduto("//div[@data-value='8888']/../div[4]");
			conv_produtosPage.clicarBtnRemover();
			conv_produtosPage.clicarBtnConfirmar();
			Thread.sleep(1500); 
			Assert.assertEquals("Produto removido com sucesso!", 
					driver.findElement(By.xpath("//span[.='Produto removido com sucesso!']")).getText());
				
		}	
			
	}

