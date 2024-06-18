package com.urise.webapp.storage;

import org.junit.Test;

public class ListStorageTest extends AbstractArrayStorageTest {

    public ListStorageTest() {
        super(new ListStorage());
    }

    @Override
    @Test
    public void checkStorageOverFlow() {
    }

    @Override
    @Test
    public void saveExist() {
    }
}
