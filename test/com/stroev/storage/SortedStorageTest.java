package com.stroev.storage;

import com.stroev.exception.NotExistStorageException;
import org.junit.jupiter.api.Test;

class SortedStorageTest extends AbstractArrayStorageTest {
    public SortedStorageTest() {
        super(new SortedArrayStorage());
    }
}