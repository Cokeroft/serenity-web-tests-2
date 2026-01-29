package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.Locators.Locators;
import starter.editor.EditorPage;
import starter.profile.ProfilePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;

public class MyProfileDefinitions {
    @When("{actor} is able to see the article titled {string}")
    public void checkArticles(Actor actor, String title) {
        actor.attemptsTo(ProfilePage.checkArticles(title));
    }

    @Then("{actor} clicks on the follow button")
    public void followProfile(Actor actor) {
        actor.attemptsTo(ProfilePage.followProfile());
    }
}
