package org.acme;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;

@Liveness
@ApplicationScoped
public class SimpleHealthCheck implements HealthCheck {
    private static final Logger LOG = Logger.getLogger(SimpleHealthCheck.class);
    
    @Override
    public HealthCheckResponse call() {
        LOG.info("Health check executado - respondendo UP");
        return HealthCheckResponse.up("Hello Worl API OK");
    }
}
 