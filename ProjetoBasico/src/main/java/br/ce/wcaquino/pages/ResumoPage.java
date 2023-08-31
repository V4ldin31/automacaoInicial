package br.ce.wcaquino.pages;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class ResumoPage extends BasePage {

	public void excluirMovimentacao() {
		clicarBotao(By.xpath("//Span[@Class = 'glyphicon glyphicon-remove-circle']"));
	}
	
	public String obterMensagemSucuesso() {
		return obterTexto(By.xpath("//div[@class = 'alert alert-success']"));
	}
}
