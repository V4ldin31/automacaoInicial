package br.ce.wcaquino.core;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	public void escreve(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public void escreve(String id_campo, String texto) {
		getDriver().findElement(By.id(id_campo)).clear();
		getDriver().findElement(By.id(id_campo)).sendKeys(texto);
	}
	
		
	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
	
	public void clicarRadioButon(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarRadioButon(String id) {
		clicarRadioButon(By.id(id));
	}
	
	public boolean isRadioMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	public void selecionarCombo(String id, String valorSelecionado) {
		WebElement element =  getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valorSelecionado);
	}
	
	
	public String obterValorCombo(String id) {
		WebElement element =  getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
		
	}
	
	public void clicarBotao(String id) {
		clicarBotao(By.id(id));
	}
	
	public void clicarBotaoPorTexto(String texto) {
		clicarBotao(By.xpath("//button[.='"+texto+"']"));
	}
	
	public void clicarLink(String linkText) {
		getDriver().findElement(By.linkText(linkText)).click();
	}
	
	
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterTexto(String id) {
		return getDriver().findElement(By.id(id)).getText();
	}
	
	public void mudarParaAlert() {
		getDriver().switchTo().alert();
		
	}
	
	/********* JS ***********/
	
	public void executarJs(String cmd, Object...  param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();	
////		js.executeScript("alert('Testando Js via Selenium')");
//		js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via Js'");
//		js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
//		
//		WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
		js.executeScript(cmd, param);
	}
	
	
	/*********** Frames e Janelas***************/
	public void entrarFrame(String id_frame) {
		getDriver().switchTo().frame(id_frame);
	}
	
	public String alertaObterTextoEAceita() {
		Alert alert = getDriver().switchTo().alert();
		String msg =  alert.getText();
		alert.accept();
		return msg;
	    
	}
		
	/**********Tabela***********/
	
	public WebElement obterCelula(String colunaBusca, String valor, String colunabotao, String idTabela) {
		//Procurar Coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//Encontrar a linha do Registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//Procurar coluna do botão
		int idColunaBotao = obterIndiceColuna(colunabotao, tabela);
		
		//Clicar no botão da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		return celula;
	}
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunabotao, String idTabela) {
		WebElement celula = obterCelula(colunaBusca, valor, colunabotao, idTabela);
		celula.findElement(By.xpath(".//input")).click();
	}



	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}



	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}
}
