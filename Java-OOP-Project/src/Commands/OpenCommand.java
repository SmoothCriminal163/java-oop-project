package Commands;

import Editor.Editor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class OpenCommand implements Command {
    private Path filePath;
    private List<String> content;
    @Override
    public void execute(String[] args)
    {
        if (args.length < 2) {
            throw new IllegalArgumentException("Usage: open <filepath>");
        }

        this.filePath = Paths.get(args[1]);
        try {
            Editor.open(filePath);
            //this.content = Files.readAllLines(filePath);
            //System.out.println("Successfully opened " + filePath.getFileName());
        } catch (IOException e) {
            System.out.println("Error opening " + filePath.getFileName() + ": " + e.getMessage());
            throw new RuntimeException("Could not open file", e);
        }
    }

    public List<String> getContent() {
        return content;
    }
}