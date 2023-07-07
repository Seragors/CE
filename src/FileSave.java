import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSave {
    public static void fileWrite(StringBuilder fileName) {
        Path testFilePath = Paths.get("Files");
        try (FileWriter writer = new FileWriter(testFilePath.toFile(), true)) {
            writer.write(String.valueOf(fileName));
            writer.append('\n');
            writer.flush();
            System.out.println("Save files");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
