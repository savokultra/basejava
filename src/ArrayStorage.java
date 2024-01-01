import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int fillCellCount;

    void clear() {
        Arrays.fill(storage, null);
        fillCellCount = 0;
    }

    void save(Resume resume) {
        storage[fillCellCount++] = resume;
    }

    Resume get(String uuid) {
        int cell;
        for (cell = 0; cell < storage.length; cell++) {
            if (storage[cell] == null) {
                System.out.println("Совпадений с " + uuid + " в массиве не обнаружено");
                break;
            }
            if (storage[cell].toString() == uuid) {
                break;
            }
        }
        return storage[cell];
    }

    void delete(String uuid) {
        Resume temp;
        for (int i = 0; i <= fillCellCount; i++) {
            if (storage[i].toString() == uuid) {
                storage[i] = null;
                fillCellCount--;
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
        return Arrays.copyOf(storage, fillCellCount);
    }

    int size() {
        return fillCellCount;
    }
}
