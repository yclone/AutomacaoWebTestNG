package stepDefinitions.CadastroCliente;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import Commons.ColetaDadosPF;
import Commons.PFDados;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import runnerFiles.DriverFactory;
import suport.CadastroCliente.CadastroCliente_sup;

public class CadastroCliente_stp {

	CadastroCliente_sup cadastroCliente_sup;
	ColetaDadosPF coletaDadosPF;
	private static PFDados pfDados = new PFDados();

	@Dado("que eu acesse o site {string}")
	public void que_eu_acesse_o_site(String string) {
		cadastroCliente_sup = new CadastroCliente_sup(DriverFactory.getDriver());
		coletaDadosPF = new ColetaDadosPF();
		pfDados = coletaDadosPF.ColataValores();
		pfDados.setCep("00000");
		cadastroCliente_sup.acessarSite(string);
	}

	@Quando("clico em Sign In")
	public void clico_em_Sign_In() {
		cadastroCliente_sup = new CadastroCliente_sup(DriverFactory.getDriver());
		cadastroCliente_sup.clicarBtnSingIn();
	}

	@Quando("na tela de autenticação em create an account no campo email eu digito o email e clico em create an account")
	public void na_tela_de_autenticação_em_create_an_account_no_campo_email_eu_digito_o_email_e_clico_em_create_an_account() {
		cadastroCliente_sup = new CadastroCliente_sup(DriverFactory.getDriver());
		cadastroCliente_sup.digitaEmailEClicaCreateAcont(pfDados.getEmail());
	}

	@Quando("preencho todo os campos obrigatorio para criação de conta e clico em register")
	public void preencho_todo_os_campos_obrigatorio_para_criação_de_conta_e_clico_em_register() {
		cadastroCliente_sup = new CadastroCliente_sup(DriverFactory.getDriver());
		cadastroCliente_sup.createAcontCompleto(pfDados);
	}

	@Entao("a conta deve ser criada com sucesso")
	public void a_conta_deve_ser_criada_com_sucesso() {
		cadastroCliente_sup = new CadastroCliente_sup(DriverFactory.getDriver());
		boolean retorno;
		cadastroCliente_sup = new CadastroCliente_sup(DriverFactory.getDriver());
		retorno = cadastroCliente_sup.validaResposta(pfDados.getNome());
		assertEquals(retorno, true);
	}

	@Quando("preencho todo os campos obrigatorio para criação de conta menos o campo {string} e clico em register")
	public void preencho_todo_os_campos_obrigatorio_para_criacao_de_conta_menos_o_campo_e_clico_em_register(
			String string) {
		cadastroCliente_sup = new CadastroCliente_sup(DriverFactory.getDriver());
		if (string.equals("firstname")) {
			pfDados.setNome(" " + pfDados.getNome().replaceAll(" ", ""));
			
		} else if (string.equals("lastname")) {
			pfDados.setNome(pfDados.getNome().replaceAll(" ", ""));
		} else if (string.equals("passwd")) {
			pfDados.setSenha("");
		} else if (string.equals("city")) {
			pfDados.setCidade("");
		} else if (string.equals("Zip/Postal")) {
			pfDados.setCep("");
		} else if (string.equals("phone")) {
			pfDados.setCelular("");
		}
		cadastroCliente_sup.createAcontCompleto(pfDados);
	}

	@Entao("deve apresentar a mensagem {string}")
	public void deve_apresentar_a_mensagem(String string) {
		boolean retorno;
		cadastroCliente_sup = new CadastroCliente_sup(DriverFactory.getDriver());
		retorno = cadastroCliente_sup.validaRespostaErro(string);
		assertEquals(retorno, true);
	}
}
