package Editor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Editor {
    static public Path filePath;
    static public List<String> content = new ArrayList<>();

    public static void open(Path newFilePath) throws IOException {
        //Path newFilePath = Paths.get(filename);
        if (!Files.exists(newFilePath)) {
            throw new IOException("File does not exist");
        }
        content = Files.readAllLines(newFilePath);
        filePath = newFilePath;
        System.out.println("Opened " + filePath.getFileName());
    }

    public static void save() throws IOException {
        if (filePath == null) {
            throw new IllegalStateException("No file is currently open");
        }
        Files.write(filePath, content);
        System.out.println("Successfully saved " + filePath.getFileName());
    }

    public static void saveAs(Path newFilePath) throws IOException {
        Files.write(newFilePath, content);
        filePath = newFilePath;
        System.out.println("Successfully saved as " + filePath.getFileName());
    }

    public static void close() {
        filePath = null;
        content.clear();
        System.out.println("Editor content cleared");
    }

    public static List<String> getContent() {
        return content;
    }
}
