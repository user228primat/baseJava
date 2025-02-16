package com.stroev.storage;
import com.stroev.exception.NotExistStorageException;
import com.stroev.exception.StorageException;
import com.stroev.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//size and getNotExist
class AbstractArrayStorageTest {
    ArrayStorage storage = new ArrayStorage();
    String uuid1="uuid1";
    String uuid2="uuid2";
    String uuid3="uuid3";
    String uuid4="uuid4";

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

        assertEquals(storage.getIndex(uuid1),0);
        assertEquals(storage.getIndex(uuid2),1);
        assertEquals(storage.getIndex(uuid3),2);
        assertEquals(storage.getIndex(uuid4),4);
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
        assertTrue(storage.getIndex(uuid1) != storage.getIndex(uuid2));
        assertTrue(storage.getIndex(uuid2) != storage.getIndex(uuid3));
        assertTrue(storage.getIndex(uuid3) != storage.getIndex(uuid4));
    }

    @Test
    void delete() {
        storage.delete(uuid3);
        assertEquals(3,storage.size());
        assertTrue(storage.getIndex(uuid3) < 0);
    }
}