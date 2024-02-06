package com.urise.webapp.storage;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected int insertResume(String uuid) {
        return 0;
    }

    @Override
    protected int removeResume(String uuid) {
        return 0;
    }
}
