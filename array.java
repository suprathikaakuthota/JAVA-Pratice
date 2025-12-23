public class array {
      public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        
        try {
            numbers[5] = 100;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index");
        }
    }
}