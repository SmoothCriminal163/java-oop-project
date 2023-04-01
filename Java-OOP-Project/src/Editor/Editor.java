package Editor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Editor {
    private static Editor instance;
    static public Path filePath;
    static public List<String> content = new ArrayList<>();

    public static Editor getInstance() {
        if (instance == null) {
            instance = new Editor();
        }
        return instance;
    }

    public static void open(Path newFilePath) throws IOException {
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

    public static void close() throws IOException {
        if(filePath == null)
        {
            throw new IllegalStateException("No file is currently open");
        }
        filePath = null;
        content.clear();
        System.out.println("Editor content cleared");
    }

    public static void exit() throws IOException{
        //Check if there is an open file, if there is we first save it and then close it.
        if(!content.isEmpty())
        {
            save();
            close();
        }
        //Exit the program.
        System.out.println("Exiting the program!");
        System.exit(1);
    }

    public static List<String> getContent() {
        return content;
    }
}
