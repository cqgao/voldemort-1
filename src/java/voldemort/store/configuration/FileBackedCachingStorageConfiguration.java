package voldemort.store.configuration;

import voldemort.server.VoldemortConfig;
import voldemort.store.StorageConfiguration;
import voldemort.store.StorageEngine;
import voldemort.utils.ByteArray;

public class FileBackedCachingStorageConfiguration implements StorageConfiguration {

    public static final String TYPE_NAME = "file";
    private final String inputPath;

    public FileBackedCachingStorageConfiguration(VoldemortConfig config) {
        this.inputPath = config.getMetadataDirectory();
    }

    public StorageEngine<ByteArray, byte[], byte[]> getStore(String name) {
        return new FileBackedCachingStorageEngine(name, inputPath);
    }

    public String getType() {
        return TYPE_NAME;
    }

    public void close() {}

}
