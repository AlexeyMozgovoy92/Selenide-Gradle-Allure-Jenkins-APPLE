package examples.tests;

import examples.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class SimpleTests extends TestBase {
    @Test
    @Description("Check that Support tab should open")
    @DisplayName("Support tab should open")
    void supportTabOpenTest() {
        step("Open url'https://www.apple.com'", () -> {
            open("https://www.apple.com");
        });

        step("Click on Support button", () -> {
            $(".ac-gn-link-support").click();
        });

        step("Support page 'https://support.apple.com/' should open", () -> {
            $(byText("Apple Support")).shouldBe(visible);
        });
    }

    @Test
    @Description("Autogenerated test")
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
    @Description("Autogenerated test")
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