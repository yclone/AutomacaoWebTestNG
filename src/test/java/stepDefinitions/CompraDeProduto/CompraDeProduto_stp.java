package stepDefinitions.CompraDeProduto;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import runnerFiles.DriverFactory;
import suport.CompraDeProduto.CompraDeProduto_sup;
import suport.Login.Login_sup;

public class CompraDeProduto_stp {
	
	CompraDeProduto_sup compraDeProduto_sup;
	
	@Quando("na tela inicial do usuario eu clico no setor {string}")
	public void na_tela_inicial_do_usuario_eu_clico_no_setor(String string) {
		compraDeProduto_sup = new CompraDeProduto_sup(DriverFactory.getDriver());
		compraDeProduto_sup.clicoSetor(string);
	}
	
	@Quando("na tela inicial no campo busca digite {string} e clique em pesquisar")
	public void na_tela_inicial_no_campo_busca_digite_e_clique_em_pesquisar(String string) {
		compraDeProduto_sup = new CompraDeProduto_sup(DriverFactory.getDriver());
		compraDeProduto_sup.pesquisaProduto(string);
	}

	@Quando("Adiciono um produto ao meu carrinho")
	public void adiciono_um_produto_ao_meu_carrinho() {
		compraDeProduto_sup = new CompraDeProduto_sup(DriverFactory.getDriver());
		compraDeProduto_sup.addProdutoCarrinho1();
	}

	@Quando("sigo para o pagamento")
	public void sigo_para_o_pagamento() {
		compraDeProduto_sup = new CompraDeProduto_sup(DriverFactory.getDriver());
		compraDeProduto_sup.clicaSegirParaPagamento();
	}

	@Quando("na tela de Summary eu clico em proceed to checkout")
	public void na_tela_de_Summary_eu_clico_em_proceed_to_checkout() {
		compraDeProduto_sup = new CompraDeProduto_sup(DriverFactory.getDriver());
		compraDeProduto_sup.clicoProcessCheckoutSumary();
	}

	@Quando("na tela de adress eu clico em proceed to checkout")
	public void na_tela_de_adress_eu_clico_em_proceed_to_checkout() {
		compraDeProduto_sup = new CompraDeProduto_sup(DriverFactory.getDriver());
		compraDeProduto_sup.clicoProcessCheckoutAdress();
	}

	@Quando("na tela de shipping eu aceito os termos e clico em proceed to checkout")
	public void na_tela_de_shipping_eu_aceito_os_termos_e_clico_em_proceed_to_checkout() {
		compraDeProduto_sup = new CompraDeProduto_sup(DriverFactory.getDriver());
		compraDeProduto_sup.clicoProcessCheckoutShipping();
	}

	@Quando("na tela de opção de pagamento eu clico em pay by bank wire")
	public void na_tela_de_opção_de_pagamento_eu_clico_em_pay_by_bank_wire() {
		compraDeProduto_sup = new CompraDeProduto_sup(DriverFactory.getDriver());
		compraDeProduto_sup.clicoPayByBankWire();
	}

	@Quando("na tela de Payment eu clico em i confirm my order")
	public void na_tela_de_Payment_eu_clico_em_i_confirm_my_order() {
		compraDeProduto_sup = new CompraDeProduto_sup(DriverFactory.getDriver());
		compraDeProduto_sup.clicoConfirmOrder();
	}
	
	@Quando("volto para adicionar mais intens")
	public void volto_para_adicionar_mais_intens() {
		compraDeProduto_sup = new CompraDeProduto_sup(DriverFactory.getDriver());
		compraDeProduto_sup.clicaContinueShopping();
	}

	@Quando("Adiciono um outro produto ao meu carrinho")
	public void adiciono_um_outro_produto_ao_meu_carrinho() {
		compraDeProduto_sup = new CompraDeProduto_sup(DriverFactory.getDriver());
		compraDeProduto_sup.addProdutoCarrinho2();
	}

	@Entao("apos finalizar o pagamento deve apresentar a mensagem {string}")
	public void apos_finalizar_o_pagamento_deve_apresentar_a_mensagem(String string) {
		compraDeProduto_sup = new CompraDeProduto_sup(DriverFactory.getDriver());
		boolean retorno;
		retorno = compraDeProduto_sup.validaResposta(string);
		assertEquals(retorno, true);
	}

}
