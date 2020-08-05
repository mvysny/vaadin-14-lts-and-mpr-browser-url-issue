/*
 * Copyright 2001-2018 iPoint-systems. All Rights Reserved.
 *
 * This software is proprietary information of iPoint-systems.
 * Use is subject to license terms.
 */
package ip.app.icsp.configuration;


import com.ipointsys.coreng.data.HasUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Configuration for all kinds of session scoped data.
 */
@Configuration
public class SessionDataConfiguration {

    // other beans

    /**
     * Returns access to the current user. Since authentication is not supported yet, we just return <code>null</code>.
     *
     * @return the access to the current user
     */
    @Bean
    public HasUser<?> currentUser () {
        return () -> null;
    }

}