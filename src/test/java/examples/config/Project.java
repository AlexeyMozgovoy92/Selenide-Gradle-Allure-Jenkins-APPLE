package examples.config;

import org.aeonbits.owner.ConfigFactory;

import java.util.Objects;

public class Project {
    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static boolean isWebMobile() {
        return !Objects.equals(config.browserMobileView(), "390x844");
    }

    public static boolean isRemoteWebDriver() {
        return !config.remoteDriverUrl().equals("");
    }

    public static boolean isVideoOn() {
        return !config.videoStorage().equals("");
    }
}
