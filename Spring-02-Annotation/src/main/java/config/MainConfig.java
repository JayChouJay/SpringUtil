package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@org.springframework.context.annotation.Configuration
@ComponentScan({"controller", "service", "mapper","config"})
@PropertySource("classpath:jdbc.properties")
//@Import(Configuration.class)
public class MainConfig {
}
