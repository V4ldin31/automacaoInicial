import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class teste {

	@Test
	public void teste() throws IOException {
// System.setProperty("webdriver.gecko.driver", "C:\\SeleniumWebdriverUdemy/geckodriver.exe");
		
 		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
//		InternetExplorerDriver driver = new InternetExplorerDriver();
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("screenshot.jpg"));
		
		driver.quit();
	}

	private TakesScreenshot getDriver() {
		// TODO Auto-generated method stub
		return null;
	}
}
