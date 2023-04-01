package Commands;
import Editor.Editor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SaveCommand implements Command {
    private Path filePath;
    private List<String> content;
    @Override
    public void execute(String[] args) {
        if (filePath == null) {
            throw new IllegalStateException("No file is currently open");
        }
        try {
            Editor.getInstance().save();
        } catch (IOException e) {
            System.out.println("Error saving " + filePath.getFileName() + ": " + e.getMessage());
            throw new RuntimeException("Could not save file", e);
        }
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }
}
