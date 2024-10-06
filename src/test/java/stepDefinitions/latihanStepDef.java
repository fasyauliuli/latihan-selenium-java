package stepDefinitions;

import org.example.Config;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.assertThat;

public class latihanStepDef {
    WebDriver driver;
    Config config = new Config();

    @Given("the user is on the Google search page")
    public void the_user_is_on_the_google_search_page() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.get(config.getUrl());
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String query) {
        driver.findElement(By.xpath(config.getFieldSearch())).sendKeys(query);
        driver.findElement(By.xpath(config.getFieldSearch())).submit();
    }

    @Then("the result page should show relevant results")
    public void the_result_page_should_show_relevant_results() {
        String title = driver.getTitle();
        assertThat(title).containsIgnoringCase("Cucumber BDD");
        driver.quit();
    }
}
