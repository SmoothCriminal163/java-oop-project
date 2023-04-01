package Commands;

import Editor.Editor;

import java.io.IOException;

public class CloseCommand implements Command {
    public void execute(String[] args) {
        try {
            Editor.getInstance().close();
        } catch (IOException e) {
            System.out.println("Error exiting  "  + e.getMessage());
            throw new RuntimeException("Could not exit!", e);
        }
    }
}
