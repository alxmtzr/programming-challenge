package de.exxcellent.challenge.utils;

public class PathUtils {

    /**
     * Checks if the given path is a resource path (e.g., within the classpath).
     *
     * @param path the path to check
     * @return true if the path is a resource path, false otherwise
     */
    public static boolean isResourcePath(String path) {
        return path.startsWith("de/") || path.startsWith("src/main/resources/");
    }

    /**
     * Checks if the given path is a valid URL.
     *
     * @param path the path to check
     * @return true if the path is a valid URL, false otherwise
     */
    public static boolean isUrl(String path) {
        try {
            new java.net.URL(path).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}