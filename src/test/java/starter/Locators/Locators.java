package starter.Locators;

import net.serenitybdd.screenplay.targets.Target;

public class Locators {
    // ProphetX Locators
    public static Target SIGNIN_BUTTON = Target.the("signin button").locatedBy("//button[normalize-space()=\"Sign In\"]");
    public static Target ONBOARDING_MODAL = Target.the("onboarding modal").locatedBy(".modal.onboarding-modal");
    public static Target SIDEBAR = Target.the("sidebar").locatedBy("[class^=sidebar]");
    public static Target EMAIL_FIELD = Target.the("email text field").locatedBy("[id=email]");
    public static Target PASSWORD_FIELD = Target.the("password field").locatedBy("[id=password]");
    public static Target LOGIN_BUTTON = Target.the("password field").locatedBy("[data-cy=loginButton]");
    public static Target GOTIT_BUTTON = Target.the("got it button").locatedBy("//button[contains(@class,'gc-html5-ui-modal-button') and normalize-space(.)='Got it']");
    //public static Target FIRST_MONEYLINE = Target.the("first available moneyline").locatedBy("//button[.//em[normalize-space()='Live']]");
    public static Target REQUEST_SELECTION = Target.the("request selection").locatedBy("[data-cy=requestSelection]");
    public static Target FIRST_MONEYLINE = Target.the("first available moneyline").locatedBy("//button[@data-cy='requestSelection' and .//span[@data-market='moneyline']]");
    public static Target STAKE_INPUT = Target.the("stake input field").locatedBy(".stake-field input.currency-input__field");
    public static Target PLACE_PLAY = Target.the("place play button").locatedBy("[class=playslip-confirm__button]");
    public static Target CONFIRM_PLAY = Target.the("place play button").locatedBy("//button[contains(@class,'playslip-confirm__button--confirm') and normalize-space(.)='Confirm Play']");
    public static Target MATCHED = Target.the("matched text").locatedBy(".market-order-matched-wager__status-tag--matched");
    public static Target PLAYSLIP_HEADER = Target.the("playslip header").locatedBy(".playslip-header__title");

    // Login / Home Page Locators
    public static Target HOME_PAGE = Target.the("home page").locatedBy("[class=home-page]");
    public static Target HOME_BUTTON = Target.the("home button").locatedBy("[class=nav-item]");
    public static Target USERNAME_FIELD = Target.the("username field").locatedBy("[formcontrolname=username]");
    public static Target SUBMIT_BUTTON = Target.the("submit button").locatedBy("[type=submit]");
    public static Target REGISTER_BUTTON = Target.the("register button").locatedBy("[ng-reflect-router-link=\"/register\"]");
    public static Target SIGNIN_BUTTON_LOGIN = Target.the("actual log in button").locatedBy("//button[normalize-space(.)='Sign in']");
    public static Target SETTINGS_BUTTON = Target.the("settings button").locatedBy("[ng-reflect-router-link=\"/settings\"]");
    public static Target CREATE_ARTICLE_BUTTON = Target.the("create article button").locatedBy("[ng-reflect-router-link=\"/editor\"]");
    public static Target LOGOUT_BUTTON = Target.the("logout button").locatedBy("//button[normalize-space(.)='Or click here to logout.']");
    public static Target ERROR_MESSAGE = Target.the("error messages").locatedBy("(//*[@class='error-messages'])[1]");
    public static Target EDITOR_PAGE = Target.the("editor page").locatedBy("[class=editor-page]");
    public static Target MY_PROFILE = Target.the("my profile").locatedBy("[ng-reflect-router-link=\"/my-profile\"]");
    public static Target MY_FEED = Target.the("my feed button").locatedBy("//li[contains(@class, 'nav-item')]//a[normalize-space()='My Feed']");
    public static Target ARTICLE_INFO = Target.the("article info").locatedBy("[class=preview-link]");

    // Article Editor Page
    public static Target ARTICLE_TITLE = Target.the("article title").locatedBy("[formcontrolname=title]");
    public static Target ARTICLE_DESC = Target.the("article description").locatedBy("[formcontrolname=description]");
    public static Target ARTICLE_BODY = Target.the("article body").locatedBy("[formcontrolname=body]");
    public static Target ARTICLE_TAGS = Target.the("article tags").locatedBy("[formcontrolname=tagInput]");
    public static Target PUBLISH_ARTICLE = Target.the("publish article").locatedBy("//button[normalize-space(.)='Publish Article']");

    // Profile Page... Page
    public static Target PROFILE_PAGE = Target.the("profile page").locatedBy("[class=profile-page]");
    public static Target ARTICLE_PREVIEW = Target.the("article preview").locatedBy("[class=article-preview]");
    public static Target CONTAINER = Target.the("container").locatedBy("[class=container]");
    public static Target FOLLOW_BUTTON_HARD = Target.the("for real").locatedBy("[class=\"btn btn-sm btn-outline-secondary action-btn\"]");
    public static Target UNFOLLOW_BUTTON_HARD = Target.the("unfollow").locatedBy("[class=\"btn btn-sm btn-secondary action-btn\"]");
    public static Target FOLLOW_BUTTON = Target.the("follow button").locatedBy("[class=ion-plus-round]");

    // Article View Page
    public static Target COMMENT_BODY = Target.the("comment body").locatedBy("//div[contains(@class,'card-block')]//textarea[starts-with(@placeholder,'Write a comment')]");
    // Note - I get it, type=button is lazy. But it's the only thing on the page with that ID and it is easier!
    public static Target POST_COMMENT = Target.the("post comment button").locatedBy("[type=button]");
    public static Target ARTICLE_TEXT = Target.the("article body").locatedBy("[ng-reflect-data=body]");
    public static Target DELETE_COMMENT = Target.the("delete comment button").locatedBy("(//span[contains(@class,'mod-options')]/i[contains(@class,'ion-trash-a')])[1]");
    public static Target TOP_DELETE_ACTION = Target.the("top comment delete action").locatedBy("(//span[contains(@class,'mod-options')])[1]");
    public static Target COMMENT_CARD = Target.the("comment card").locatedBy("[class=card]");
    public static Target COMMENT_FOOTER = Target.the("comment footer").locatedBy("[class=card-footer]");

    public static Target COMMENT_TEXT = Target.the("comments").locatedBy("[class=card-text]");
    public static Target FAVORITE_ARTICLE = Target.the("favorite article").locatedBy("[class=ion-heart]");
    public static Target FAVORITE_ARTICLE_COUNTER = Target.the("favorite article counter").locatedBy("[class=counter]");
    public static Target FAVORITE_ARTICLE_TEXT = Target.the("favorite text").locatedBy("[class=\"btn btn-sm btn-outline-primary\"]");

}
