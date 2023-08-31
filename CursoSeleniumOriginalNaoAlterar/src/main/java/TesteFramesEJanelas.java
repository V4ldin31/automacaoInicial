import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TesteFramesEJanelas {

private WebDriver driver;
private DSL dsl;
	
	
	@Before
	public void inicializa(){
//	driver = new ChromeDriver();
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	dsl = new DSL(driver);
	}


	@After
	public void finaliza() {
		driver.close();
	}
	
	@Test
	public void deveInteragirComFrames() {
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		
		Alert alert = driver.switchTo().alert();
		String MsgAlert = alert.getText();
		Assert.assertEquals("Frame OK!", MsgAlert);
		alert.accept();

		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(MsgAlert);
		
	}
	
	@Test
	public void deveInteragirComJanelas() {
			
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu Certo?");
		driver.close();
		
		driver.switchTo().window("");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("E Agora?");	
		
	}
	
	@Test
	public void deveInteragirComJanelasSemTitulo() {
			
		driver.findElement(By.id("buttonPopUpHard")).click();
		System.out.println(driver.getWindowHandles()); // COMANDO PARA SABER O ID DA JANELA QUANDO ELA N�O TIVER TITULO
		
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Deu Certo");
		driver.close();
		
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("Deu Certo");
		
	}
	
	@Test
	public void deveInteragirComFrameEscondido() {
		WebElement frame = driver.findElement(By.id("frame2"));
		dsl.executarJs("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		
		dsl.entrarFrame("frame2");
		dsl.clicarBotao("frameButton");
		
	//	Alert alert = driver.switchTo().alert();
		String msgAlert = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msgAlert);
	//	alert.accept();

		
		
	}
}
