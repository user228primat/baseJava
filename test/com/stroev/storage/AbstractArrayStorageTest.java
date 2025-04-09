package com.stroev.storage;

import com.stroev.exception.StorageException;
import com.stroev.model.Resume;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

abstract public class AbstractArrayStorageTest extends AbstractStorageTest{
    @Test
    void stackOverflow(){
        for(int i=5;i<=AbstractArrayStorage.Limit;i++){
            storage.save(new Resume());
        }
        System.out.println(storage.size());

        assertThrows(StorageException.class, () -> storage.save(new Resume()));
    }
    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }
}
