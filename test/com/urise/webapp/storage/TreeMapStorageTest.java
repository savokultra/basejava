package com.urise.webapp.storage;

import org.junit.Ignore;
import org.junit.Test;

public class TreeMapStorageTest extends AbstractStorageTest {
    public TreeMapStorageTest() {
        super(new TreeMapStorage());
    }

    @Ignore
    @Test
    public void checkStorageOverFlow() {
    }
}
