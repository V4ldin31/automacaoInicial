import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
	private WebDriver driver;
	
	
	@Before
	public void inicializa(){
	driver = new FirefoxDriver();
//	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://stage-big-sempreit-front.azurefd.net/");
	}
	
	
	@After
	public void finaliza() {
//		driver.close();
	}
	
	
	@Test
	
	public void fazerLoginNoBig() throws InterruptedException {
		
		/******Digitar E-mail e Clicar em Avançar*******/
		Thread.sleep(1000);
		driver.findElement(By.id("i0116")).sendKeys("valdinei.souza@sempreit.com.br");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
		
		
		/******Digitar Senha e Clicar em Entrar*******/
		driver.findElement(By.id("i0118")).sendKeys("Tr1mundial");
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
		
		/***Acessar Menu***/
		driver.findElement(By.className("v-btn__content")).click();
		Thread.sleep(2000);
		
		/***Acessar Comercial***/
		driver.findElement(By.xpath("//*[contains(text(),'Comercial')]")).click();
		Thread.sleep(1000);
		
		/**** Acessar Tela Carteira de Clientes****/
		driver.findElement(By.xpath("(//*[contains(text(),'Carteira de Clientes')])[1]")).click();
		Thread.sleep(5000);
		
		/* Clicar Nova Carteira Cliente*/
		driver.findElement(By.xpath("(//*[contains(text(),'Nova Carteira Cliente')])[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/main/div/div/div/div/div[2]/header/div/button[2]")).click();
		Thread.sleep(5000);

		driver.findElement(By.id("input-181")).sendKeys("Teste Campo Nome");
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-184")).click();
		driver.findElement(By.xpath("(//*[contains(text(),'CLIENTE')])[1]")).click();
		
		
		driver.findElement(By.id("input-190")).click();
		driver.findElement(By.xpath("(//*[contains(text(),'Automotivo')])[1]")).click();
		
		driver.findElement(By.id("input-205")).sendKeys("Rua do Teste");
		Thread.sleep(2000);
		
//		org.junit.Assert.fail();
		
		driver.findElement(By.xpath("//button[@class='v-btn v-btn--contained theme--dark v-size--default blue darken-1']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='tab-3']/div/div[3]/button")).click();
		
		
		
	//	org.junit.Assert.fail();
		
//driver.close();
		
	}

}
