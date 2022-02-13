package gmail.anastasiacoder.config;

@org.aeonbits.owner.Config.Sources({"classpath:selenoid.properties"})
public interface SelenoidConfig extends org.aeonbits.owner.Config {

    String selenoidUser();

    String selenoidPassword();
}