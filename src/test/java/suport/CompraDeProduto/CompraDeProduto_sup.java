package suport.CompraDeProduto;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.Actions;

public class CompraDeProduto_sup {

	private WebDriver driver;
	Actions action;
	
	@FindBy(id = "search_query_top")
	private WebElement cpoSearch;
	
	@FindBy(name = "submit_search")
	private WebElement btnSearch;
	
	@FindBy(xpath = "(//a[contains(text(),'Dresses')])[5]")
	private WebElement abaDresses;
	
	@FindBy(xpath = "//span[contains(.,'Add to cart')]")
	private WebElement btnAddToCart;
	
	@FindBy(xpath = "(//a[contains(text(),'Printed Summer Dress')])[3]")
	private WebElement produto1;
	
	@FindBy(xpath = "(//a[contains(text(),'Printed Dress')])[4]")
	private WebElement produto2;

	@FindBy(xpath = "(//a[contains(text(),'Printed Summer Dress')])[4]")
	private WebElement produto3;
	
	@FindBy(css = ".continue > span")
	private WebElement ContinueShopping;
	
	@FindBy(xpath = "//span[contains(.,'Proceed to checkout')]")
	private WebElement btnSegirParaPagamento;

	@FindBy(css = ".standard-checkout > span")
	private WebElement btnProceedCheckoutSumary;	
	
	@FindBy(css = "button[name=\"processAddress\"] > span")
	private WebElement btnProceedCheckoutAdress;		
	
	@FindBy(id = "uniform-cgv")
	private WebElement aceitaTermos;		
	
	@FindBy(css = ".standard-checkout > span")
	private WebElement btnProceedCheckoutShipping;	
	
	@FindBy(linkText = "Pay by bank wire (order processing will be longer)")
	private WebElement btnPayMyBankWire;
	

	@FindBy(css = ".cheque > span")
	private WebElement btnPayByCheck;
	
	@FindBy(xpath = "//span[contains(.,'I confirm my order')]")
	private WebElement btnConfirMyOrder;
	
	@FindBy(xpath = "//p[contains(.,'Your order on My Store is complete.')]")
	private WebElement spnStoreIsComplete;

	
	
	public CompraDeProduto_sup(WebDriver driver) {
		super();
		this.driver = driver;
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	

	public CompraDeProduto_sup pesquisaProduto(String string) {
		action.digitar(cpoSearch, string);
		action.clicar(btnSearch);
		return new CompraDeProduto_sup(driver);
	}

	public CompraDeProduto_sup clicoSetor(String string) {
		if(string.equals("Women")) {
			try {
				abaDresses.click();
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		return new CompraDeProduto_sup(driver);
	}

	public CompraDeProduto_sup addProdutoCarrinho1() {
		action.clicar(produto1);
		action.clicar(btnAddToCart);
		return new CompraDeProduto_sup(driver);
	}
	
	public CompraDeProduto_sup addProdutoCarrinho2() {
		action.clicar(produto2);
		action.clicar(btnAddToCart);
		return new CompraDeProduto_sup(driver);
	}

	public CompraDeProduto_sup clicaSegirParaPagamento() {
		action.clicar(btnSegirParaPagamento);
		return new CompraDeProduto_sup(driver);
		
	}
	
	public CompraDeProduto_sup clicoProcessCheckoutSumary() {
		action.clicar(btnProceedCheckoutSumary);
		return new CompraDeProduto_sup(driver);
	}
	
	public CompraDeProduto_sup clicoProcessCheckoutAdress() {
		action.clicar(btnProceedCheckoutAdress);
		return new CompraDeProduto_sup(driver);
	}
	
	public CompraDeProduto_sup clicoProcessCheckoutShipping() {
		action.clicar(aceitaTermos);
		action.clicar(btnProceedCheckoutShipping);
		return new CompraDeProduto_sup(driver);
	}

	public CompraDeProduto_sup clicoPayByBankWire() {
		action.clicar(btnPayMyBankWire);
		return new CompraDeProduto_sup(driver);
	}

	public CompraDeProduto_sup clicoConfirmOrder() {
		action.clicar(btnConfirMyOrder);
		return new CompraDeProduto_sup(driver);
		
	}

	public boolean validaResposta(String string) {
		return action.validaResp(spnStoreIsComplete, string);
	}

	public CompraDeProduto_sup clicaContinueShopping() {
		action.clicar(ContinueShopping);
		return new CompraDeProduto_sup(driver);
	}

}
