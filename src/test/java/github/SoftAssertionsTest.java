package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {

    @Test
    void shouldFindSoftAssertionsPage() {
        open("https://github.com/selenide/selenide");

        $("#wiki-tab").click();
        $("#wiki-body").shouldHave(text("Welcome to the selenide wiki!"));

        $(".wiki-more-pages-link>button").click();
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));

        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-body").find(byText("Soft assertions")).click();

        $("#wiki-wrapper h1").shouldHave(text("SoftAssertions"));
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
