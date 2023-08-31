import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class forDevsCPF {
	
	@Test
	public void gerarCPF() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.4devs.com.br/gerador_de_cpf");
		driver.findElement(By.id("bt_gerar_cpf")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		String CPF = driver.findElement(By.id("texto_cpf")).getText();
		
		System.out.println(CPF);
		
		
	}

}
