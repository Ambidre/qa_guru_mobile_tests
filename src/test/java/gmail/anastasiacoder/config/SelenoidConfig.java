package gmail.anastasiacoder.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:selenoid.properties"})
public interface SelenoidConfig extends org.aeonbits.owner.Config {

    String selenoidUser();

    String selenoidPassword();
}