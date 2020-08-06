/*
 * Copyright 2001-2018 iPoint-systems. All Rights Reserved.
 *
 * This software is proprietary information of iPoint-systems.
 * Use is subject to license terms.
 */
package ip.app.icsp.configuration;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.Location;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/**
 * Configuration for Vaadin.
 */
@Configuration
public class VaadinConfiguration {

    public static final String VAADIN_ROOT_ROUTE = "ui";

    @Bean
    public VaadinServiceInitListener contextRootRedirect () {
        return new ContextRootRedirectListener();
    }

    /**
     * Controller mapping configuration to be able to define a redirect to entry point when context root is used.
     */
    public static class ContextRootRedirectListener implements VaadinServiceInitListener {

        @Override
        public void serviceInit(ServiceInitEvent event) {
            event.getSource().addUIInitListener(uiEvent -> {
                UI ui = uiEvent.getUI();
                ui.addBeforeEnterListener(this::contextRootRedirectHandler);
            });
        }

        private void contextRootRedirectHandler(BeforeEnterEvent beforeEnterEvent) {
            Location location = beforeEnterEvent.getLocation();
            if (StringUtils.equals(location.getPath(), StringUtils.EMPTY)){
                beforeEnterEvent.forwardTo(VAADIN_ROOT_ROUTE);
            }
        }
    }


}
