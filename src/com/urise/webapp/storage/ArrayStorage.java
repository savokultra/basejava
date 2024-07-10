package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertResume(Resume resume, int index) {
        storage[countResumes] = resume;
    }

    @Override
    protected void removeResume(int index) {
        storage[index] = storage[countResumes];
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
