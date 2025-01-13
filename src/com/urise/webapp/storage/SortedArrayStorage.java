package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);
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
        Resume searchKey = new Resume(uuid, "dummy");
        return Arrays.binarySearch(storage, 0, countResumes, searchKey, RESUME_COMPARATOR);
    }
}