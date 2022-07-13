package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/browserstack.properties")

public interface AppConfig extends Config{

    @Key("browserstack.user")
    String browserstackUser();

    @Key("browserstack.key")
    String browserstackKey();

    @Key("app")
    String app();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();

    @Key("urlBrowserstack")
    String urlBrowserstack();
}
