package tests.ios;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

@Tag("iOS")
public class TextTests extends TestBase {
    private final String textToInput = "Hello, QA.GURU!";

    @Test
    @DisplayName("Enter word and check in app UI Elements")
    void textInputTest() {
        iosElements.clickToTextButton()
                .enterTextToInput(textToInput)
                .assertTextExist(textToInput);
    }
}
