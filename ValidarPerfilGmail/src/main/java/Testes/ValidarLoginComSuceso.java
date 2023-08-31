package Testes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.LoginPage;

public class ValidarLoginComSuceso {

	private WebDriver driver;
	private LoginPage login;

	
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
	}

//	@After
//	public void finaliza() {
//		driver.close();
//	}
	
	
	public void fazerLogin() {
		login.fazerLogin();
	}
	
	
	

}
