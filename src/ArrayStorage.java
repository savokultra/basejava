import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int countResumes;

    void clear() {
        Arrays.fill(storage, 0, countResumes , null);
        countResumes = 0;
    }

    void save(Resume resume) {
        storage[countResumes++] = resume;
    }

    Resume get(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("Совпадений с " + uuid + " в массиве не обнаружено");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (storage[i].toString().equals(uuid)) {
                countResumes--;
                storage[i] = storage[countResumes];
                storage[countResumes] = null;
                break;
            }
        }
        System.out.println("Совпадений с " + uuid + " в массиве не обнаружено");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, countResumes);
    }

    int size() {
        return countResumes;
    }
}
