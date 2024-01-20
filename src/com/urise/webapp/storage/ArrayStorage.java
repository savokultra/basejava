package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

public class ArrayStorage {

    private static final int STORAGE_SIZE = 10000;
    private final Resume[] storage = new Resume[STORAGE_SIZE];
    private int countResumes;

    public void save(Resume resume) {
        if (countResumes >= storage.length) {
            System.out.println("Лимит резюме достигнут");
        } else if (getIndex(resume.toString()) > 0) {
            System.out.println("Резюме " + resume + " уже существует");
        } else {
            storage[countResumes++] = resume;
        }
    }

    public Object get(String uuid) {
        return getIndex(uuid) >= 0 ? storage[getIndex(uuid)] : "Резюме get " + uuid + " не обнаружено";
    }

    public int size() {
        return countResumes;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResumes);
    }

    public void update(Resume resume) {
        if (getIndex(resume.toString()) >= 0) {
            storage[getIndex(resume.toString())] = resume;
            System.out.println("Резюме update " + resume + " обновлено");
        } else {
            System.out.println("Резюме update " + resume + " не обнаружено");
        }
    }

    public void delete(String uuid) {
        if (getIndex(uuid) >= 0) {
            countResumes--;
            storage[getIndex(uuid)] = storage[countResumes];
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

    int getIndex(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return - 1;
    }
}
