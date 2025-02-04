package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigCreator {
    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
}