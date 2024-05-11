package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.fail;

//class Name {
//    константы
//    статические поля
//    final-поля
//            поля
//    конструкторы
//    геттеры/сеттеры
//            методы
//    перегруженные методы
//    вложенные классы
//}

public abstract class AbstractArrayStorageTest {
//    public class AbstractArrayStorageTest { что бы запустилось раскоментируй эту строку и закоментирую строку выше

    private static final String UUID_1 = "uuid1";
    Resume resume1 = new Resume(UUID_1);

    private static final String UUID_2 = "uuid2";
    Resume resume2 = new Resume(UUID_2);

    private static final String UUID_3 = "uuid3";
    Resume resume3 = new Resume(UUID_3);

    private final Storage storage;
    //    private Storage storage = new ArrayStorage(); что бы запустилось раскоментируй эту строку и закоментирую строку выше

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
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        Assert.assertEquals(resume1, storage.get("uuid1"));
    }

    @Test
    public void getAll() {
        Resume [] resumes = Arrays.copyOf(storage.getAll(), storage.size());
        Assert.assertEquals(resumes[0], storage.get("uuid1"));
        Assert.assertEquals(resumes[storage.size() - 1], storage.get("uuid3"));
    }

    @Test
    public void save() {
        Resume resume4 = new Resume("uuid4");
        storage.save(resume4);
        Assert.assertEquals(resume4, storage.get("uuid4"));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete("uuid1");
        Assert.assertEquals(resume1, storage.get("uuid1"));
    }

    @Test
    public void get() {
        Assert.assertEquals(resume3, storage.get("uuid3"));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = AssertionError.class)
    public void checkStorageOverFlow() {
        storage.clear();
        for (int i = 0; i < 10000; i++) {
            storage.save(new Resume());
        }
        try {
            save();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}