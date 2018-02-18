package util;

import java.util.ResourceBundle;

public class Util {
    private static final String resourceBundle = "resources/properties/applicationConfiguration";

    public static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle(resourceBundle);
    }
}
