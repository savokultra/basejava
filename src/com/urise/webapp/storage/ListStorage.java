package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {
    static ArrayList<Resume> list = new ArrayList<>();

    public static void main(String[] args) {
        list.add(new Resume("uuid_1"));
        System.out.println(list.get(0));
//        list.clear();
        String string = list.get(0).toString();
        System.out.println(string);
    }
}
