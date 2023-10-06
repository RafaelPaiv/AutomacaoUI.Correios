package correios.automacao.git.metodos;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import correios.automacao.git.drivers.DriversConexao;

public class Metodos extends DriversConexao {

	
	/**
	 * Metodo para digitar um texto em um elemento Web(elemento web, texto a ser digitado)
	 */
	public void digitar(By elemento, String texto) {

		try {
			
		driver.findElement(elemento).sendKeys(texto);

		} catch (Exception e) {
			System.out.println("Erro ao digitar " + texto + " no elemento web " + elemento);
		}
	}

	/**
	 * Metodo para clicar em um elemento Web(elemento web)
	 */
	public void clicar(By elemento) {

		try {
			
		driver.findElement(elemento).click();

		} catch (Exception e) {
			System.out.println("Erro ao clicar no elemento " + elemento);
		}
	}

	/**
	 * Metodo para validar texto em uma pagina web(elemento web a ser comparado, texto esperado)
	 */
	public void validarTexto(By elemento, String textoEsperado) {

		try {
			
		String textoCapturado = driver.findElement(elemento).getText();
		assertEquals(textoEsperado, textoCapturado);
		
		} catch (Exception e) {
			System.out.println("Erro ao validar texto do elemento " + elemento);
		}

	}

	/**
	 * Metodo para validar title em uma pagina web(title esperado)
	 */
	public void validarTitle(String titleEsperado) {

		try {
			
		String titleCapturado = driver.getTitle();
		assertEquals(titleEsperado, titleCapturado);
		} catch (Exception e) {
			System.out.println("Erro ao validar title");
		}

	}

	/**
	 * Metodo para enviar dados inseridos em um elemento web(elemento web)
	 */
	public void submit(By elemento) {

		try {
			
		driver.findElement(elemento).submit();
		} catch (Exception e) {
			System.out.println("Erro ao enviar dados pelo elemento " + elemento);
		}

	}

	/**
	 * Metodo de print de tela para geraçao de evidencias em paginas web(nome da evidencia)
	 */
	public void printScreen(String nomeEvidencia) {

		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		File srcDest = new File("./evidencias/" + nomeEvidencia + ".png");
		try {
			FileUtils.copyFile(scrFile, srcDest);
		} catch (IOException e) {
			System.out.println("Erro na criação da evidência");
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
}
