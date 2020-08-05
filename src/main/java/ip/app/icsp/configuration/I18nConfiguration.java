/*
 * Copyright 2001-2018 iPoint-systems. All Rights Reserved.
 *
 * This software is proprietary information of iPoint-systems.
 * Use is subject to license terms.
 */
package ip.app.icsp.configuration;

import com.ipointsys.coreng.i18n.CustomMessageSourceAccessor;
import com.ipointsys.coreng.i18n.FallbackMessageSourceAccessor;
import com.ipointsys.coreng.ui.VaadinLocaleContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;


/**
 * Configuration for I18n.
 */
@Configuration
public class I18nConfiguration {

    /**
     * Creates a {@link CustomMessageSourceAccessor} with the language from the user.
     *
     * @param messageSource the underlying message source
     * @return the {@link CustomMessageSourceAccessor}
     */
    @Bean
    public CustomMessageSourceAccessor messageSourceAccessor ( MessageSource messageSource ) {
        return new FallbackMessageSourceAccessor ( messageSource, new VaadinLocaleContext (), Locale.ENGLISH );
    }

}