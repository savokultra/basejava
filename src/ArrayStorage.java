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
        int cell;
        for (cell = 0; cell < storage.length; cell++) {
            if (storage[cell] == null) {
                System.out.println("Совпадений с " + uuid + " в массиве не обнаружено");
                break;
            }
            if (storage[cell].toString().equals(uuid)) {
                break;
            }
        }
        return storage[cell];
    }

    void delete(String uuid) {
        Resume temp;
        for (int i = 0; i <= countResumes; i++) {
            if (storage[i].toString().equals(uuid)) {
                storage[i] = null;
                countResumes--;
                if (storage[i + 1] != null) {
                    do {
                        temp = storage[i + 1];
                        storage[i] = temp;
                        storage[i + 1] = null;
                        i++;
                    } while (storage[i + 1] != null);
                }
            } else {
                System.out.println("Совпадений с " + uuid + " в массиве не обнаружено");
            }
        }
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
