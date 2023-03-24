package Commands;

import Editor.Editor;

public class CloseCommand implements Command {
    public void execute(String[] args) {
        Editor.close();
    }
}
