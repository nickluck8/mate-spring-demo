package com.nick.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.config.support.InMemoryConnectionRepositoryConfigSupport;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;

import javax.sql.DataSource;

@Configuration
@EnableSocial
@PropertySource("classpath:application.properties")
public class SocialConfig implements SocialConfigurer {

    @Autowired
    DataSource source;

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        connectionFactoryConfigurer.addConnectionFactory(new FacebookConnectionFactory(
                environment.getProperty("app.id"),
                environment.getProperty("app.secret")));
    }

    @Override
    public UserIdSource getUserIdSource() {

        return new AuthenticationNameUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {

        return new InMemoryUsersConnectionRepository(connectionFactoryLocator);
    }

    @Bean
    public FacebookTemplate facebookTemplate(Environment environment) {
        return new FacebookTemplate(environment.getProperty("access.token"), environment.getProperty("app.id"));
    }

    @Bean
    public ConnectController connectController(ConnectionFactoryLocator factoryLocator, ConnectionRepository connectionRepository) {
        return new ConnectController(factoryLocator, connectionRepository);
    }


    // public ConnectionRepository

    //public InMemoryConnectionRepository
}