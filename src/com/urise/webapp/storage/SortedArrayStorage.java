package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertResume(Resume resume, int index) {
        System.arraycopy(storage, index, storage, index + 1, countResumes - index);
        storage[index] = resume;
    }

    @Override
    protected void removeResume(String uuid, int index) {
        System.arraycopy(storage, index + 1, storage, index, countResumes - index);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, countResumes, searchKey);
    }
}