package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;
public class SortedArrayStorage extends AbstractArrayStorage {

//    TODO сделать сортировку методом двоичного поиска
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
                    storage[i] = storage[i-1];
                }
                storage[cell] = temp;
            }
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
//        System.out.println(uuid + " binarySearch = " + Arrays.binarySearch(storage, 0, countResumes, searchKey));
        return Arrays.binarySearch(storage, 0, countResumes, searchKey);
    }
}

/*
* import java.util.Arrays;

class GFG
{

    public static void main(String[] args)
    {
        final String[] arr = {"uuid1", "uuid4", "uuid3", "uuid5", "uuid7", "uuid6", "uuid2"};

        new GFG().sort(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    // Driver Code
    public void sort(String  array[])
    {
        for (int i = 1; i < array.length; i++)
        {
            String x = array[i];

            // Find location to insert
            // using binary search
            int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

            // Shifting array to one
            // location right
            System.arraycopy(array, j, array, j + 1, i - j);

            // Placing element at its
            // correct location
            array[j] = x;
        }
    }
}*/