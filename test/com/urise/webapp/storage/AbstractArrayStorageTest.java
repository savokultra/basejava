package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private final Storage storage;
    //    private Storage storage = new ArrayStorage(); что бы запустилось раскоментируй эту строку и закоментирую строку выше

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }
    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
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
        Resume resume = new Resume(UUID_1);
        Assert.assertEquals(resume, storage.get("uuid1"));
    }

    @Test
    public void getAll() {
        Resume [] resumes1 = storage.getAll();
        Assert.assertEquals(resumes1[0], storage.get("uuid1"));
        Assert.assertEquals(resumes1[storage.size() - 1], storage.get("uuid3"));
    }

    @Test
    public void save() {

    }

    @Test
    public void delete() {

    }

    @Test
    public void get() {

    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }
}