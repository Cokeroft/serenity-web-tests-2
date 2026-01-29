package starter.tenant;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import org.openqa.selenium.By;
import starter.Locators.Locators;
import starter.homePage.HomePage;
import starter.login.LoginPage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TenantPage {
    private TenantPage.TenantPageBy by = new TenantPage.TenantPageBy();
    private class TenantPageBy {
        By      header = By.xpath("test");
    }

    public TenantPage() {}

    public static Performable enter_info() {
        // Placeholder, make this something else, but for now this is fine
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String formattedNow = now.format(formatter);
        //return  Task.where("{0} fills out the new tenant information",
                /**Enter.theValue(formattedNow).into(Locators.TENANT_NAME),
                Enter.theValue(formattedNow).into(Locators.DISPLAY_NAME),
                Enter.theValue(formattedNow).into(Locators.DESCRIPTION),
                Enter.theValue("cokeroft@boltlabs.io").into(Locators.TENANT_ADMIN_EMAIL),
                Enter.theValue(formattedNow).into(Locators.DEFAULT_ZONE_NAME),
                */
                //Enter.theValue(formattedNow).into(Locators.DEFAULT_ZONE_DESCRIPTION)
        return null;
    }

    public static Performable click_key_servers(Integer count) {
        /*for (int i = 0; i < count; i++) {
            Click.on("//*[@id=\"root\"]/div/main/div[2]/div[2]/form/div[1]/div[8]/div/div[2]/div/div/div[1]");
        }*/
        // return Task.where("{0} clicks {int} key servers",

        return Task.where("{0} clicks {int} key servers",
                Click.on(Locators.SIGNIN_BUTTON));
    }

    public static Performable click_submit() {
        return Task.where("{0} clicks submit button",
                Click.on(Locators.SUBMIT_BUTTON));
    }

    public static Performable click_cancel() {
        return Task.where("{0} clicks cancel button",
                Click.on(Locators.SIGNIN_BUTTON),
                Click.on(Locators.SIGNIN_BUTTON));
    }
}
