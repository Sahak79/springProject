package am.gch.usd.data.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:db-config.properties")
@EntityScan("am.gch.usd.common.data.model")
@EnableJpaRepositories("am.gch.usd.data")
@EnableTransactionManagement
public class DataConfig {

}
