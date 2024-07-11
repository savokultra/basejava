package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume resume, int index) {
        index = -index - 1;
        System.arraycopy(storage, index, storage, index + 1, countResumes - index);
        storage[index] = resume;
    }

    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = countResumes - index - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, countResumes - index);
        }
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, countResumes, searchKey);
    }
}