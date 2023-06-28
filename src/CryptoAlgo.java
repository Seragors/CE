import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class CryptoAlgo {

    public StringBuilder encode(String fileName, int key) throws IOException {
        StringReader text = new StringReader(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader buff = new BufferedReader(text);
        String string = buff.readLine();
        for (char c : string.toCharArray()) {
            stringBuilder.append((char) (c + key));
        }
        FileSaveAndRead.fileWrite(stringBuilder);
        return stringBuilder;
    }

    public StringBuilder decode(String fileName, int key) throws IOException {
        return encode(fileName, -key);
    }
}