import java.util.Scanner;

public class Key {
    public int key() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter key: ");
        int num = scanner.nextInt();
        return num;
    }
}
