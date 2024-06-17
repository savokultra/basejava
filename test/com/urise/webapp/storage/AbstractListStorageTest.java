package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Before;

public class AbstractListStorageTest {
    private final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME_1;

    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME_2;

    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_3;

    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_4;

    static {
        RESUME_1 = new Resume(UUID_1);
        RESUME_2 = new Resume(UUID_2);
        RESUME_3 = new Resume(UUID_3);
        RESUME_4 = new Resume(UUID_4);
    }

    public AbstractListStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }


}
