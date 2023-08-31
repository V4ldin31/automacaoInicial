import static br.ce.wcaquino.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.DriverFactory;



public class TesteFramesEJanelas {


private DSL dsl;
	
	
	@Before
	public void inicializa(){

	getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	dsl = new DSL();
	}


	@After
	public void finaliza() {
		DriverFactory.killdriver();
	}
	
	@Test
	public void deveInteragirComFrames() {
		
		getDriver().switchTo().frame("frame1");
		getDriver().findElement(By.id("frameButton")).click();
		
		Alert alert = getDriver().switchTo().alert();
		String MsgAlert = alert.getText();
		Assert.assertEquals("Frame OK!", MsgAlert);
		alert.accept();

		getDriver().switchTo().defaultContent();
		getDriver().findElement(By.id("elementosForm:nome")).sendKeys(MsgAlert);
		
	}
	
	@Test
	public void deveInteragirComJanelas() {
			
		getDriver().findElement(By.id("buttonPopUpEasy")).click();
		getDriver().switchTo().window("Popup");
		getDriver().findElement(By.tagName("textarea")).sendKeys("Deu Certo?");
		getDriver().close();
		
		getDriver().switchTo().window("");
		getDriver().findElement(By.id("elementosForm:sugestoes")).sendKeys("E Agora?");	
		
	}
	
	@Test
	public void deveInteragirComJanelasSemTitulo() {
			
		getDriver().findElement(By.id("buttonPopUpHard")).click();
		System.out.println(getDriver().getWindowHandles()); // COMANDO PARA SABER O ID DA JANELA QUANDO ELA NÃO TIVER TITULO
		
		getDriver().switchTo().window((String)getDriver().getWindowHandles().toArray()[1]);
		getDriver().findElement(By.tagName("textarea")).sendKeys("Deu Certo");
		getDriver().close();
		
		getDriver().switchTo().window((String)getDriver().getWindowHandles().toArray()[0]);
		getDriver().findElement(By.tagName("textarea")).sendKeys("Deu Certo");
		
	}
	
	@Test
	public void deveInteragirComFrameEscondido() {
		WebElement frame = getDriver().findElement(By.id("frame2"));
		dsl.executarJs("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		
		dsl.entrarFrame("frame2");
		dsl.clicarBotao("frameButton");
		
	//	Alert alert = getDriver().switchTo().alert();
		String msgAlert = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msgAlert);
	//	alert.accept();

		
		
	}
}
