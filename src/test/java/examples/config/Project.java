package examples.config;

import org.aeonbits.owner.ConfigFactory;



public class Project {
    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static boolean isWebMobile() {
        return !config.browserMobileView().equals("400x500");
    }

    public static boolean isRemoteWebDriver() {
        return !config.remoteDriverUrl().equals("http://user1:1234@selenoid.autotests.cloud/wd/hub");
    }

    /*public static boolean isVideoOn() {
        return !config.videoStorage().equals("");
    }*/
}
