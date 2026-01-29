package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.homePage.HomePage;
import starter.login.LoginPage;
import starter.Locators.Locators;
import starter.navigation.NavigateTo;
import starter.utilities.PropertyManager;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;

public class LoginStepDefinitions {
    private static String SuperAdminPassword = PropertyManager.getInstance().getSuperAdminPassword();
    private static String SuperAdminUsername = PropertyManager.getInstance().getSuperAdminUsername();
    private static String env = PropertyManager.getInstance().getTargetEnv();

    @Given("{actor} navigates to the Bolt Login page")
    public void researchingThings(Actor actor) {
        actor.wasAbleTo(NavigateTo.theLoginPage());
    }

    @Given("{actor} navigates to the test application landing page")
    public void testLandingPage(Actor actor) {
        actor.wasAbleTo(NavigateTo.testLandingPage());
        /**actor.attemptsTo(
                Ensure.that(Locators.SIGNIN_BUTTON).text().isEqualTo("Sign in")
        );*/
    }

    @When("{actor} goes to a test wager")
    public void testWager(Actor actor) {
        actor.wasAbleTo(NavigateTo.toTestWagerPage());
    }

    @Given("{actor} navigates to the profile page of {string}")
    public void profilePage(Actor actor, String user_profile) {
        actor.wasAbleTo(NavigateTo.testProfilePage(user_profile));
        //actor.attemptsTo(
         //       Ensure.that(Locators.SIGNIN_BUTTON).text().isEqualTo("Sign in")
        //);
    }

    @Given("{actor} navigates to the Bolt System Admin Login page")
    public void systemAdminLogin(Actor actor) {
        actor.wasAbleTo(NavigateTo.theSystemAdminLoginPage(env));
    }

    @When("{actor} enters his login information")
    public void login(Actor actor) {
        actor.attemptsTo(LoginPage.enterUsername("service_provider"));
        actor.attemptsTo(LoginPage.enterPassword("password"));
    }

    @Then("{actor} enters {string}, {string} and {string} into the corresponding fields")
    public void createUserEntry(Actor actor, String username, String email, String password) {
        actor.attemptsTo(LoginPage.enterUsername(username));
        actor.attemptsTo(LoginPage.enterEmail(email));
        actor.attemptsTo(LoginPage.enterPassword(password));
    }

    @When("{actor} enters {string} email and {string} password into the corresponding fields")
    public void enterLoginInfo(Actor actor, String email, String password) {
        actor.attemptsTo(LoginPage.enterEmail(email));
        actor.attemptsTo(LoginPage.enterPassword(password));
        actor.attemptsTo(LoginPage.clickLogin());
    }

    @When("{actor} clicks the location sharing button")
    public void clickGotItButton(Actor actor) {
        actor.attemptsTo(LoginPage.clickGotIt());
    }

    @Then("{actor} is shown an error message that states {string}")
    public void errorMessage(Actor actor, String error) {
        actor.attemptsTo(
                WaitUntil.the(Locators.ERROR_MESSAGE, WebElementStateMatchers.containsText(error))
                        .forNoMoreThan(15).seconds(),
                Ensure.that(Locators.ERROR_MESSAGE).text().isEqualTo(error)
        );
    }

    @When("{actor} enters {string} user and {string} pw")
    public void loginCustom(Actor actor, String username, String password) {
        actor.attemptsTo(LoginPage.enterUsername(username));
        actor.attemptsTo(LoginPage.enterPassword(password));
    }

    @When("{actor} enters his system admin login information")
    public void loginSystemAdmin(Actor actor) {
        actor.attemptsTo(LoginPage.enterUsername(SuperAdminUsername));
        actor.attemptsTo(LoginPage.enterPassword(SuperAdminPassword));
    }

    @Then("{actor} clicks the login button")
    public void click_login(Actor actor) {
        actor.attemptsTo(LoginPage.clickSignin());
    }

    @When("{actor} clicks the sign in button")
    public void clickSignin(Actor actor) {
        actor.attemptsTo(LoginPage.clickSignin());
    }

    @When("{actor} exits the onboarding modal")
    public void exitModal(Actor actor) {
        actor.attemptsTo(LoginPage.exitModal());
    }

    @When("{actor} clicks the first available moneyline")
    public void clickMoneyLine(Actor actor) {
        actor.attemptsTo(HomePage.clickFirstMoneyline());
    }

    @When("{actor} enters a small stake")
    public void enterSmallStake(Actor actor) {
        actor.attemptsTo(HomePage.enterSmallStake());
    }

    @When("{actor} clicks place play")
    public void clickPlacePlay(Actor actor) {
        actor.attemptsTo(HomePage.clickPlacePlay());
    }

    @When("{actor} clicks confirm play")
    public void clickConfirmPlay(Actor actor) {
        actor.attemptsTo(HomePage.clickConfirmPlay());
    }

    @Then("{actor} has their wager matched successfully")
    public void successfulMatch(Actor actor) {
        actor.attemptsTo(HomePage.successfulMatch());
    }

    @When("{actor} clicks the sign in button from the sign in page")
    public void clickSigninPage(Actor actor) {
        actor.attemptsTo(LoginPage.clickSigninPageButton());
    }

    @When("{actor} clicks the sign in button from the sign in page with invalid creds")
    public void clickSigninPageInvalid(Actor actor) {
        actor.attemptsTo(LoginPage.clickSigninPageButtonInvalid());
    }

    @When("{actor} clicks the sign up button")
    public void clickSignup(Actor actor) {
        actor.attemptsTo(LoginPage.clickCreateAccount());
    }

    @Then("{actor} waits for side nav to appear")
    public void wait_side_nav(Actor actor) {
        actor.attemptsTo(Wait.until(WebElementQuestion.the("[id=root]"),
                WebElementStateMatchers.isEnabled()).forNoMoreThan(5).seconds());
    }

    @Then("{actor} waits for the help icon to appear")
    public void wait_help_icon(Actor actor) {
        actor.attemptsTo(Wait.until(WebElementQuestion.the("[data-testid=HelpIcon"),
                WebElementStateMatchers.isEnabled()).forNoMoreThan(5).seconds());
    }
}

