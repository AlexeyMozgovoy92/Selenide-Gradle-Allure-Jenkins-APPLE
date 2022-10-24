package examples.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositiveTests {

    @Test
    @Description("Simple positive tests")
    void test1() {
        assertTrue(true);
    }
}
