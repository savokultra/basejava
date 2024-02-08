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

    /*
    System.arraycopy() — по сути, это один из наилучших способов создать частичную копию массива в Java. В этом методе определены следующие параметры:
— массив, элементы которого планируем копировать;
— индекс элемента;
— итоговый (результирующий) массив;
— первый элемент итогового массива;
— общее число элементов, предназначенных для копирования.

К примеру, написав System.arraycopy(источник, 2, назначения, 5, 7), вы скопируете семь элементов из массива-источника в итоговый массив, начиная со второго индекса источника в пятый индекс результирующего массива. 
    /*

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
