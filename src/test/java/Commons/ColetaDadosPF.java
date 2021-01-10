package Commons;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import runnerFiles.DriverFactory;

public class ColetaDadosPF {
	
	WebDriver driver;
	PFDados pf;
	JSWaiter jSWaiter;
	
	@Test
	private void coleta() throws Exception {
		DriverFactory.setDriver(2);
		pf = ColataValores();
		System.out.println(pf.getNome());
		driver.close();
	}
	
	
	public PFDados ColataValores() {
		driver = DriverFactory.getDriver();
		jSWaiter = new JSWaiter();
		jSWaiter.setDriver(driver);
		driver.navigate().to("https://www.4devs.com.br/gerador_de_pessoas");
		driver.findElement(By.id("bt_gerar_pessoa")).click();
		jSWaiter.waitAllRequest();
		String pessoa = "";
		do {
			driver.findElement(By.id("btn_json_tab")).click();
			pessoa = driver.findElement(By.id("dados_json")).getText();
		} while (pessoa.equals("Gerando pessoas, por favor aguarde...") || pessoa.equals(""));
		
		System.out.println("DADOS COLETADOS = " + pessoa);
		Gson gson = new Gson();
		return gson.fromJson(pessoa, PFDados.class);
	}
	
}
