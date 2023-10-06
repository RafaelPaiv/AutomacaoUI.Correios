package correios.automacao.git.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/features",
glue = "correios.automacao.git.steps",
tags = "@Regressivos",
dryRun = false,
monochrome = true,
snippets = SnippetType.CAMELCASE,
plugin = {"pretty","html:target/cucumber-report.html"}
		
		)

public class Executa {

}
