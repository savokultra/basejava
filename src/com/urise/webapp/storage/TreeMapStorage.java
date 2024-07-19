package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapStorage extends AbstractStorage {
    private final Map<String, Resume> map = new TreeMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        if (map.get(uuid) == null) {
            return uuid;
        }
        return map.get(uuid).getUuid();
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        map.put((String) searchKey, resume);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        if (searchKey != null) {
            return map.containsKey((String) searchKey);
        }
        return false;
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        map.putIfAbsent((String) searchKey, resume);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return map.get((String) searchKey);
    }

    @Override
    public void doDelete(Object searchKey) {
        map.remove((String) searchKey);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return map.size();
    }
}
