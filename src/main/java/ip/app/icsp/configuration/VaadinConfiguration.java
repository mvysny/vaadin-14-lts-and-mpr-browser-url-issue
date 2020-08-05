/*
 * Copyright 2001-2018 iPoint-systems. All Rights Reserved.
 *
 * This software is proprietary information of iPoint-systems.
 * Use is subject to license terms.
 */
package ip.app.icsp.configuration;

import org.springframework.context.annotation.Configuration;


/**
 * Configuration for Vaadin.
 */
@Configuration
public class VaadinConfiguration {

    public static final String VAADIN_ROOT_ROUTE = "ui";
    public static final String VAADIN_PATH = "/" + VAADIN_ROOT_ROUTE;


    /**
     * Controller mapping configuration to be able to define a redirect to entry point when context root is used.
     */
//    @Controller
//    public static class ContextRootRedirectController {
//
//        /**
//         * Perform redirect to portal entry point.
//         *
//         * @return redirect URL
//         */
//        @RequestMapping ( path = "/" )
//        public String redirectToEntryPoint () {
//            return "redirect:" + VAADIN_PATH;
//        }
//
//    }


}
