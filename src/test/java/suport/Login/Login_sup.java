package suport.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.Actions;

public class Login_sup {

	private WebDriver driver;
	Actions action;
	
	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "passwd")
	private WebElement passwd;
	
	@FindBy(xpath = "//button[@id='SubmitLogin']/span")
	private WebElement btnSingIn;
	
	@FindBy(xpath = "//header[@id='header']/div[2]/div/div/nav/div/a/span")
	private WebElement cpoNomeLogin;
	
	@FindBy(css = "ol > li")
	private WebElement cpoErr;
	
	
	public Login_sup(WebDriver driver) {
		super();
		this.driver = driver;
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	public Login_sup DigitoEmailSenha(String email2, String senha) {
		action.digitar(email, email2);
		action.digitar(passwd, senha);
		return new Login_sup(driver);
	}

	public Login_sup clicoBtnSingIn() {
		action.clicar(btnSingIn);
		return new Login_sup(driver);
	}

	public boolean validaResposta(String string) {
		return action.validaResp(cpoNomeLogin, string);
	}

	public boolean validaRespostaErr(String string) {
		return action.validaResp(cpoErr, string);
	}
	
	
}
