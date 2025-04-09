package com.stroev.storage;
import com.stroev.exception.StorageException;
import com.stroev.model.Resume;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class StorageTest extends AbstractArrayStorageTest {
    public StorageTest() {
        super(new ArrayStorage());
    }
}