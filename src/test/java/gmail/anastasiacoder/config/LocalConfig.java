package gmail.anastasiacoder.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:mobile.properties"})
public interface LocalConfig extends Config {

  @Key("emulator.name")
  String emulatorName();

  @Key("emulator.version")
  String emulatorVersion();

  @Key("emulator.app.path")
  String appPath();
}
