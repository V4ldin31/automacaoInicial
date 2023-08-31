package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.HomePage;

public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();
	
	@Test
	public void testSaldoConta() {
		Assert.assertEquals("500.00", page.obterSaldoConta("Conta do Teste Alterada2"));
		
	}
}
