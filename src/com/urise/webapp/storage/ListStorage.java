package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {
    static ArrayList<Resume> list = new ArrayList<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return null;
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {

    }

    @Override
    protected boolean isExist(Object searchKey) {
        return false;
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {

    }

    @Override
    protected Resume doGet(Object searchKey) {
        return null;
    }

    @Override
    public void doDelete(Object searchKey) {

    }

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
}
