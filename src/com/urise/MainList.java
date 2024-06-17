package com.urise;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ListStorage;

import java.util.Arrays;

public class MainList {
    public static void main(String[] args) {
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
