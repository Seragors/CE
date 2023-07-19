import java.io.IOException;

public class BruteForce {
    final CryptoAlgo cryptoAlgo = new CryptoAlgo();
    final FileManager fileManager = new FileManager();

    public void bruteForceAttack(String fileName) throws IOException {
        for (int i = 1; i < fileName.length(); i++) {
            String decode = String.valueOf(cryptoAlgo.decode(fileName, i, false));
            if (validate(decode)) {
                System.out.println("Encryption code: " + i);
                fileManager.fileWrite(new StringBuilder(decode));
                break;
            }
        }
    }

    private boolean validate(String text) {
        return text.contains(" ");
    }
}