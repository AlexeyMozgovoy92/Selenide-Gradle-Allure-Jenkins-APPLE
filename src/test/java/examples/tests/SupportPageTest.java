package examples.tests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;



public class SupportPageTest extends TestBase {
    @Test
    @DisplayName("Support tab should open")
    void supportTabOpenTest() {
        step("Open url'https://www.apple.com'", () -> open("https://www.apple.com"));

        step("Click on Support button", () -> $(".ac-gn-link-support").click());

        step("Support page 'https://support.apple.com/' should open", () -> {
            $(byText("Apple Support")).shouldBe(visible);
        });
    }
    @Test
    @DisplayName("Search field searching")
    void searchFieldTest() {
        step("Open Support page", () -> open("https://support.apple.com/"));

        step("Click on search field", () -> {
            $(".as-search-form-input").setValue("how to charge the iphone").pressEnter();
        });

        step("Instructions should be given", () -> {
            $(".tab_content_text_main_container").shouldHave(text("Plug into power"));
        });
    }

}