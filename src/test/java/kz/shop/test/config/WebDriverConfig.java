package kz.shop.test.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties",
        "classpath:test.properties",
        "classpath:local.properties"
})
public interface WebDriverConfig extends Config  {

    @Key("baseUrl")
    String getBaseUrl();

    @Key("browser")
    String getBrowserName();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserSize")
    String getBrowserSize();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("pageLoadTimeout")
    Long getPageLoadTimeout();

    @Key("userLogin")
    String getUserLogin();

    @Key("userPassword")
    String userPassword();

    @Key("unregisteredUserLogin")
    String unregisteredUserLogin();

    @Key("unregisteredUserPassword")
    String unregisteredUserPassword();


}
