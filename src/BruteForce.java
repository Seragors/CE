import java.io.IOException;

public class BruteForce {
    final CryptoAlgo cryptoAlgo = new CryptoAlgo();
    private static final int ITEM_KEY = -1;


    public void bruteForceAttack(String fileName) throws IOException {
        String text = new String(fileName);
        for (int i = 1; i < text.length(); i++) {
            String decode = String.valueOf(cryptoAlgo.decode(text, i, false));
            if (validate(decode)) {
                System.out.println("Encryption code: " + i);
                FileManager.fileWrite(new StringBuilder(decode));
                break;
            }
        }
    }

    private boolean validate(String text) {
        return text.indexOf(" ")!= ITEM_KEY;
    }
}