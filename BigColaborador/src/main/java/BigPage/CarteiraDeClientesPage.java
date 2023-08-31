package BigPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarteiraDeClientesPage {
	
	private WebDriver driver;
	
	public CarteiraDeClientesPage (WebDriver driver ) {
		this.driver = driver;
	}
	
	public void clicarNovaCarteiraCliente() throws InterruptedException {
		driver.findElement(By.xpath("(//*[contains(text(),'Nova Carteira Cliente')])[1]")).click();
		Thread.sleep(5000);
	}
	
	public void setNome(String nome) throws InterruptedException {
		driver.findElement(By.id("input-181")).sendKeys(nome);
		Thread.sleep(2000);
	}
	
	public void setTipoCarteira(String texto) {
		driver.findElement(By.id("input-184")).click();
		driver.findElement(By.xpath("(//*[contains(text(),'"+texto+"')])[1]")).click();
		
	}
	
	public void setSetor(String texto) {
		driver.findElement(By.id("input-190")).click();
		driver.findElement(By.xpath("(//*[contains(text(),'"+texto+"')])[1]")).click();
	}
	
	public void setEndereco(String endereco) throws InterruptedException {
		driver.findElement(By.id("input-205")).sendKeys(endereco);
		Thread.sleep(2000);
	}
	
	public void continuar() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='v-btn v-btn--contained theme--dark v-size--default blue darken-1']")).click();
		Thread.sleep(2000);
	}
	
	public void cancelar() {
		driver.findElement(By.xpath("//span[.='Cancelar']")).click();
	}

}
