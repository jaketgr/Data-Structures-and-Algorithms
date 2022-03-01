import java.util.Comparator;
public class BinarySearch {

    /**
     * Returns the index of the first key in a[] that equals the search key,
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null) throw new NullPointerException();
        if (a.length <= 0) {
            return -1;
        }
        int min = 0;
        int max = a.length - 1;
        int middle;
        while (min <= max) {
            middle = (max - min) / 2 + min;
            if (comparator.compare(key, a[middle]) > 0) {
                min = middle + 1;
            } else if (comparator.compare(key, a[middle]) < 0) {
                max = middle - 1;
            } else {
                if (middle == 0) {
                    return middle;
                } else if (comparator.compare(key, a[middle - 1]) > 0) {
                    return middle;
                } else {
                    max = middle - 1;
                }
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last key in a[] that equals the search key,
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null) throw new NullPointerException();
        if (a.length <= 0) {
            return -1;
        }
        int length = a.length - 1;
        int min = 0;
        int max = length;
        int middle;
        while (min <= max) {
            middle = (max - min) / 2 + min;
            if (comparator.compare(key, a[middle]) > 0) {
                min = middle + 1;
            }
            else if (comparator.compare(key, a[middle]) < 0) {
                max = middle - 1;
            }
            else
            {

                if (middle == length) {
                    return middle;
                }
                else if (comparator.compare(key, a[middle + 1]) < 0) {
                    return middle;
                }
                else {
                    min = middle + 1;
                }
            }
        }
        return -1;
    }
}