import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Menu {
    private static final int EXIT_NUMBER = 0;
    private static final int ENCODE_NUMBER = 1;
    private static final int DECODE_NUMBER = 2;
    private static final int DECODE_NUMBER_KEY = 1;
    private static final int DECODE_NUMBER_BRUTE_FORCE = 2;
    private static final String MENU_SELECT = """
            1. Encode
            2. Decode               
            0. Exit
            """;
    private static final String MENU_SELECT_DECODE = """
            1. Decode key
            2. Decode Brute Force 
            """;
    private static boolean isRun = true;

    final CryptoAlgo cryptoAlgo = new CryptoAlgo();
    final BruteForce bruteForce = new BruteForce();
    final Scanner cs = new Scanner(System.in);
    public Key key = new Key();

    public void open() {
        while (isRun) {
            System.out.println(MENU_SELECT);
            int menuItem = cs.nextInt();
            if (menuItem == ENCODE_NUMBER) {
                itemToEncode();
            } else if (menuItem == DECODE_NUMBER) {
                System.out.println(MENU_SELECT_DECODE);
                int menuItemDec = cs.nextInt();
                if (menuItemDec == DECODE_NUMBER_KEY) {
                    itemToDecode();
                } else if (menuItemDec == DECODE_NUMBER_BRUTE_FORCE) {
                    itemBruteForce();
                }
            } else if (menuItem == EXIT_NUMBER) {
                toExit();
            }
        }
    }

    private void toExit() {
        isRun = false;
        System.out.println("Bye!");
    }

    private void itemToEncode() {
        try {
            cryptoAlgo.encode(validateFilePath(), key.key());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void itemToDecode() {
        try {
            cryptoAlgo.decode(validateFilePath(), key.key());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void itemBruteForce() {
        try {
            bruteForce.bruteForce(validateFilePath(), key.key());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String validateFilePath() throws IOException {
        String list;
        Scanner csFilePath = new Scanner(System.in);
        System.out.println("Provide path to file: ");
        try {
            String filePath = csFilePath.nextLine();
            list = Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
