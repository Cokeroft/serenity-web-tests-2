package starter.homePage;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import starter.Locators.Locators;
import starter.login.LoginPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class HomePage {
    private HomePage.HomePageBy by = new HomePage.HomePageBy();
    private class HomePageBy {
        By      header = By.xpath("test");
    }

    public HomePage() {}

    public static Performable click_tenants() {
        return null;
    }
        /**return Task.where("{0} clicks on the Tenants side nav",
                Click.on(Locators.TENANTS_SIDE_NAV));
    }*/

    public static Performable clickFirstMoneyline() {
        return Task.where("{0} clicks first available moneyline bet shown",
                WaitUntil.the(Locators.FIRST_MONEYLINE, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(Locators.FIRST_MONEYLINE)
        );
    }

    public static Performable enterSmallStake() {
        return Task.where("{0} clicks first available moneyline bet shown",
                WaitUntil.the(Locators.STAKE_INPUT, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(10).seconds(),
                Enter.theValue("1")
                        .into(Locators.STAKE_INPUT)
        );
    }

    public static Performable clickPlacePlay() {
        return Task.where("{0} clicks place play button",
                WaitUntil.the(Locators.PLACE_PLAY, WebElementStateMatchers.isEnabled())
                        .forNoMoreThan(10).seconds(),
                Click.on(Locators.PLACE_PLAY)
        );
    }

    public static Performable clickConfirmPlay() {
        return Task.where("{0} clicks place confirm button",
                WaitUntil.the(Locators.CONFIRM_PLAY, WebElementStateMatchers.isEnabled())
                        .forNoMoreThan(10).seconds(),
                Click.on(Locators.CONFIRM_PLAY)
        );
    }

    public static Performable successfulMatch() {
        return Task.where("{0} wager is successfully matched",
                WaitUntil.the(Locators.MATCHED, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Ensure.that(Locators.MATCHED).text().isEqualTo("Matched"),
                Ensure.that(Locators.PLAYSLIP_HEADER).text().isEqualTo("Play Successful")
                );
    }

    public static Performable clickCreateAccount() {
        return Task.where("{0} clicks create account button",
                Click.on(Locators.REGISTER_BUTTON));
    }

    public static Performable clickSettingsButton() {
        return Task.where("{0} clicks settings button",
                WaitUntil.the(Locators.SETTINGS_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(Locators.SETTINGS_BUTTON));
    }

    public static Performable clickMyFeedButton() {
        return Task.where("{0} clicks my feed button",
                WaitUntil.the(Locators.MY_FEED, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(Locators.MY_FEED));
    }

    public static Performable clickFirstArticle() {
        return Task.where("{0} clicks the first article button",
                WaitUntil.the(Locators.ARTICLE_INFO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(Locators.ARTICLE_INFO),
                WaitUntil.the(Locators.FAVORITE_ARTICLE_COUNTER, isVisible()).forNoMoreThan(10).seconds()
                );
    }

    public static Performable clickCreateArticle() {
        return Task.where("{0} clicks create new article button",
            Click.on(Locators.CREATE_ARTICLE_BUTTON),
            WaitUntil.the(Locators.EDITOR_PAGE, containsText("Article editor"))
                    .forNoMoreThan(10).seconds(),

            Ensure.that(Locators.EDITOR_PAGE).text().contains("Article editor"));
    }

    public static Performable clickMyProfile() {
        return Task.where("{0} clicks on my profile button",
                Click.on(Locators.MY_PROFILE),
                WaitUntil.the(Locators.PROFILE_PAGE, isVisible()));
    }
}
