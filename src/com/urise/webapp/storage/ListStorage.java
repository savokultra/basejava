package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;

public class ListStorage extends AbstractStorage {
    static ArrayList<Resume> list = new ArrayList<>();

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void update(Resume resume) {
        int i = list.indexOf(resume);
        if (i < 0) {
            throw new NotExistStorageException(resume.getUuid());
        }
        list.set(i, resume);
        System.out.println("обновлено резюме: " + resume);
    }

    @Override
    public void save(Resume resume) {
        list.add(resume);
    }

    @Override
    public Resume get(String uuid) {
        Resume resumeGet = new Resume(uuid);
        if (!list.contains(resumeGet)) {
            throw new NotExistStorageException(uuid);
        }
        return resumeGet;
    }

    @Override
    public void delete(String uuid) {
        Resume resumeDelete = new Resume(uuid);
        int i = list.indexOf(resumeDelete);
        if (i < 0) {
            throw new NotExistStorageException(resumeDelete.getUuid());
        }
        list.remove(i);
        System.out.println("удалено резюме: " + resumeDelete);
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        list.add(new Resume("uuid_1"));
        System.out.println(list.get(0));
//        list.clear();
//        String string = list.get(0).toString();
//        System.out.println(string);

        Resume resume100 = new Resume("resume100");
        ListStorage listStorage = new ListStorage();
        listStorage.save(resume100);
        listStorage.update(resume100);
        System.out.println("get " + listStorage.get("resume100"));
        listStorage.delete("resume100");
        listStorage.save(resume100);
        System.out.println(Arrays.toString(listStorage.getAll()));
        System.out.println("listStorage.size() = " + listStorage.size());
    }
}
