package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;
public class SortedArrayStorage extends AbstractArrayStorage {

    /*@Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            countResumes--;
            while (index < countResumes) {
                storage[index] = storage[index + 1];
                index++;
            }
            storage[index] = null;
            System.out.println("Удален " + uuid);
        } else {
            System.out.println("Нельзя удалить " + uuid + " т.к. uuid не обнаружен");
        }
    }

    @Override
    public void save(Resume resume) {
        if (countResumes >= storage.length) {
            System.out.println("Лимит резюме достигнут");
        } else if (getIndex(resume.toString()) >= 0) {
            System.out.println("Резюме " + resume + " уже существует");
        } else {
            storage[countResumes++] = resume;
            System.out.println(resume + " save = " + Arrays.binarySearch(storage, 0, countResumes, resume));
            int cell = Arrays.binarySearch(storage, 0, countResumes, resume);
            if (cell < 0) {
                cell = cell * -1 -1;
                Resume temp = storage[countResumes - 1];
                for (int i = countResumes; i > cell; i--) {
                    storage[i] = storage[i - 1];
                }
                storage[cell] = temp;
            }
        }
    }*/

    @Override
    protected int insertResume(String uuid) {
        return 0;
    }

    @Override
    protected int removeResume(String uuid) {
        return 0;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, countResumes, searchKey);
    }
}