package stepDefinitions.Login;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import runnerFiles.DriverFactory;
import suport.Login.Login_sup;

public class Login_stp {
	
	Login_sup login_sup;
	
	@Quando("em sing in na aba ALREADY REGISTERED no campo email eu digito e email {string} e no campo senha eu digito a senha {string}")
	public void em_sing_in_na_aba_ALREADY_REGISTERED_no_campo_email_eu_digito_e_email_e_no_campo_senha_eu_digito_a_senha(String email, String senha) {
		login_sup = new Login_sup(DriverFactory.getDriver());
		login_sup.DigitoEmailSenha(email, senha);
	}

	@Quando("em sing in na aba ALREADY REGISTERED clico em Sing In")
	public void em_sing_in_na_aba_ALREADY_REGISTERED_clico_em_Sing_In() {
		login_sup = new Login_sup(DriverFactory.getDriver());
		login_sup.clicoBtnSingIn();
	}
	
	@Entao("devo ser logado com sucesso com o usuario {string}")
	public void devo_ser_logado_com_sucesso_com_o_usuario(String string) {
		boolean retorno;
		login_sup = new Login_sup(DriverFactory.getDriver());
		retorno = login_sup.validaResposta(string);
		assertEquals(retorno, true);
	}

	@Entao("deve apresentar a mensagem de erro {string}")
	public void deve_apresentar_a_mensagem_de_erro(String string) {
		boolean retorno;
		login_sup = new Login_sup(DriverFactory.getDriver());
		retorno = login_sup.validaRespostaErr(string);
		assertEquals(retorno, true);
	}
}
