package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Browser;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.Locators.Locators;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateTo {

    public static Performable theLoginPage() {
        return Task.where("{0} opens the Bolt Login page",
                Open.browserOn().the(BoltLoginPage.class));
    }

    public static Performable toTestWagerPage() {
        return Task.where("{0} goes to test wager page",
                Open.url(String.format("https://ss-sandbox.betprophet.co/basketball/nba/milwaukee-bucks-vs-chicago-bulls-1500003900?currency=cash")),
                WaitUntil.the(Locators.REQUEST_SELECTION, isVisible()).forNoMoreThan(10).seconds());
    }

    public static Performable testLandingPage() {
        return Task.where("{0} opens the test application landing page",
                Open.browserOn().the(BoltLoginPage.class)
        );
    }

    public static Performable testProfilePage(String profile) {
        return Task.where("{0} navigates to the profile page of a specific user",
                Open.url(String.format("http://localhost:4200/#/profile/%s", profile)),
                WaitUntil.the(Locators.PROFILE_PAGE, isVisible()).forNoMoreThan(10).seconds());
    }

    public static Performable theSystemAdminLoginPage(String env) {
        return Task.where("{0} opens the Bolt System Admin Login page",
                Open.url(String.format("https://maestro-frontend.%s.boltlabs.io", env)));
    }
}
