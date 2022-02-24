package gmail.anastasiacoder.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:selenoid.properties"})
public interface SelenoidConfig extends org.aeonbits.owner.Config {

    @Key("selenoidUser")
    String selenoidUser();

    @Key("selenoidPassword")
    String selenoidPassword();
}