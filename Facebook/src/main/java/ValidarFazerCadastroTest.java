import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ValidarFazerCadastroTest {

        private WebDriver driver;
        private LoginPage login;
        private CadastroPage cadastro;


        @Before
        public void inicializa(){
        		WebDriver driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get("https://www.facebook.com");
                login = new LoginPage(driver);
                cadastro = new CadastroPage(driver);
        }

//        @After
//        public void finaliza(){
//                driver.close();
//        }

        @Test
        public void fazerCadastro() throws InterruptedException{
                login.clicarBtnNovaConta();
                Thread.sleep(2000);
                cadastro.setNome("Nei");
                cadastro.setSobreNome("Tester");
                cadastro.setEmailCelular("Teste@teste123.com");
                cadastro.setSenha("Teste@teste123.com");
                cadastro.setDiaNasc("5");
                cadastro.setMesNasc("10");
                cadastro.setAnoNasc("1985");
                cadastro.setSexoMasculino();
                cadastro.clicarBtnCadasreSe();

        }
}
