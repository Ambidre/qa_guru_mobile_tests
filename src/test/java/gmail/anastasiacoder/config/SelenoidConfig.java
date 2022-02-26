package gmail.anastasiacoder.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:mobile.properties"})
public interface SelenoidConfig extends org.aeonbits.owner.Config {

    @Config.Key("selenoid.user")
    String selenoidUser();

    @Config.Key("selenoid.password")
    String selenoidPassword();
}