import java.io.IOException;

public class BruteForce {
    final CryptoAlgo cryptoAlgo = new CryptoAlgo();
    private static final int ITEM_KEY = 10;


    public void bruteForce(String fileName) throws IOException {
        String text = new String(fileName);
        for (int i = 1; i < text.length(); i++) {
            String decode = String.valueOf(cryptoAlgo.decode(text, i, false));
            if (isValidate(decode)) {
                System.out.println("Encryption code: " + i);
                FileSave.fileWrite(new StringBuilder(decode));
                break;
            }
        }

    }

    private boolean isValidate(String text) {
        for (String w : text.split(" ")) {
            if (w.length() > ITEM_KEY) {
                return false;
            }
        }
        return true;
    }

}