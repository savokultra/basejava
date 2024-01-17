package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int countResumes;

    public void clear() {
        Arrays.fill(storage, 0, countResumes , null);
        countResumes = 0;
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

    public Resume get(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (checkUuid(i, uuid)) {
                return storage[i];
            }
        }
        System.out.println("Резюме get " + uuid + " не обнаружено");
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (checkUuid(i, uuid)) {
                countResumes--;
                storage[i] = storage[countResumes];
                storage[countResumes] = null;
                System.out.println("Удален " + uuid);
                return;
            }
        }
        System.out.println("Нельзя удалить " + uuid + " т.к. uuid не обнаружен");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResumes);
    }

    public int size() {
        return countResumes;
    }

    private boolean checkResume(int i, Resume resume) {
        return storage[i].equals(resume);
    }

    private boolean checkUuid(int i, String uuid) {
        return storage[i].toString().equals(uuid);
    }
}
