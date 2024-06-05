package singletonFinal;

public class ConfigurationManager {
	// Step 1: Create a private static variable of the same class that is the only instance of the class.
    private static ConfigurationManager instance;

    // Step 2: Make the constructor private so that this class cannot be instantiated.
    private ConfigurationManager() {
        // Initialize the configuration settings
        loadConfigurations();
    }

    // Step 3: Create a public static method that allows clients to get the instance of the class.
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    // A sample method to load configurations (simulated with a simple print statement)
    private void loadConfigurations() {
        System.out.println("Loading configuration settings...");
        // Load configurations from a file, database, etc.
    }

    // Method to get a configuration value
    public String getConfigValue(String key) {
        // In a real scenario, this method would look up the key in a configuration data structure
        return "SampleValue"; // Placeholder value
    }

    // Method to set a configuration value
    public void setConfigValue(String key, String value) {
        // In a real scenario, this method would update the key in a configuration data structure
        System.out.println("Setting " + key + " to " + value);
    }

    public static void main(String[] args) {
        // Accessing the Singleton instance
        ConfigurationManager configManager = ConfigurationManager.getInstance();

        // Using the instance to get and set configuration values
        System.out.println("Config value for 'SampleKey': " + configManager.getConfigValue("SampleKey"));
        configManager.setConfigValue("SampleKey", "NewValue");
        System.out.println("Config value for 'SampleKey': " + configManager.getConfigValue("SampleKey"));
    }


}
