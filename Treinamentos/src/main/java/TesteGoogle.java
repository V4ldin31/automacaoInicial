import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {

	@Test
	public void teste() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.4devs.com.br/gerador_de_cpf");
		driver.findElement(By.id("bt_gerar_cpf")).click();	
		
		String cpf = driver.findElement(By.id("texto_cpf")).getText();
		System.out.println("cpf");
	}
}
