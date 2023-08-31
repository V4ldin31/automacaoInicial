package PacotePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdicionarProdutoPage {
	
	private WebDriver driver;
	
	public AdicionarProdutoPage(WebDriver driver) {
		this.driver = driver;
	}
	 

	public void selecionarPacoteServicos(String xpathPacoteDeServicos) {
		driver.findElement(By.xpath("//label[.='Pacote de serviços']/../div/div")).click();
		driver.findElement(By.xpath(xpathPacoteDeServicos)).click();		
	}
	
	public void selecionarProduto(String xpathProduto) {
		driver.findElement(By.xpath("//label[.='Produto']/../div")).click();
		driver.findElement(By.xpath(xpathProduto)).click();
	}
	
	public void inserirNomeDoProduto(String nomeDoProduto) {
		driver.findElement(By.xpath("//label[.='Nome do produto']/../div/input")).sendKeys(nomeDoProduto);
	}
	
	public void selecionarTipoDePonto(String xpathTipoDePonto) {
		driver.findElement(By.xpath("//label[.='Tipo de milhas']/../div")).click();
		driver.findElement(By.xpath(xpathTipoDePonto)).click();
	}
	
	public void inserirValorDoPonto(String valorDoPonto) {
		driver.findElement(By.xpath("//label[.='Valor do ponto']/../div/input")).sendKeys(valorDoPonto);
	}
	
	public void inserirFareValuesSmiles(String fareValueSmiles) {
		driver.findElement(By.xpath("//label[.='Fare value smiles']/../div/input")).sendKeys(fareValueSmiles);
	}
	
	public void inserirInicioDaVigencia(String inicioDaVigencia) {
		driver.findElement(By.xpath("//label[.='Início da vigência']/../div/input")).sendKeys(inicioDaVigencia);
	}
	
	public void inserirFimDaVigencia(String FimDaVigencia) {
		driver.findElement(By.xpath("//label[.='Fim da vigência']/../div/input")).sendKeys(FimDaVigencia);
	}
	
	public void cancelar() {
		driver.findElement(By.xpath("//*[.='Cancelar']")).click();
	}
}
