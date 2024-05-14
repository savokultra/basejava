package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.fail;

public abstract class AbstractArrayStorageTest {

    private static final String UUID_1 = "uuid1";
    private final Resume resume1 = new Resume(UUID_1);

    private static final String UUID_2 = "uuid2";
    private final Resume resume2 = new Resume(UUID_2);

    private static final String UUID_3 = "uuid3";
    private final Resume resume3 = new Resume(UUID_3);

    private final Storage storage;

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
        Assert.assertArrayEquals(storage.getAll(), new Resume[0]);
    }

    @Test
    public void update() {
        Resume resume4 = new Resume(UUID_3);
        storage.update(resume4);
        Assert.assertSame(resume4, storage.get(UUID_3));
    }

    @Test
    public void getAll() {
        final Resume [] expected = Arrays.copyOf(storage.getAll(), storage.size());;
        Assert.assertArrayEquals(expected, storage.getAll());
    }

    @Test
    public void save() {
        final String UUID_4 = "uuid4";
        final Resume resume4 = new Resume(UUID_4);
        storage.save(resume4);
        assertGet(resume4);
        assertSize(4);

    }
//    @Test(expected = NotExistStorageException.class)
    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete("uuid1");
        assertSize(2);
        storage.get("uuid1");
    }

    @Test
    public void get() {
        for(Resume resume : storage.getAll()) {
            assertGet(resume);
        }
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = StorageException.class)
    public void checkStorageOverFlow() {
        storage.clear();
        try {
            for (int i = 0; i < 10000; i++) {
                storage.save(new Resume());
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
        save();
    }

    public void assertSize(int size) {
        Assert.assertEquals(size, storage.size());
    }

    public void assertGet(Resume resume) {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }
}
