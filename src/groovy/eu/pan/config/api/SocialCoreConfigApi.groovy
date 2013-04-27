package eu.pan.config.api

import org.springframework.social.connect.ConnectionFactoryLocator
import org.springframework.social.connect.ConnectionRepository
import org.springframework.social.connect.UsersConnectionRepository

/**
 *
 * @author wolfgang haku
 */
interface SocialCoreConfigApi {

    ConnectionFactoryLocator connectionFactoryLocator()

    UsersConnectionRepository usersConnectionRepository()

    ConnectionRepository connectionRepository()
}
