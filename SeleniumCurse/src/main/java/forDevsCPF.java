import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class forDevsCPF {
	@Test
	public void gerarCPF() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.4devs.com.br/gerador_de_cpf");
		driver.findElement(By.id("bt_gerar_cpf")).click();
		
		String cpfGerado = driver.findElement(By.id("texto_cpf")).getText();
		
		System.out.println(cpfGerado);
		
		
	}

}
