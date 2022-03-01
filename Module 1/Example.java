public class Example {
   public static boolean search(int[] array, int target) {
      for (int value : array) {
         if (value == target) {
            return true;
         }
      }
      return false;
   }
}
