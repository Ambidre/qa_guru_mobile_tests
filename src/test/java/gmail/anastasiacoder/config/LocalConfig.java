package gmail.anastasiacoder.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:local.properties"})
public interface LocalConfig extends Config {

  @Key("emulatorName")
  String emulatorName();

  @Key("emulatorVersion")
  String emulatorVersion();

  @Key("appPath")
  String appPath();
}
