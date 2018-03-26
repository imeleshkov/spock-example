package flow.common

/**
 * This object provide common config functionality
 */
class TestConfigFactory {

    private static Map<String, ConfigObject> configsCache = new HashMap<>()

    static synchronized ConfigObject createConfig(String propertyFileClassPath) {
        String key = propertyFileClassPath
        if (configsCache.containsKey(key)) {
            return configsCache.get(key)
        }
        else {
            ConfigObject config = createConfigInternal(propertyFileClassPath)
            configsCache.put(key, config)
            return config
        }
    }

    static ConfigObject createConfigInternal(String propertyFileClassPath) {
        return createConfigFromConfigProperties(propertyFileClassPath,  new HashMap())
    }

    private static ConfigObject createConfigFromConfigProperties(String propertyFile, Map<String, Object> initialValues) {
        def configRes = TestConfigFactory.class.getResourceAsStream(propertyFile)
        if (configRes == null) {
            configRes = TestConfigFactory.class.getClassLoader().getResourceAsStream(propertyFile)
        }
        if (configRes == null) throw new IllegalStateException('no config file was found')

        ConfigSlurper configSlurper = new ConfigSlurper()
        configSlurper.setBinding(initialValues)

        ConfigObject configObject = configSlurper.parse(configRes.text)
        return configObject
    }
}
