package org.example.appender;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileAppender extends AbstractAppender {

    private String filePath = "log.txt";

    public FileAppender() {}

    public FileAppender(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void append(String message) {
            Path path = Path.of(filePath);
            createParentDirectory(path);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(message);
                writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createParentDirectory(Path path) {
        Path parentDir = path.getParent();
        if (parentDir != null) {
            try {
                Files.createDirectories(parentDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
