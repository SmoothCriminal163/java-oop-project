package Factories;

import Commands.*;

public class CommandFactory {
    public static Command createCommand(String[] args) {
        String commandName = args[0];
        switch (commandName) {
            case "open":
                return new OpenCommand();
            case "close":
                return new CloseCommand();
            case "save":
                return new SaveCommand();
            case "saveas":
                return new SaveAsCommand();
            case "help":
                return new HelpCommand();
            case "exit":
                return new ExitCommand();
            default:
                throw new IllegalArgumentException("Invalid command: " + commandName);
        }
    }
}