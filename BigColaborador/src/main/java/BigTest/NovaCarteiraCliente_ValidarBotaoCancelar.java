package BigTest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import BigPage.CarteiraDeClientesPage;
import BigPage.HomePage;
import BigPage.LoginPage;

public class NovaCarteiraCliente_ValidarBotaoCancelar {
	
	private WebDriver driver;
	private LoginPage login;
	private HomePage home;
	private CarteiraDeClientesPage carteira;

	

	@Before
	public void inicializa(){
	driver = new FirefoxDriver();
//	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://stage-big-sempreit-front.azurefd.net/");
	login = new LoginPage(driver);
	home = new HomePage(driver);
	carteira = new CarteiraDeClientesPage(driver);
	}
	
	
//	@After
//	public void finaliza() {
//		driver.close();
//	}
	
	@Test
	public void acessarCarteira() throws InterruptedException {
		login.fazerLoginNoBig("valdinei.souza@sempreit.com.br", "Tr1mundial");
		home.acessarMenu();
		home.acessarComercial();
		home.acessarCarteiraCliente();
		carteira.clicarNovaCarteiraCliente();
		carteira.setNome("Teste Campo Nome");
		carteira.setTipoCarteira("CLIENTE");
		carteira.setSetor("Automotivo");
		carteira.setEndereco("Rua do Teste");
		carteira.continuar();
		carteira.cancelar();
	}
}
