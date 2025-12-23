import java.util.Scanner;

public class AverageOfNumbers{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        
        int sum = 0;
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            sum += scanner.nextInt();
        }
        
        double average = (double) sum / n;
        System.out.println("Average: " + average);
        
        scanner.close();
    }
}