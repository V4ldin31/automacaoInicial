package PacoteTestes;

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

import PacotePages.PaginaInicialPage;

public class ValidarBuscaPeloCampoPesquisar {
	private WebDriver driver;
	private PaginaInicialPage paginaInicial;
	
	
	
	@Before
	public void Inicializa() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com");
		paginaInicial = new PaginaInicialPage(driver);
	}
	
	@Rule
	public TestName testName = new TestName();
	
	@After
	public void finaliza() throws IOException  {
		TakesScreenshot miScreen = ((TakesScreenshot)driver);
		File DestinoArquivo = new File("C:" + File.separator + 
				"TestesYoutube" + File.separator + testName.getMethodName() + ".jpg");
		File arquivo = miScreen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, DestinoArquivo);
		
		driver.close();
	}
	
	
	
	@Test
	public void validarCampoPesquisar() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='search']")));
		paginaInicial.inserirTextoBusca("Julio de Lima");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Julio de Lima")));
		Assert.assertEquals("Julio de Lima", driver.findElement(By.linkText("Julio de Lima")).getText());
		
	}

}
