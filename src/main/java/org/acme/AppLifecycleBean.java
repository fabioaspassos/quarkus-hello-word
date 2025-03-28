package org.acme;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.jboss.logging.Logger;

@ApplicationScoped
public class AppLifecycleBean {

    private static final Logger LOG = Logger.getLogger(AppLifecycleBean.class);
    
    void onStart(@Observes StartupEvent ev) {
        LOG.info("A aplicação está iniciando...");
        // Informações de ambiente úteis para debug
        LOG.info("Java Version: " + System.getProperty("java.version"));
        LOG.info("Quarkus Profile: " + System.getProperty("quarkus.profile"));
    }
}