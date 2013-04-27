package eu.pan.config

import org.junit.After
import org.junit.Before
import org.springframework.social.connect.ConnectionFactoryLocator
import org.springframework.social.connect.ConnectionRepository
import org.springframework.social.connect.UsersConnectionRepository
import org.springframework.social.facebook.api.Facebook

import static org.junit.Assert.assertNotNull

/**
 *
 * @author wolfgang haku
 */
class PanContextTest {

    ConnectionFactoryLocator connectionFactoryLocator

    UsersConnectionRepository usersConnectionRepository

    ConnectionRepository connectionRepository

    Facebook facebook

    @Before
    void setUp() {
    }

    @After
    void tearDown() {
    }

    void testConnectionFactoryLocator() {
        assertNotNull(connectionFactoryLocator)
    }

    void testUsersConnectionRepository() {
       assertNotNull(usersConnectionRepository)
    }

    void testConnectionRepository() {
        assertNotNull(connectionRepository)
    }

    void testFacebook() {
        assertNotNull(facebook)
    }
}
