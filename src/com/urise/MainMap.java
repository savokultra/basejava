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
        //get all выводить ключи и значения ? реализовать так ?
        System.out.println(Arrays.toString(mapStorage.getAll()));
    }
}
