package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int countResumes;

    public void clear() {
        Arrays.fill(storage, 0, countResumes , null);
        countResumes = 0;
    }

    public void update(Resume resume) {
        // TODO check if resume present
        for (int i = 0; i < countResumes; i++) {
            if (storage[i].equals(resume)) {
                System.out.println("Обновлено резюме: " + resume);
            } else {
                System.out.println("Резюме " + resume + " не обнаружено");
            }
        }
    }
    
    public void save(Resume resume) {
        if (countResumes < storage.length) {
            for (int i = 0; i < countResumes; i++) {
                /*if (!storage[i].equals(resume)) {
                    storage[countResumes++] = resume;
                    System.out.println("Создано резюме: " + resume);
                } else {
                    System.out.println("Резюме " + resume + " не обнаружено");
                }*/
            }
        }
        //TODO check if resume not present

    }

    public Resume get(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("Совпадений с " + uuid + " в массиве не обнаружено");
        return null;
    }

    public void delete(String uuid) {
        // TODO check if resume present
        for (int i = 0; i < countResumes; i++) {
            if (storage[i].toString().equals(uuid)) {
                countResumes--;
                storage[i] = storage[countResumes];
                storage[countResumes] = null;
                break;
            }
        }
        System.out.println("Совпадений с " + uuid + " в массиве не обнаружено");
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
}
