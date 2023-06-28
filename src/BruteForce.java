import java.io.IOException;

public class BruteForce {
    final CryptoAlgo cryptoAlgo = new CryptoAlgo();

    public void bruteForce(String fileName, int key) throws IOException {
        for (int i = 1; i < key + 1; i++) {
            cryptoAlgo.decode(fileName, i);
        }
    }
}
