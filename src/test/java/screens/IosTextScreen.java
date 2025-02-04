package screens;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class IosTextScreen {
    private final SelenideElement textButton = $(accessibilityId("Text Button")),
            textInput = $(accessibilityId("Text Input")),
            textOutput = $(accessibilityId("Text Output"));

    @Step("Click to text button")
    public IosTextScreen clickToTextButton() {
        textButton.click();
        return this;
    }

    @Step("Enter query {text} to the input field")
    public IosTextScreen enterTextToInput(String text) {
        textInput.sendKeys(text + "\n");

        return this;
    }

    @Step("Check entered text in the input field")
    public IosTextScreen assertTextExist(String text) {
        textOutput.shouldHave(Condition.text(text));

        return this;
    }
}
