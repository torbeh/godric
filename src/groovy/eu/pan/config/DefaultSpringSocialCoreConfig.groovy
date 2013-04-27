package eu.pan.config

import eu.pan.config.api.AbstractSocialCoreConfigApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.social.connect.ConnectionFactoryLocator
import org.springframework.social.connect.ConnectionRepository
import org.springframework.social.connect.UsersConnectionRepository
import org.springframework.social.facebook.api.Facebook

import javax.inject.Inject
import javax.sql.DataSource

/**
 *
 * @author wolfgang haku
 */
@Configuration
class DefaultSpringSocialCoreConfig extends AbstractSocialCoreConfigApi{

    @Inject
    DataSource dataSource

    @Override
    public DataSource getDataSource(){
        return this.dataSource
    }

    /**
     * Add a ConnectionFactoryLocator that has registered the providers your app connects to
     * @return
     */
    @Override
    @Bean
    ConnectionFactoryLocator connectionFactoryLocator() {
        return super.connectionFactoryLocator()
    }

    /**
     * Add a UsersConnectionRepository for persisting Connection data across all users:
     * @return
     */
    @Override
    @Bean
    UsersConnectionRepository usersConnectionRepository() {
        return super.usersConnectionRepository()
    }

    /**
     * Add a ConnectionRepository for managing the current user's connections:
     * @return
     */
    @Override
    @Bean
    @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
    ConnectionRepository connectionRepository() {
        return super.connectionRepository()
    }

    @Override
    @Bean
    @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
    Facebook facebook() {
        return connectionRepository().getPrimaryConnection(Facebook).api
    }

}
