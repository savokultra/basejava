package com.urise;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.TreeMapStorage;

import java.util.Arrays;

public class MainMap {
    public static void main(String[] args) {
        TreeMapStorage mapStorage = new TreeMapStorage();
        String UUID_1 = "uuid1";
        String UUID_2 = "uuid2";
        Resume RESUME_1 = new Resume(UUID_1);
        Resume RESUME_2 = new Resume(UUID_2);
        mapStorage.save(RESUME_1);
        mapStorage.save(RESUME_2);
        //get all выводить ключи и значения ?
        System.out.println("get all = " + Arrays.toString(mapStorage.getAll()));
        mapStorage.update(RESUME_2);
        mapStorage.get("uuid2");
        mapStorage.delete("uuid2");
        System.out.println("get all after delete = " + Arrays.toString(mapStorage.getAll()));
        System.out.println("Проверка");
        System.out.println("Проверка10.01.2025");
    }
}
