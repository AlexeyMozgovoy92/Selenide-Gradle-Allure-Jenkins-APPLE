package examples.tests;
import examples.helpers.DriverUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPageTest extends TestBase {
    @Test
    @DisplayName("Shopping bag should open")
    void shoppingBagOpenTest() {
        open("https://www.apple.com");
        $("[id=ac-gn-bag]").click();
        $(".ac-gn-bagview-content").shouldBe(visible);

    }

    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://www.apple.com'", () ->
            open("https://www.apple.com"));

        step("Page title should have text 'Apple'", () -> {
            String expectedTitle = "Apple";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.apple.com'", () ->
            open("https://www.apple.com"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}