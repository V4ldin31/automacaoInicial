import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {
	
	private DSL dsl;
	
	private WebDriver driver;
	
	
	public CampoTreinamentoPage(WebDriver driver) {
		dsl = new DSL(driver);
	}

	public void setNome(String nome) {
		dsl.escreve("elementosForm:nome",nome);	
	}

	public void setSobrenome(String sobrenome) {
		dsl.escreve("elementosForm:sobrenome", sobrenome);
	}
	
	public void setSexoMasculino() {
		dsl.clicarRadioButon("elementosForm:sexo:0");
	}
	
	public void setSexoFeminino() {
		dsl.clicarRadioButon("elementosForm:sexo:1");
	}
	
	public void setComidaPizza() {
		dsl.clicarRadioButon("elementosForm:comidaFavorita:2");
	}
	
	public void setComidaCarne() {
		dsl.clicarRadioButon("elementosForm:comidaFavorita:0");
	}
	
	public void setComidaVagetariano() {
		dsl.clicarRadioButon("elementosForm:comidaFavorita:3");
	}
	
	public void setEscolaridade(String valor) {
	dsl.selecionarCombo("elementosForm:escolaridade", valor);
	}
	
	public void setEsporte(String... valores) {
		for(String valor: valores)
			dsl.selecionarCombo("elementosForm:esportes", valor);
	}
	
	public void cadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}
	
	public String obterResultadoCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id = 'resultado']/span"));
//		return dsl.obterTexto("resultado");
	}
	
	public String obterNomeCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id = 'descNome']/span"));
//		return dsl.obterTexto("descNome");
	}
	
	public String obterSobrenomeCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id = 'descSobrenome']/span"));
//		return dsl.obterTexto("descSobrenome");
	}
	
	public String obterSexoCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id = 'descSexo']/span"));
//		return dsl.obterTexto("descSexo");
	}
	
	public String obterComidaCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id = 'descComida']/span"));
//		return dsl.obterTexto("descComida");
	}
	
	public String obterEscolaridadeCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id = 'descEscolaridade']/span"));
//		return dsl.obterTexto("descEscolaridade");
	}
	
	public String obterEsporteCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id = 'descEsportes']/span"));
//		return dsl.obterTexto("descEsportes");
	}
	
	public String obterSugestoesCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id = 'descSugestoes']/span"));
//		return dsl.obterTexto("descSugestoes");
	}
	
	
}
