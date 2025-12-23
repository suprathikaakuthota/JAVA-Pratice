import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class error{
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("keerthi.txt"));
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
