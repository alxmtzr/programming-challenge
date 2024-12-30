package de.exxcellent.challenge.reader;

import java.util.List;

/**
 * Interface for reading data from a source and returning a list of records.
 */
public interface DataReader<T> {

    // read from class path
    default List<T> fromResources(String resourcePath) {
        throw new UnsupportedOperationException("fromResources is not supported by this implementation");
    }

    // read from absolute file path
    default List<T> fromFile(String filePath) {
        throw new UnsupportedOperationException("fromFile is not supported by this implementation.");
    }

    // read from URL
    default List<T> fromUrl(String url) {
        throw new UnsupportedOperationException("fromUrl is not supported by this implementation.");
    }
}
