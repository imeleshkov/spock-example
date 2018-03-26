package flow.common

import org.junit.BeforeClass
import org.junit.Test
import spock.lang.Specification

/**
 * This object represents common functionality for all flows
 */
class BaseTest extends Specification {

    protected static ConfigObject config

    @BeforeClass
    static void setUpClass() {
        config = TestConfigFactory.createConfig("groovytests-property-file.groovy")
    }

    @Test
    void dummyTest() {
    }

}
