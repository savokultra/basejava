package com.urise;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.TreeMapStorage;

public class MainMap {
    public static void main(String[] args) {
        TreeMapStorage mapStorage = new TreeMapStorage();
        String UUID_1 = "uuid1";
        String UUID_2 = "uuid2";
        Resume RESUME_1;
        Resume RESUME_2;
        RESUME_1 = new Resume(UUID_1);
        RESUME_2 = new Resume(UUID_2);
        mapStorage.save(RESUME_1);
        mapStorage.save(RESUME_2);
    }
}
