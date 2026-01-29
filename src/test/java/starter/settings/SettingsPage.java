package starter.settings;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;
import starter.Locators.Locators;
import starter.login.LoginPage;

public class SettingsPage {
    private SettingsPage.SettingsPageBy by = new SettingsPage.SettingsPageBy();
    private class SettingsPageBy {
        By header = By.xpath("test");
    }

    public SettingsPage() {}

    public static Performable clickLogoutButton() {
        return Task.where("{0} clicks logout button",
                Click.on(Locators.LOGOUT_BUTTON));
    }
}
