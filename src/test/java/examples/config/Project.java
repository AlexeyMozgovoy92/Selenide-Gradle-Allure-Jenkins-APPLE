package examples.config;

import org.aeonbits.owner.ConfigFactory;



public class Project {
    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static boolean isWebMobile() {
        return !config.browserMobileView().equals("false");
    }

    public static boolean isRemoteWebDriver() {
        config.remoteDriverUrl();
        return true;
    }

    /*public static boolean isVideoOn() {
        return !config.videoStorage().equals("");
    }*/
}
