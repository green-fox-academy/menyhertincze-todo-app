package PrintUsage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ArgumentHandler {
    public void handleArgument(String[] arguments) {
        if (arguments.length == 0) {
            System.out.println(getInstructions());
        }
    }

    private String getInstructions() {
        Path instructionPath = Paths.get("PrintUsage/Instructions");
        List<String> content = new ArrayList<>();
        try {
            content = Files.readAllLines(instructionPath);
        } catch (IOException e) {
            System.out.println("Instructions not available");
        }
        StringBuilder contentAsString = new StringBuilder();
        for (String line : content) {
            contentAsString.append(line);
            contentAsString.append("\n");
        }
        return contentAsString.toString();
    }

}


