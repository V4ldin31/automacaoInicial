import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CadastroPage {

    private WebDriver driver;

    public CadastroPage (WebDriver driver){
        this.driver = driver;
    }

    public void setNome(String nome){
        driver.findElement(By.xpath("//div[@class='_8ien']//form//input[@name='firstname']")).sendKeys(nome);
    }

    public void setSobreNome(String sobrenome){
        driver.findElement(By.name("lastname")).sendKeys(sobrenome);
    }

    public void setEmailCelular(String emailCelular){
        driver.findElement(By.name("reg_email__")).sendKeys(emailCelular);
    }

    public void setSenha(String senha){
        driver.findElement(By.id("password_step_input")).sendKeys(senha);
    }

    public void setDiaNasc(String diaNasc){
        WebElement element = driver.findElement(By.id("day"));
        Select dia = new Select(element);
        dia.selectByValue(diaNasc);
    }

    public void setMesNasc(String mesNasc){
        WebElement element = driver.findElement(By.id("month"));
        Select mes = new Select(element);
        mes.selectByValue(mesNasc);
    }

    public void setAnoNasc(String anoNasc){
        WebElement element = driver.findElement(By.id("year"));
        Select ano = new Select(element);
        ano.selectByValue(anoNasc);
    }

    public void setSexoFeminino(){
        driver.findElement(By.xpath("//input[@value='1']")).click();
    }

    public void setSexoMasculino(){
        driver.findElement(By.xpath("//input[@value='2']")).click();
    }

    public void clicarBtnCadasreSe(){
        driver.findElement(By.name("websubmit")).click();
    }


}
