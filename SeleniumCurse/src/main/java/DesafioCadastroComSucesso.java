import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class DesafioCadastroComSucesso {

	@Test
	public void CadastroComSucesso() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
//		INSERIR  NOME
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Valdinei");
		Assert.assertEquals("Valdinei", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
//		INSERIR SOBRENOME
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Araujo");
		Assert.assertEquals("Araujo", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));

//		SELECIONAR SEXO
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

//		SELECIONAR COMIDA FAVORITA		
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
	
// 		SELECIONAR ESCOLARIDADE
		WebElement escolaridade = driver.findElement(By.id("elementosForm:escolaridade"));
		Select comboEscolaridade = new Select(escolaridade);
		comboEscolaridade.selectByVisibleText("Especializacao");
		Assert.assertEquals("Especializacao", comboEscolaridade.getFirstSelectedOption().getText());
		
//		SELECIONAR ESPORTE		
		WebElement esporte = driver.findElement(By.id("elementosForm:esportes"));
		Select comboEsporte = new Select(esporte);
		comboEsporte.selectByVisibleText("Futebol");
		comboEsporte.selectByVisibleText("Corrida");
		
		List<WebElement> allSelectedOptions = comboEsporte.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
//		CLICAR EM CADASTRAR
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
//		VALIDAR CADASTRO
		
//		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));		
		/* UTILIZANDO XPATH*/
		Assert.assertEquals("Cadastrado!", driver.findElement(By.xpath("//*[@id=\"resultado\"]/span")).getText());
		
//		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Valdinei"));
		/*UTILIZANDO XPATH*/
		Assert.assertEquals("Valdinei", driver.findElement(By.xpath("//*[@id=\"descNome\"]/span")).getText());
		
		Assert.assertEquals("Sobrenome: Araujo", driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Carne", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: especializacao", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Futebol Corrida", driver.findElement(By.id("descEsportes")).getText());
		
//		driver.quit();
		
	
	}
}
