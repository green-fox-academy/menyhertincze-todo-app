import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ListHandler {
    public void handleList(String[] arguments) {
        if (arguments.length == 0) {
            System.out.println("Please type a command");
        } else if (arguments[0].equals("-l")) {
            System.out.println(getListOfTasks());
        } else if (arguments[0].equals("-a")) {
            addNewTask(arguments[1]);


        }

    }

    private String getListOfTasks() {
        Path EmptyListPath = Paths.get("EmptyList");
        List<String> content = new ArrayList<>();
        try {
            content = Files.readAllLines(EmptyListPath);
        } catch (IOException e) {
            System.out.println("List not available");
        }
        StringBuilder contentAsString = new StringBuilder();
        for (String line : content) {
            contentAsString.append(line);
            contentAsString.append("\n");
        }
        if (content.size() == 0) {
            return ("No todos for today! :)");
        }
        return contentAsString.toString();
    }

    private void addNewTask(String toDoToAdd) {
        List <String> todoList = new ArrayList<>();
        try {
            Path path = Paths.get("EmptyList");
            Files.writeString(path, toDoToAdd, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("unable");
        }

    }

}
