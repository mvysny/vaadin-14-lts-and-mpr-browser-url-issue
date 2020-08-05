package ip.app.icsp.configuration;

import org.springframework.boot.actuate.autoconfigure.jolokia.JolokiaEndpoint;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


/**
 * Security related configuration.
 */
@Configuration
public class SecurityConfig {

    /**
     * Configuration for the management endpoints.
     */
    @Configuration
    @Order ( SecurityProperties.BASIC_AUTH_ORDER - 1 )
    static class ActuatorConfig extends WebSecurityConfigurerAdapter {

        @Override
        public void configure ( HttpSecurity http ) throws Exception {

            // exclude JolokiaEndpoint because EndpointRequest.toAnyEndpoint () use a MvcRequestMatcher which doesn't work for this endpoint
            // instead use normal AntPathRequestMatcher for the JolokiaEndpoint because it just expose a own servlet
            // see org.springframework.boot.actuate.autoconfigure.jolokia.JolokiaEndpoint.get()
            http.requestMatchers ()
                .requestMatchers ( EndpointRequest.toAnyEndpoint ().excluding ( JolokiaEndpoint.class ), new AntPathRequestMatcher ( "/jolokia/**" ) )
                .and ().authorizeRequests ().anyRequest ().permitAll ();

            // http://codecentric.github.io/spring-boot-admin/2.1.4/#_csrf_on_actuator_endpoints
            http.csrf ().ignoringRequestMatchers ( EndpointRequest.toAnyEndpoint () );
        }
    }

    /**
     * Configuration for the UI endpoints.
     */
    @Configuration
    @Order ( SecurityProperties.BASIC_AUTH_ORDER + 1 )
    @EnableConfigurationProperties ( SecurityProperties.class )
    static class UiConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        public void configure ( HttpSecurity http ) throws Exception {
            // disable csrf because VAADIN has a own mechanism for that
            http.csrf ().disable ()
                    .sessionManagement ().sessionCreationPolicy ( SessionCreationPolicy.ALWAYS )
                .and ()
                    .authorizeRequests ().anyRequest ().permitAll ();
        }

        @Override
        public void configure ( WebSecurity web ) {
            web.ignoring ().antMatchers ( "/css/**", "/js/**", "/favicon.ico", "/webjars/**", "/401", "/403", "/404", "/error", "/health" );
        }

    }

}