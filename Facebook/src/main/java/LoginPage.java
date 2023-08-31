import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    public void clicarBtnNovaConta() {
        
        driver.findElement(By.xpath("//div[.=\'Criar nova conta\']/a")).click();
    }
}
