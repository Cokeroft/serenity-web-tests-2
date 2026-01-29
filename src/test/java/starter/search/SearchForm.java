package starter.search;

import net.serenitybdd.screenplay.targets.Target;

public class SearchForm {
    static Target USERNAME_FIELD = Target.the("username field").locatedBy("[name=username]");
    static Target SEARCH_FIELD = Target.the("search field").locatedBy("#searchbox_input");

}
