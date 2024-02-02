package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int countResumes = 0;

    public int size() {
        return countResumes;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Резюме + " + uuid + " не обнаружено");
            return null;
        } else {
            return storage[index];
        }
    }

    public void save(Resume resume) {
        if (countResumes >= storage.length) {
            System.out.println("Лимит резюме достигнут");
        } else if (getIndex(resume.toString()) >= 0) {
            System.out.println("Резюме " + resume + " уже существует");
        } else {
            storage[countResumes++] = resume;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResumes);
    }

    public void update(Resume resume) {
        int index = getIndex(resume.toString());
        if (index >= 0) {
            storage[index] = resume;
            System.out.println("Резюме update " + resume + " обновлено");
        } else {
            System.out.println("Резюме update " + resume + " не обнаружено");
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            countResumes--;
            storage[index] = storage[countResumes];
            storage[countResumes] = null;
            System.out.println("Удален " + uuid);
        } else {
            System.out.println("Нельзя удалить " + uuid + " т.к. uuid не обнаружен");
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, countResumes , null);
        countResumes = 0;
    }

    protected abstract int getIndex(String uuid);
}
