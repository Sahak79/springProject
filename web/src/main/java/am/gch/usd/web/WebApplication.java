package am.gch.usd.web;

import am.gch.usd.data.config.DataConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication(
   scanBasePackages = {
        "am.gch.usd.web",
        "am.gch.usd.data",
        "am.gch.usd.common"
    }
)
public class WebApplication extends SpringBootServletInitializer {

    /**
     * in case of application is deployed under traditional server
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
