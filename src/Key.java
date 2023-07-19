import java.util.Scanner;

public class Key {
    public int itemKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number key: ");
        int num = scanner.nextInt();
        return num;
    }
}
