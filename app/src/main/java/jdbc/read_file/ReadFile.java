package jdbc.read_file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFile {
    private String [] words;

    public void setSql (String linkFile) {
        try {
            words = String.join("\n", Files.readAllLines(Path.of(linkFile))).split(";");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public String [] getSql () {
        return words;
    }
}
