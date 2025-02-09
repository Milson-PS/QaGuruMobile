package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static config.ConfigCreator.config;
import static config.ConfigHelper.*;
import static helpers.Browserstack.getBrowserstackUrl;

public class BrowserstackDriver implements WebDriverProvider {
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        // Логика выбора драйвера на основе операционной системы
        if (IS_ANDROID) {
            return getAppiumDriver(true);  // Если Android, создаём AndroidDriver
        } else if (IS_IOS) {
            return getAppiumDriver(false);  // Если iOS, создаём IOSDriver
        } else {
            throw new IllegalArgumentException("Unsupported OS: " + OS_NAME);  // Если ОС не поддерживается
        }
    }

    private AppiumDriver getAppiumDriver(boolean isAndroid) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("project", config.project());  // Устанавливаем проект из конфига
        capabilities.setCapability("deviceName", DEVICE_MODEL);   // Устанавливаем название устройства
        capabilities.setCapability("os_version", OS_VERSION);     // Устанавливаем версию ОС
        capabilities.setCapability("app", BS_APP_URL);            // Устанавливаем URL приложения

        if (!isAndroid) {
            capabilities.setCapability("autoAcceptAlerts", true);  // Для iOS добавляем настройку для авто-принятия алертов
            return new IOSDriver(getBrowserstackUrl(), capabilities);  // Возвращаем IOSDriver
        }
        return new AndroidDriver(getBrowserstackUrl(), capabilities);  // Возвращаем AndroidDriver
    }
}
