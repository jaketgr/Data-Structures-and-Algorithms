/**
 * Implements shift-right behavior in an array.
 *
 */

public class ShiftRight {


    /**
     * Shifts the elements at a[index] through a[a.length - 2] one
     * position to the right.
     */
    public static void shiftRight(Object[] array, int index) {
        for (int i = array.length - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = null;
        // FILL IN THE BODY OF THIS METHOD

    }
}


