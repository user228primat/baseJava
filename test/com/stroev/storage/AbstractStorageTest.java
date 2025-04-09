package com.stroev.storage;
import com.stroev.exception.NotExistStorageException;
import com.stroev.exception.StorageException;
import com.stroev.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

abstract class AbstractStorageTest {
    Storage storage;

    private final String uuid1="uuid1";
    private final String uuid2="uuid2";
    private final String uuid3="uuid3";
    private final String uuid4="uuid4";

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    //Выполняется перед каждым тестом
    @BeforeEach
    public void setUp(){
        storage.clear();
        storage.save(new Resume(uuid1));
        storage.save(new Resume(uuid2));
        storage.save(new Resume(uuid3));
        storage.save(new Resume(uuid4));
    }

    //Возвращает резюме по uuid
    @Test
    void get(){
        Assertions.assertEquals(new Resume(uuid1),storage.get(uuid1));
        Assertions.assertEquals(new Resume(uuid2),storage.get(uuid2));
        Assertions.assertEquals(new Resume(uuid3),storage.get(uuid3));
        Assertions.assertEquals(new Resume(uuid4),storage.get(uuid4));
    }

    @Test
    void getNotExist(){
        assertThrows(NotExistStorageException.class, () -> storage.get("dummy"));
    }

    @Test
    void getAll() {
        Resume[] allResume = storage.getAll();
        assertEquals(4,allResume.length);
        assertEquals(storage.get(uuid1),allResume[0]);
        assertEquals(storage.get(uuid2),allResume[1]);
        assertEquals(storage.get(uuid3),allResume[2]);
        assertEquals(storage.get(uuid4),allResume[3]);
    }

    @Test
    void size() {
        Assertions.assertEquals(4,storage.size());
    }

    @Test
    void clear() {
        storage.clear();
        Assertions.assertEquals(0,storage.size());
    }

    @Test
    void update() {
        Resume r = new Resume("uuid2");
        storage.update(r);
        Assertions.assertSame(r,storage.get("uuid2"));
    }

    @Test
    void save() {
        Assertions.assertEquals(4,storage.size());
        Assertions.assertEquals(storage.get(uuid1),new Resume(uuid1));
        Assertions.assertEquals(storage.get(uuid2),new Resume(uuid2));
        Assertions.assertEquals(storage.get(uuid3),new Resume(uuid3));
        Assertions.assertEquals(storage.get(uuid4),new Resume(uuid4));
    }

    @Test
    void saveExist() {
        assertThrows(StorageException.class, () -> storage.save(new Resume(uuid1)));
    }

    @Test
    void delete() {
        storage.delete(uuid3);
        assertEquals(3,storage.size());
        assertThrows(StorageException.class, () -> storage.get(uuid3));
    }
}