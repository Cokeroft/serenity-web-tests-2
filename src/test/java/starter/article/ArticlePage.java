package starter.article;

import jdk.internal.perf.Perf;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import starter.Locators.Locators;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class ArticlePage {
    private ArticlePage.ArticlePageBy by = new ArticlePage.ArticlePageBy();
    private class ArticlePageBy {
        By header = By.xpath("test");
    }

    private String counter = "";

    public ArticlePage() {}

    public static Performable createComment(String comment) {
        return Task.where("{0} creates a new article titled {string}",
                WaitUntil.the(Locators.COMMENT_BODY, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(Locators.COMMENT_BODY),
                Enter.theValue(comment)
                        .into(Locators.COMMENT_BODY),
                Click.on(Locators.POST_COMMENT)
        );
    }

    public static Performable readComment(String comment) {
        return Task.where("{0} creates a new article titled {string}",
                WaitUntil.the(Locators.COMMENT_TEXT, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Ensure.that(Locators.COMMENT_TEXT).text().contains(comment)
        );
    }

    public static Performable deleteTopComment() {
        return Task.where("{0} deletes top comment",
                WaitUntil.the(Locators.TOP_DELETE_ACTION, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(10).seconds(),
                clickAllByClass("ion-trash-a")
                /**MoveMouse.to(Locators.DELETE_COMMENT),
                Click.on(Locators.COMMENT_FOOTER),
                WaitUntil.the(Locators.TOP_DELETE_ACTION, WebElementStateMatchers.isNotPresent())
                        .forNoMoreThan(10).seconds()*/
        );
    }

    public static Performable clickAllByClass(String className) {
        return Task.where("{0} clicks all elements with class '" + className + "'",
                actor -> {
                    // ✅ Get WebDriver from the actor’s ability
                    WebDriver driver = BrowseTheWeb.as(actor).getDriver();

                    // ✅ Cast to JS executor and run your script
                    ((JavascriptExecutor) driver).executeScript(
                            "Array.from(document.getElementsByClassName(arguments[0]))" +
                                    ".forEach(el => el.click());",
                            className
                    );
                }
        );
    }

    public static Performable favoriteArticle() {
        return Task.where("{0} favorites article",
                WaitUntil.the(Locators.FAVORITE_ARTICLE, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(Locators.FAVORITE_ARTICLE)
                );
    }

    public static Performable compareCounters(String oldCount) {
        return Task.where("{0} compares old favorite count",
                WaitUntil.the(Locators.FAVORITE_ARTICLE_COUNTER, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Ensure.that(Text.of(Locators.FAVORITE_ARTICLE_COUNTER))
                        .isNotEqualTo(oldCount)
                );
    }

    public static Performable clickHomeButton() {
        return Task.where("{0} click home button",
                WaitUntil.the(Locators.HOME_BUTTON, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(Locators.HOME_BUTTON),
                WaitUntil.the(Locators.HOME_PAGE, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(10).seconds()
                );
    }

    public static Performable takeNoteOfFavCount() {
        return Task.where("{0} takes note of fav count",
                WaitUntil.the(Locators.FAVORITE_ARTICLE_COUNTER, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Task.where("{0} remembers the current favorite count", actor -> {
                    String favCount = Text.of(Locators.FAVORITE_ARTICLE_COUNTER).answeredBy(actor);
                    actor.remember("favoriteCount", favCount);
                })
        );
    }
}
