package com.book.spring.annotations;

import com.book.base.PersonRepository;
import com.book.base.PersonManager;
import com.book.plain.PlainPersonRepository;
import com.book.plain.PlainPersonManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by iuliana.cosmina on 1/11/15.
 * Description: Class which replaces a Spring XML configuration file.
 */
@Configuration
@PropertySource(name="dbProp", value = "classpath:datasource/db.properties")
public class AppConfig {

    @Autowired
    Environment env;

    /* TODO 6. Create method which instantiates a valid bean of type PersonManager and names it "personManager" */

    @Bean(name="personRepository")
    public PersonRepository getPersonRepository(){
        // TODO 5. instantiate a PlainPersonRepository bean and return it
        return null;
    }

    @Bean(name="dataSource")
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("driverClassName"));
        dataSource.setUrl(env.getProperty("url"));
        dataSource.setUsername(env.getProperty("username"));
        dataSource.setPassword(env.getProperty("password"));
        return dataSource;
    }
}
