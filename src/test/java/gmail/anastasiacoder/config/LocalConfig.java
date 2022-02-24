package gmail.anastasiacoder.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:local.properties"})
public interface LocalConfig extends Config {

  String emulatorName();

  String emulatorVersion();

  String appPath();
}
