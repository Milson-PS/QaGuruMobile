package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static config.ConfigCreator.config;
import static helpers.Browserstack.getBrowserstackUrl;
import static helpers.Environment.*;

public class BrowserstackDriver implements WebDriverProvider {
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        if (isAndroid) {
            return getAndroidDriver();
        } else if (isIos) {
            return getIosDriver();
        }
        return null;
    }

    private DesiredCapabilities commonCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("project", config.project());

        return capabilities;
    }

    private AndroidDriver getAndroidDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("deviceName", androidDevice);
        capabilities.setCapability("os_version", androidVersion);
        capabilities.setCapability("app", androidBrowserstackApp);

        return new AndroidDriver(getBrowserstackUrl(), capabilities);
    }

    private IOSDriver getIosDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("deviceName", iosDevice);
        capabilities.setCapability("os_version", iosVersion);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("app", iosBrowserstackApp);

        return new IOSDriver(getBrowserstackUrl(), capabilities);
    }
}