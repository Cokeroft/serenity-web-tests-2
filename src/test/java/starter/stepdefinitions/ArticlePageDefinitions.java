package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import starter.article.ArticlePage;
import starter.homePage.HomePage;

public class ArticlePageDefinitions {
    @When("{actor} creates a comment that states {string}")
    public void createComment(Actor actor, String comment) {
        actor.attemptsTo(ArticlePage.createComment(comment));
    }

    @Then("{actor} can see a comment that states {string}")
    public void readComment(Actor actor, String comment) {
        actor.attemptsTo(ArticlePage.createComment(comment));
    }

    @Then("{actor} deletes the top comment")
    public void deleteTopComment(Actor actor) {
        // This is called top comment, but it just deletes all, would be a tool for later
        actor.attemptsTo(ArticlePage.deleteTopComment());
    }

    @When("{actor} favorites the article")
    public void favoriteArticle(Actor actor) {
        actor.attemptsTo(ArticlePage.takeNoteOfFavCount());
        actor.attemptsTo(ArticlePage.favoriteArticle());
    }

    @Then("{actor} sees the favorite counter has changed")
    public void favoriteCounterCheck(Actor actor) {
        String oldCount = actor.recall("favoriteCount");
        System.out.println(oldCount);
        actor.attemptsTo(ArticlePage.compareCounters(oldCount));
    }

    @Then("{actor} clicks on the home button")
    public void clickHomeButton(Actor actor) {
        actor.attemptsTo(ArticlePage.clickHomeButton());
    }
}
