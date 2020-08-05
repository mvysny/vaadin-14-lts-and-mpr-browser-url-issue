package ip.app.icsp.configuration;

import com.ipointsys.coreng.annotation.TransferToCoreNG;
import com.ipointsys.coreng.boot.tomcat.TomcatCacheContextCustomizer;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


/**
 * Configuration which adds customizers for the embedded Tomcat container.
 */
@Configuration
@TransferToCoreNG
@AutoConfigureBefore ( ServletWebServerFactoryAutoConfiguration.class)
public class EmbeddedServletContainerConfig {

    private static class MyTomcatEmbeddedServletContainerFactory extends TomcatServletWebServerFactory {

        /**
         * Default constructor which adds a {@link TomcatContextCustomizer} to set the cache parameter.
         *
         * @param env the used {@link Environment}
         */
        MyTomcatEmbeddedServletContainerFactory ( Environment env ) {
            super ();
            addContextCustomizers (  new TomcatCacheContextCustomizer( env ) );
        }
    }

    @Bean
    public TomcatServletWebServerFactory embeddedServletContainerFactory ( Environment env ) {
        return new MyTomcatEmbeddedServletContainerFactory ( env );
    }
}