package io.helidon.example.jpa.util;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@ApplicationScoped
public class DBProvider {
    private final AtomicReference<String> dbUser = new AtomicReference<>();
    private final AtomicReference<String> dbPassword = new AtomicReference<>();
    private final AtomicReference<String> dbUrl = new AtomicReference<>();

    /**
     * Create a new user provider, reading the message from configuration.
     *
     * @param dbUser
     * @param dbPassword
     * @param dbUrl
     */
    @Inject
    public DBProvider(
            @ConfigProperty(name = "datasource.username") String dbUser,
            @ConfigProperty(name = "datasource.password") String dbPassword,
            @ConfigProperty(name = "datasource.url") String dbUrl
    ) {
        this.dbUser.set(dbUser);
        this.dbPassword.set(dbPassword);
        this.dbUrl.set(dbUrl);
    }

    public String getDbUser() { return dbUser.get(); }
    public String getDbPassword() { return dbPassword.get(); }
    public String getDbUrl() { return dbUrl.get(); }

    void setDbUser(String dbUser) { this.dbUser.set(dbUser); }
    void setDbPassword(String dbPassword) { this.dbPassword.set(dbPassword); }
    void setDbUrl(String dbUrl) { this.dbUrl.set(dbUrl); }

    public EntityManager getEntityManager() {
        Map<String, Object> configOverrides = new HashMap<>();
        configOverrides.put("javax.persistence.jdbc.url", this.getDbUrl());
        configOverrides.put("javax.persistence.jdbc.user", this.getDbUser());
        configOverrides.put("javax.persistence.jdbc.password", this.getDbPassword());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hr", configOverrides);
        return emf.createEntityManager();
    }
}
