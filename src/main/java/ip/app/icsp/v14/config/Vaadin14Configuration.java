package ip.app.icsp.v14.config;

import com.ipointsys.coreng.i18n.CustomMessageSourceAccessor;
import com.vaadin.flow.i18n.I18NProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Configuration
public class Vaadin14Configuration {

    @Bean
    public I18NProvider customI18NProvider(CustomMessageSourceAccessor customMessageSourceAccessor) {
        return new I18NProvider() {
            @Override
            public List<Locale> getProvidedLocales() {
                return Collections.unmodifiableList(Arrays.asList(Locale.ENGLISH, Locale.GERMAN));
            }

            @Override
            public String getTranslation(String key, Locale locale, Object... params) {
                return customMessageSourceAccessor.getMessage(locale, key, params);
            }
        };
    }
}
