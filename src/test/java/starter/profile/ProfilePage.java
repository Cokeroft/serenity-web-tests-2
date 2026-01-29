package starter.profile;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import starter.Locators.Locators;
import starter.editor.EditorPage;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProfilePage {
    private ProfilePage.ProfilePageBy by = new ProfilePage.ProfilePageBy();
    private class ProfilePageBy {
        By header = By.xpath("test");
    }

    public ProfilePage() {}

    public static Performable verifyPage() {
        // TBD
        return null;
    }

    public static Performable checkArticles(String titles) {
        return Task.where("{0} confirms the correct article appears",
                WaitUntil.the(Locators.ARTICLE_PREVIEW, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that("At least one article preview contains the title",
                        (Question<Boolean>) Question.about("article previews contain title").answeredBy(actor -> {
                            List<String> texts = (List<String>) actor.asksFor(Text.ofEach(Locators.ARTICLE_PREVIEW));
                            return texts.stream().anyMatch(t -> t.contains(titles));
                        })
                ).isTrue()
        );
    }

    public static Performable followProfile() {
        // TODO - I want to check the user profile, make sure it's correct someday
        return Task.where("{0} clicks the follow button",
                WaitUntil.the(Locators.PROFILE_PAGE, isVisible()).forNoMoreThan(10).seconds(),
                Check.whether(Visibility.of(Locators.FOLLOW_BUTTON_HARD))
                        .andIfSo(Click.on(Locators.FOLLOW_BUTTON_HARD))
        );
    }
}
