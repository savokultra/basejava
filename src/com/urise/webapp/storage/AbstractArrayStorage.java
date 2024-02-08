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
        if (index >= 0) {
            storage[index] = resume;
            System.out.println("Резюме update " + resume + " обновлено");
        } else {
            System.out.println("Резюме update " + resume + " не обнаружено");
        }
    }

    @Override
    final public void save(Resume resume) {
        int index = getIndex(resume.toString());
        if (countResumes >= storage.length) {
            System.out.println("Лимит резюме достигнут");
        } else if (index >= 0) {
            System.out.println("Резюме " + resume + " уже существует");
        } else {
            index = index * -1 -1;
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
        } else {
            return storage[index];
        }
    }

    @Override
    final public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            countResumes--;
            removeResume(uuid, index);
            System.out.println("Удален " + uuid);
        } else {
            System.out.println("Нельзя удалить " + uuid + " т.к. uuid не обнаружен");
        }
    }

    @Override
    final public Resume[] getAll() {
        return Arrays.copyOf(storage, countResumes);
    }

    @Override
    final public int size() {
        return countResumes;
    }

    protected abstract int getIndex(String uuid);
    protected abstract void insertResume(Resume resume, int index);
    protected abstract void removeResume(String uuid, int index);
}
