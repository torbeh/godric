package eu.pan.config.api

import org.apache.commons.lang.Validate
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.encrypt.Encryptors
import org.springframework.social.connect.ConnectionFactoryLocator
import org.springframework.social.connect.ConnectionRepository
import org.springframework.social.connect.UsersConnectionRepository
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository
import org.springframework.social.connect.support.ConnectionFactoryRegistry

import javax.sql.DataSource

/**
 *
 * @author wolfgang haku
 */
abstract class AbstractSocialCoreConfigApi implements SocialCoreConfigApi{

    abstract DataSource getDataSource()

    @Override
    ConnectionFactoryLocator connectionFactoryLocator() {
        return new ConnectionFactoryRegistry();
    }

    @Override
    UsersConnectionRepository usersConnectionRepository() {
        new JdbcUsersConnectionRepository(getDataSource(), connectionFactoryLocator(), Encryptors.noOpText())
    }

    @Override
    ConnectionRepository connectionRepository() {
        Authentication authentication = SecurityContextHolder.context.authentication
        Validate.notNull(authentication, "no authenticated user in security context cant create connection repository")
        usersConnectionRepository().createConnectionRepository(authentication.name)
    }
}
