package correios.automacao.git.config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import correios.automacao.git.drivers.DriversConexao;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IniciarTeste extends DriversConexao {

	/**
	 * Metodo para abriir o navegador web, preenceher uma das opcoes de navegadores
	 * disponiveis: Google Chrome (Chrome) e Microsoft Edge (Edge)
	 */

	public static void abrirNavegador(String site, String browser) {

		try {

			switch (browser) {

			case "Chrome":

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(site);

				break;

			case "Edge":

				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.get("site");

				break;

			case "Fire":

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get("site");

				break;

			default:

				System.out.println("Opção de navegador " + browser
						+ " inválida. Inserir uma das opções disponiveis: Chrome, Edge ou Fire");

				break;

			}

		} catch (Exception e) {

			System.out.println("Opção de navegador " + browser
					+ " inválida. Inserir uma das opções disponiveis: Chrome, Edge ou Fire");
		}

	}

	/**
	 * Metodo para fechar o navegador Web
	 */
	public static void fecharNavegador() {

		try {

			driver.quit();

		} catch (Exception e) {
			System.out.println("erro ao fechar o navegador");
		}

	}

}
