package starter.editor;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import starter.Locators.Locators;
import starter.homePage.HomePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;

public class EditorPage {
    private EditorPage.EditorPageBy by = new EditorPage.EditorPageBy();
    private class EditorPageBy {
        By header = By.xpath("test");
    }

    public EditorPage() {}

    public static Performable verifyPage() {
        // TBD
        return null;
    }

    public static Performable createArticle(String title) {
        return Task.where("{0} creates a new article titled {string}",
                Enter.theValue(title)
                        .into(Locators.ARTICLE_TITLE),
                Enter.theValue("description")
                        .into(Locators.ARTICLE_DESC),
                Enter.theValue("body")
                        .into(Locators.ARTICLE_BODY),
                Click.on(Locators.PUBLISH_ARTICLE)
        );
    }
}
