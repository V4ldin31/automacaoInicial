package br.ce.wcaquino.tests;

import static br.ce.wcaquino.utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.MovimentacaoPage;
import br.ce.wcaquino.utils.DataUtils;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
		
	@Test
	public void teste1InserirMovimentcao() {
			menuPage.acessarTelainserirMovimentacao();
			
			movPage.setDataMovimentacao(obterDataFormatada(new Date()));
//			movPage.setDataMovimentacao("01/09/2017");
			
			movPage.setDataPagamento(obterDataFormatada(new Date()));
//			movPage.setDataPagamento("02/09/2017");
			
			movPage.setDescricao("Movimenta��o do Teste");
			movPage.setInteressado("Interessado Qualquer");
			movPage.setValor("500");
			movPage.setConta("Conta do Teste Alterada2");
			movPage.setStatusPago();
			movPage.salvar();
			
			Assert.assertEquals("Movimenta��o adicionada com sucesso!", movPage.obterMensagemSucesso());
		}
	
	@Test
	public void test2CamposObrigatorios() {
		menuPage.acessarTelainserirMovimentacao();
		movPage.salvar();
		List<String> erros = movPage.obterErros(); //CTRL + 1
	//	Assert.assertEquals("Data da Movimenta��o � obrigat�rio", erros.get(0)); Esta forma n�o � a melhor pois fica amarrada a ordem.
	//	Assert.assertTrue(erros.contains("Data da Movimenta��o � obrigat�rio")); Esta forma temos que usar uma linha pra cada resultado.
		Assert.assertTrue(erros.containsAll(Arrays.asList(
			    "Data da Movimenta��o � obrigat�rio",
			    "Data do pagamento � obrigat�rio",
			    "Descri��o � obrigat�rio",
				"Interessado � obrigat�rio",
			    "Valor � obrigat�rio",
				"Valor deve ser um n�mero"
				)));
		Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void test3InserirMovimentacaoFutura() {
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		menuPage.acessarTelainserirMovimentacao();
		movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movPage.setDataPagamento(obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimenta��o do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta do Teste Alterada2");
		movPage.setStatusPago();
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
		
		Assert.assertTrue(erros.contains("Data da Movimenta��o deve ser menor ou igual � data atual"));
		Assert.assertEquals(1, erros.size());
	}
}
