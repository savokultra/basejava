import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int cell;

    void clear() {
        Arrays.fill(storage, null);
        cell = 0;
    }

    void save(Resume r) {
        storage[cell++] = r;
    }

    //проверить совпадение имени на входе и в массиве при совпадении выдать имя, если нет вывести: Нет "uuid" в массиве
    Resume get(String uuid) {
        int i;
        for (i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                System.out.println("Совпадений с " + uuid + " в массиве не обнаружено");
                break;
            }
            if (storage[i].toString() == uuid) {
                break;
            }
            /*System.out.println("Моё uuid = " + uuid);
            System.out.println("Моё resume = " + storage[i]);
            System.out.println("Моё " + storage[i].toString() == uuid);*/
        }
        return storage[i];
    }

    void delete(String uuid) {
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return new Resume[0];
    }

    int size() {
        return cell;
    }
}
