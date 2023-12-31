package br.ce.wcaquino.tests;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {
private MenuPage menuPage = new MenuPage();
private ResumoPage resumoPage = new ResumoPage();

	
	@Test
	public void teste1ExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		resumoPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!", 
				resumoPage.obterMensagemSucuesso());
		
	}
	
	
                                        /***Maneira 1***/
	@Test(expected = org.openqa.selenium.NoSuchElementException.class) 
	public void test2ResumoMensal() {
		menuPage.acessarTelaResumo();
		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
	}
	
		
	
		
		/*******************************Maneira 2 Usando try Catch*************************************************************
		@Test
		public void test2ResumoMensal() {
			menuPage.acessarTelaResumo();
			
			Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
			
			try {
				DriverFactory.getDriver().findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
				Assert.fail();
			} catch (org.openqa.selenium.NoSuchElementException e) {
				
			}
		*********************************************************************************************************************/
		
		

		/**************************************Maneira 3 usando lista de elementos**********************************************************************
		@Test
		public void test2ResumoMensal() {
			menuPage.acessarTelaResumo();
			
			Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
			
			
				List<WebElement> elementosEncontrados = 
						DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
				Assert.assertEquals(0, elementosEncontrados.size());
				
			}
		**********************************************************************************************************************/
}
