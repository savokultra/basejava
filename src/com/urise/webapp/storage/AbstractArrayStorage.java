package com.urise.webapp.storage;

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
        int index = getIndex(resume.toString());
        if (index < 0) {
            System.out.println("Резюме update " + resume + " не обнаружено");
        } else {
            storage[index] = resume;
            System.out.println("Резюме update " + resume + " обновлено");
        }
    }

    @Override
    final public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (countResumes >= STORAGE_LIMIT) {
            System.out.println("Лимит резюме достигнут");
        } else if (index >= 0) {
            System.out.println("Резюме " + resume + " уже существует");
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
            System.out.println("Резюме + " + uuid + " не обнаружено");
            return null;
        }
        return storage[index];
    }

    @Override
    final public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Нельзя удалить " + uuid + " т.к. uuid не обнаружен");
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
