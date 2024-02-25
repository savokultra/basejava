package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int countResumes = 0;

    @Override
    final public void clear() {
        Arrays.fill(storage, 0, countResumes , null);
        countResumes = 0;
    }

    @Override
    final public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            storage[index] = resume;
            System.out.println("Резюме update " + resume + " обновлено");
        }
    }

    @Override
    final public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (countResumes >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            index = -index - 1;
            insertResume(resume, index);
            countResumes++;
        }
    }

    @Override
    final public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    @Override
    final public void delete (String uuid) throws NotExistStorageException {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            countResumes--;
            removeResume(index);
            storage[countResumes] = null;
            System.out.println("Удален " + uuid);
        }
    }

    @Override
    final public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, countResumes);
    }

    @Override
    final public int size() {
        return countResumes;
    }

    protected abstract int getIndex(String uuid);
    protected abstract void insertResume(Resume resume, int index);
    protected abstract void removeResume(int index);
}
