package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class MobileDriver implements WebDriverProvider {

    @Override
    @NonNull
    public WebDriver createDriver(@NonNull Capabilities capabilities) {
        File app = getApp();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName("Android");
        options.setDeviceName("Pixel");
        options.setPlatformVersion("11.0");
        options.setApp(app.getAbsolutePath());
        options.setAppPackage("org.wikipedia.alpha");
        options.setAppActivity("org.wikipedia.main.MainActivity");

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private File getApp() {
        String appUrl = "https://r-static-assets.androidapks.com/rdata/557d2533651967e6a383bce3eecb3e93/org.wikipedia_v2.7.280-r-2019-04-26-10280_Android-5.0.apk";              //"https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk";
        String appPath = "org.wikipedia_v2.7.280-r-2019-04-26-10280_Android-5.0.apk";

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            }
            catch (IOException e) {
                throw new AssertionError("Failed to download the app", e);
            }
        }
        return app;
    }
}
