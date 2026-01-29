package starter.login;

import jdk.internal.perf.Perf;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.locators.WaitForWebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import starter.Locators.Locators;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class LoginPage {
    private LoginPageBy by = new LoginPageBy();

    private class LoginPageBy {
        By header = By.xpath("test");
    }

    public LoginPage() {
    }

    public LoginPage waitForHeader() {
        System.out.println("test");

        return this;
    }

    public static Performable enterUsername(String username) {
        return Task.where("{0} enters username",
                Enter.theValue(username)
                        .into(Locators.USERNAME_FIELD)
        );
    }

    public static Performable enter_custom_username(String username) {
        return Task.where("{0} enters {string} username",
                Enter.theValue(username)
                        .into(Locators.EMAIL_FIELD)
        );
    }

    public static Performable enterEmail(String email) {
        return Task.where("{0} enters email",
                Enter.theValue(email)
                        .into(Locators.EMAIL_FIELD)
        );
    }

    public static Performable enterCustomEmail(String email) {
        return Task.where("{0} enters {string} email",
                Enter.theValue(email)
                        .into(Locators.EMAIL_FIELD)
        );
    }

    public static Performable enterPassword(String password) {
        return Task.where("{0} enters password",
                Enter.theValue(password)
                        .into(Locators.PASSWORD_FIELD)
        );
    }

    public static Performable enter_custom_password(String password) {
        return Task.where("{0} enters {string} password",
                Enter.theValue(password)
                        .into(Locators.PASSWORD_FIELD)
        );
    }

    public static Performable clickSignin() {
        return Task.where("{0} waits for and clicks the Sign In button",
                WaitUntil.the(Locators.SIGNIN_BUTTON, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(Locators.SIGNIN_BUTTON)
        );
    }

    public static Performable clickLogin() {
        return Task.where("{0} clicks the login button",
                WaitUntil.the(Locators.LOGIN_BUTTON, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(Locators.LOGIN_BUTTON)
        );
    }

    public static Performable clickGotIt() {
        return Task.where("{0} clicks the location sharing button prompt",
                WaitUntil.the(Locators.GOTIT_BUTTON, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(Locators.GOTIT_BUTTON)
            );
    }

    public static Performable exitModal() {
        return Task.where("{0} exits the onboarding modal",
                WaitUntil.the(Locators.ONBOARDING_MODAL, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(Locators.ONBOARDING_MODAL)
        );
    }

    public static Performable clickSigninPageButton() {
        return Task.where("{0} clicks signin button from sign in page",
                Click.on(Locators.SIGNIN_BUTTON_LOGIN),
                WaitUntil.the(Locators.HOME_PAGE, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }

    public static Performable clickSigninPageButtonInvalid() {
        return Task.where("{0} clicks signin button from sign in page with invalid creds",
                Click.on(Locators.SIGNIN_BUTTON_LOGIN),
                WaitUntil.the(Locators.ERROR_MESSAGE, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }


    public static Performable clickCreateAccount() {
        return Task.where("{0} clicks create account button",
                Click.on(Locators.REGISTER_BUTTON));
    }
}
