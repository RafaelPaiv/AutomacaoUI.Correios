package correios.automacao.git.pages;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;

import correios.automacao.git.metodos.Metodos;

public class HomePage extends Metodos {

	// Elementos

	public By campoBuscarCEP = By.xpath("//input[@id='relaxation']");
	public By logradouro = By.xpath("//td[@data-th='Logradouro/Nome']");
	public By bairro = By.xpath("//td[@data-th='Bairro/Distrito']");
	public By uf = By.xpath("//td[@data-th='Localidade/UF']");
	public By cep = By.xpath("//td[@data-th='CEP']");

	// Metodos
	
	// Metodo para validar title da página de pesquisa de cep (title esperado)

	public void validarTitleCEPPage(String titleEsperado) {

		try {
			
		String janelaPrincipal = driver.getWindowHandle();
		Set<String> janelasAbertas = driver.getWindowHandles();

		for (String janela : janelasAbertas) {

			if (!janela.equals(janelaPrincipal)) {

				driver.switchTo().window(janela);

				String titleCapturado = driver.getTitle();
				assertEquals(titleEsperado, titleCapturado);

			}

		}
		
		driver.close();
		
		} catch (Exception e) {
			System.out.println("erro ao validar title");
		}

	}

	// Metodo para validar cep da página de pesquisa de cep (cep esperado)
	public void validarCEP(String cepEsperado, String nomeEvidencia) {

		try {
			
			String janelaPrincipal = driver.getWindowHandle();
			Set<String> janelasAbertas = driver.getWindowHandles();

			for (String janela : janelasAbertas) {

				if (!janela.equals(janelaPrincipal)) {

					driver.switchTo().window(janela);

					String cepSite = driver.findElement(cep).getText();
					assertEquals(cepEsperado, cepSite);

				}

			}
	
		printScreen(nomeEvidencia);
		} catch (Exception e) {
			System.out.println("erro ao validar cep");
		}
		
		driver.close();
		
		

	}

}
