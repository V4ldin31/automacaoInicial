package PacotePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConversaoDeMilhas_ProdutosPage {
	
	private WebDriver driver;
	
	public ConversaoDeMilhas_ProdutosPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clicarBtnAdicionar(){
		driver.findElement(By.xpath("//button[.='Adicionar']")).click();
	}
	
	public void adicionarPacoteDeServico(String xpathPacoteDeServico) throws InterruptedException{
		driver.findElement(By.xpath("//*[.='Pacote de serviço']/../div/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(xpathPacoteDeServico)).click();
	}
	
	public void adicionarLotesDeMilhas(String quantidade) throws InterruptedException{
		driver.findElement(By.xpath("//*[.='Lotes de milhas']/../div/input")).sendKeys(quantidade);
		Thread.sleep(1000);
	}
	
	public void adicionarCustoDeMilha(String quantidade) throws InterruptedException{
		driver.findElement(By.xpath("//*[.='Custo de milha']/../div/input")).sendKeys(quantidade);
		Thread.sleep(1000);
	}
	
	public void adicionarFareValueSmiles(String quantidade) throws InterruptedException{
		driver.findElement(By.xpath("//*[.='Fare value smiles']/../div/input")).sendKeys(quantidade);
		Thread.sleep(1000);
	}
	
	public void editarProduto(String xpathProdutoEditar) throws InterruptedException{
		driver.findElement(By.xpath(xpathProdutoEditar)).click();
		Thread.sleep(1000);
	}
	
	public void editarLotesDeMilhas(String quantidade) throws InterruptedException{
		driver.findElement(By.xpath("//*[.='Lotes de milhas']/../div/input")).clear();
		driver.findElement(By.xpath("//*[.='Lotes de milhas']/../div/input")).sendKeys(quantidade);
		Thread.sleep(1000);
	}
	
	public void editarCustoDeMilha(String quantidade) throws InterruptedException{
		driver.findElement(By.xpath("//*[.='Custo de milha']/../div/input")).clear();
		driver.findElement(By.xpath("//*[.='Custo de milha']/../div/input")).sendKeys(quantidade);
		Thread.sleep(1000);
	}
	
	public void editarFareValueSmiles(String quantidade) throws InterruptedException{
		driver.findElement(By.xpath("//*[.='Fare value smiles']/../div/input")).clear();
		driver.findElement(By.xpath("//*[.='Fare value smiles']/../div/input")).sendKeys(quantidade);
		Thread.sleep(1000);
	}
	
	public void clicarBtnSalvar(){
		driver.findElement(By.xpath("//button[.='Salvar']")).click();
	}
	
	public void clicarBtnRemover(){
		driver.findElement(By.xpath("//button[.='Remover']")).click();
	}
	
	public void clicarBtnConfirmar(){
		driver.findElement(By.xpath("//button[.='Confirmar']")).click();
	}

}
