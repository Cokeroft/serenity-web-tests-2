package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import org.xml.sax.Locator;
import starter.homePage.HomePage;
import starter.login.LoginPage;
import starter.Locators.Locators;
import starter.navigation.NavigateTo;
import starter.tenant.TenantPage;
import starter.utilities.PropertyManager;

import java.sql.DriverManager;

public class HomePageStepDefinitions {
    @Then("{actor} clicks on the Tenants side nav")
    public void clickTenants(Actor actor) {
        actor.attemptsTo(HomePage.click_tenants());
        //actor.attemptsTo(
               // Ensure.that(Locators.FIRST_TENANT).isDisplayed());
    }

    @Then("{actor} clicks on Add New Tenant")
    public void createTenant(Actor actor) {
        //actor.attemptsTo(HomePage.create_tenant());
        //actor.attemptsTo(
          //      Ensure.that(Locators.TENANT_NAME).isDisplayed());
    }

    @When("{actor} clicks the create account button")
    public void clickCreateAccount(Actor actor) {
        actor.attemptsTo(HomePage.clickCreateAccount());
    }

    @Then("{actor} clicks the settings button")
    public void clickSettingsButton(Actor actor) {
        actor.attemptsTo(HomePage.clickSettingsButton());
    }

    @Then("{actor} clicks the my feed button")
    public void clickMyFeedButton(Actor actor) {
        actor.attemptsTo(HomePage.clickMyFeedButton());
    }

    @When("{actor} clicks on the first article")
    public void clickFirstArticle(Actor actor) {
        actor.attemptsTo(HomePage.clickFirstArticle());
    }

    @When("{actor} clicks the new article button")
    public void clickCreateArticleButton(Actor actor) {
        actor.attemptsTo(HomePage.clickCreateArticle());
    }

    @Then("{actor} clicks on the my profile button")
    public void clickMyProfile(Actor actor) {
        actor.attemptsTo(HomePage.clickMyProfile());
    }

    @Then("{actor} fills out the new tenant information")
    public void enterTenantInformation(Actor actor) {
        actor.attemptsTo(TenantPage.enter_info());
    }

    @Then("{actor} clicks {int} key servers")
    public void clickKeyServers(Actor actor, Integer key_servers_count) {
        actor.attemptsTo(TenantPage.click_key_servers(key_servers_count));
    }

    @Then("{actor} clicks submit button")
    public void clickSubmit(Actor actor) {
        actor.attemptsTo(TenantPage.click_submit());
    }

    @Then("{actor} clicks cancel button")
    public void clickCancel(Actor actor) {
        actor.attemptsTo(TenantPage.click_cancel());
    }

    /*@Then("{actor} clicks the logout button")
    public void click_logout(Actor actor) {
        actor.attemptsTo(LoginPage.click_logout());
    }*/
}
