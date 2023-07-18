import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {
    public void fileWrite(StringBuilder fileName) {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter the path for the file: ");
        Path testFilePath = Paths.get(cs.nextLine());
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
