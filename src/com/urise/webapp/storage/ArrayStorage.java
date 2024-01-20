package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

public class ArrayStorage {

    private static final int STORAGE_SIZE = 10000;
    private final Resume[] storage = new Resume[STORAGE_SIZE];
    private int countResumes;

    public void save(Resume resume) {
        if (countResumes >= storage.length) {
            return;
        }
        if (countResumes != 0) {
            for (int i = 0; i < countResumes; i++) {
                if (checkResume(i, resume)) {
                    System.out.println("Резюме " + resume + " уже существует");
                    return;
                }
            }
        }
        storage[countResumes++] = resume;
    }

    /*public Resume get(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (checkUuid(i, uuid)) {
                return storage[i];
            }
        }
        System.out.println("Резюме get " + uuid + " не обнаружено");
        return null;
    }*/

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
        for (int i = 0; i < countResumes; i++) {
            if (checkResume(i, resume)) {
                System.out.println("Обновлено резюме: " + resume);
                break;
            } else {
                System.out.println("Резюме update " + resume + " не обнаружено");
            }
        }
    }

    public void delete(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (getIndex(uuid) >= 0) {
                countResumes--;
                storage[i] = storage[countResumes];
                storage[countResumes] = null;
                System.out.println("Удален " + uuid);
                return;
            }
        }
        System.out.println("Нельзя удалить " + uuid + " т.к. uuid не обнаружен");
    }

    public void clear() {
        Arrays.fill(storage, 0, countResumes , null);
        countResumes = 0;
    }

    private boolean checkUuid(int i, String uuid) {
        return storage[i].toString().equals(uuid);
    }
    
    private boolean checkResume(int i, Resume resume) {
        return storage[i].equals(resume);
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
