package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest{
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();

	@Test
	public void testExcluirCintaComMovimentacao() {
		menuPage.acessarTelaListarConta();
		contasPage.clicarExcluirConta("Conta do Teste Alterada2");

		Assert.assertEquals("Conta em uso na movimenta��es", contasPage.obterMensagemErro());
		
	}
}
