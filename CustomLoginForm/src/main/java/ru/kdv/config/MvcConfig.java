package ru.kdv.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;

@EnableWebMvc
@Configuration
@ComponentScan("ru.kdv")
@PropertySource("classpath:application.yml")
public class MvcConfig implements WebMvcConfigurer {
    private final Environment env;

    private Logger logger = Logger.getLogger(getClass().getName());

    public MvcConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public DataSource securityDataSource(){
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
        try {
            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            logger.info(e.getLocalizedMessage());
        }
        logger.info("jdbc.driver=>>>>"+env.getProperty("jdbc.driver"));
        logger.info("jdbc.user=>>>>"+env.getProperty("jdbc.user"));

        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));

        securityDataSource.setInitialPoolSize(parseInt(env.getProperty("connection.pool.initialPoolSise")));
        securityDataSource.setMinPoolSize(parseInt(env.getProperty("connection.pool.minPoolSize")));
        securityDataSource.setMaxPoolSize(parseInt(env.getProperty("connection.pool.maxPoolSize")));
        securityDataSource.setMaxIdleTime(parseInt(env.getProperty("connection.pool.maxIdleTime")));
        return securityDataSource;
    }
}
