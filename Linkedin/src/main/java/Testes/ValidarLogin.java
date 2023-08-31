package Testes;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.HomePage;
import Pages.LoginPage;

public class ValidarLogin {
	private WebDriver driver;
	private HomePage home;
	private LoginPage  login;

	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.get("https://br.linkedin.com/");
		driver.manage().window().maximize();
		home = new HomePage(driver);
		login = new LoginPage(driver);
		
	}
	
//	@After
//	public void finaliza() {
//		driver.close();
//	}
//	
	
	
	@Test
	public void fazerLogin() {
		home.clicarEntrar();
		login.setEmailouTelefone("valdinei_araujo@outlook.com");
		login.setSenha("tri.color");
		login.clicarEntrar();
	}
}
