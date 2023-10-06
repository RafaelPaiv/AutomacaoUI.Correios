package correios.automacao.git.steps;

import correios.automacao.git.config.IniciarTeste;
import correios.automacao.git.metodos.Metodos;
import correios.automacao.git.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Address_research_test {
	
	Metodos metodo = new Metodos();
	HomePage home = new HomePage();
	
	@Given("que acesso o site dos correios")
	public void queAcessoOSiteDosCorreios() {
		
		IniciarTeste.abrirNavegador("https://www.correios.com.br/", "Chrome");
	   
	}
	@When("envio dado para busca")
	public void envioDadoParaBusca() {
		
		metodo.digitar(home.campoBuscarCEP, "2ª Travessa Santo Antonio São Caetano Itabuna/BA");
		metodo.submit(home.campoBuscarCEP);
	}
	@Then("valido o retorno da consulta")
	public void validoORetornoDaConsulta() {
	    
		home.validarCEP("45607-148", "CT01_Address_research_test");
		IniciarTeste.fecharNavegador();
		
	}



	
	
	

}
