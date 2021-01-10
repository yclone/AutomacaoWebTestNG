package suport.CadastroCliente;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.Actions;
import Commons.PFDados;

public class CadastroCliente_sup {

	private WebDriver driver;
	Actions action;

	@FindBy(linkText = "Sign in")
	private WebElement btnSignIn;

	@FindBy(id = "email_create")
	private WebElement email_create;

	@FindBy(xpath = "//button[@id='SubmitCreate']/span")
	private WebElement btnSubmitCreate;

	@FindBy(id = "id_gender1")
	private WebElement id_gender1;

	@FindBy(id = "id_gender2")
	private WebElement id_gender2;

	@FindBy(id = "customer_firstname")
	private WebElement customer_firstname;

	@FindBy(id = "customer_lastname")
	private WebElement customer_lastname;

	@FindBy(id = "passwd")
	private WebElement passwd;

	@FindBy(id = "address1")
	private WebElement address1;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(css = ".id_state")
	private WebElement id_stateLb;
	
	@FindBy(id = "id_state")
	private WebElement id_state;

	@FindBy(id = "postcode")
	private WebElement postcode; // 00000

	@FindBy(id = "id_country")
	private WebElement id_country;

	@FindBy(id = "alias")
	private WebElement alias;
	
	@FindBy(id = "phone_mobile")
	private WebElement phone_mobile;

	@FindBy(xpath = "//button[@id='submitAccount']/span")
	private WebElement btnSubmitAccount;
	
	@FindBy(xpath = "//header[@id='header']/div[2]/div/div/nav/div/a/span")
	private WebElement cpoNomeLogin;
	
	@FindBy(css = "ol > li")
	private WebElement cpoErro;
	

	public CadastroCliente_sup(WebDriver driver) {
		super();
		this.driver = driver;
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	public CadastroCliente_sup acessarSite(String string) {
		action.Navegate(string);
		return new CadastroCliente_sup(driver);
	}
	
	public CadastroCliente_sup clicarBtnSingIn() {
		action.clicar(btnSignIn);
		return new CadastroCliente_sup(driver);
	}
	
	public CadastroCliente_sup digitaEmailEClicaCreateAcont(String email) {
		action.digitar(email_create, email);
		action.clicar(btnSubmitCreate);
		return new CadastroCliente_sup(driver);
	}
	
	public CadastroCliente_sup createAcontCompleto(PFDados pFDados) {
		if (pFDados.getSexo().equals("Masculino")) {
			action.clicar(id_gender1);
		} else {
			action.clicar(id_gender2);
		}
		ArrayList NomeCompleto = new ArrayList();
		NomeCompleto = SplitNome(pFDados.getNome());
		action.digitar(customer_firstname, NomeCompleto.get(0).toString());
		action.digitar(customer_lastname, NomeCompleto.get(1).toString());
		action.digitar(passwd, pFDados.getSenha());
		action.digitar(address1, pFDados.getEndereco());
		action.digitar(city, pFDados.getCidade());
		action.selecionar(id_stateLb, id_state, "Alabama");	
		action.digitar(postcode, pFDados.getCep());
//		action.clicar(id_country);
//		action.clicar(alias);
		action.digitar(phone_mobile, pFDados.getCelular());
		action.clicar(btnSubmitAccount);
		return new CadastroCliente_sup(driver);
	}


	public boolean validaResposta(String nome) {
		return action.validaResp(cpoNomeLogin, nome);
	}

	public boolean validaRespostaErro(String resp) {
		return action.validaResp(cpoErro, resp);
	}
	
	public ArrayList<String> SplitNome(String resp) {
		String[] NomeCompletoSplit = resp.split(" ");
		ArrayList NomeCompleto = new ArrayList();
		String primNome = NomeCompletoSplit[0];
		String segNome = "";
		
		for (int i = 0; i < NomeCompletoSplit.length; i++) {
			if(i != 0) {
				segNome = segNome + " " + NomeCompletoSplit [i];
			}
		}
		NomeCompleto.add(primNome);
		NomeCompleto.add(segNome);
		return NomeCompleto;
	}

}
