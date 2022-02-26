package gmail.anastasiacoder.config;

import org.aeonbits.owner.Config;

public interface RunConfig extends Config {

    @DefaultValue("browserstack")
    String deviceHost();
}
