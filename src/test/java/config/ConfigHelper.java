package config;

import static config.ConfigCreator.config;

public class ConfigHelper {
    public static final String OS_NAME = System.getProperty("osName", "android");
    public static final boolean IS_ANDROID = OS_NAME.equalsIgnoreCase("android");
    public static final boolean IS_IOS = OS_NAME.equalsIgnoreCase("ios");

    public static final String DEVICE_MODEL = System.getProperty("device_model", IS_ANDROID ? config.deviceModel() : config.iosDevice());
    public static final String OS_VERSION = System.getProperty("os_version", IS_ANDROID ? config.osVersion() : config.iosVersion());
    public static final String BS_APP_URL = System.getProperty("bs_app", config.appUrl());

    public static final String BS_LOGIN = System.getProperty("bs_login", config.login());
    public static final String BS_PASSWORD = System.getProperty("bs_password", config.password());
}
