import java.io.FileWriter;
import java.io.IOException;

public class FileSaveAndRead {
    private static final String FILE_DIRECT = "G:\\Java\\CE\\src\\File\\";
    public static void fileWrite(StringBuilder fileName) {
        try (FileWriter writer = new FileWriter(FILE_DIRECT + "2.txt", true)) {
            writer.write(String.valueOf(fileName));
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
