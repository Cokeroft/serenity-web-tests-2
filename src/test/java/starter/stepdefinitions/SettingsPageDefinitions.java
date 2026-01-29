package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import starter.login.LoginPage;
import starter.settings.SettingsPage;
import starter.utilities.PropertyManager;

public class SettingsPageDefinitions {
    private static String SuperAdminPassword = PropertyManager.getInstance().getSuperAdminPassword();
    private static String SuperAdminUsername = PropertyManager.getInstance().getSuperAdminUsername();
    private static String env = PropertyManager.getInstance().getTargetEnv();

    @Then("{actor} clicks the logout button")
    public void clickLogout(Actor actor) {
        actor.attemptsTo(SettingsPage.clickLogoutButton());
    }
}
