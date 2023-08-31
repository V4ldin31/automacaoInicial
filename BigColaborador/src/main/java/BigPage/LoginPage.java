package BigPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {	
	
	private WebDriver driver;
	
	public LoginPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void fazerLoginNoBig(String email, String senha) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.name("loginfmt")).sendKeys(email);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
		Thread.sleep(1000);
		
		/******Digitar Senha e Clicar em Entrar*******/
		driver.findElement(By.id("i0118")).sendKeys(senha);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
		Thread.sleep(3000);
		
		/******Clicar em Enviar SMS*******/
		driver.findElement(By.xpath("//*[@id='idDiv_SAOTCS_Proofs']/div[1]")).click();
		//driver.findElement(By.xpath("//*[@id=\"idDiv_SAOTCS_Proofs\"]/div[1]/div/div/div[2]")).click();
		Thread.sleep(20000);
		
		/******Clicar no CheckBox*******/
		driver.findElement(By.id("idChkBx_SAOTCC_TD")).click();
		driver.findElement(By.id("idSubmit_SAOTCC_Continue")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("KmsiCheckboxField")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("idSIButton9")).click();
		
		Thread.sleep(1000);
	}

}
