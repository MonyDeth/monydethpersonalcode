import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.List;

public class NioFileOperationse {
    public static void main(String[] args) {
        String filePath = "NioFileOperation.txt";
        String copyFilePath = "Copied_NioFileOperation.txt";
        String renameFilePath = "Rename_NioFileOperation.txt";

        // Create file named FileIOExample.txt
        createFile(filePath);

        // Write content to file
        writeFilePath(filePath, "//>Initial NIO Content");

        // Read file
        readFile(filePath);

        // Append to file
        appendToFile(filePath, "//>Secondary NIO Content");

        // Read appended to file
        readFile(filePath);

        // Update file
        updateFile(filePath, "<// Never Before NIO Content.");

        // Read updated file
        readFile(filePath);

        // Copy the file
        copyFile(filePath, copyFilePath);

        // Read copied file
        readFile(copyFilePath);

        // Rename file
        renameFile(filePath, renameFilePath);

        // Read content of renamed file
        readFile(renameFilePath);

        // Delete the copied file
        deleteFile(copyFilePath);

        // Delete the renamed file
        deleteFile(renameFilePath);
    }

    public static void createFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.createFile(path);
            System.out.println("|>| File created: " + filePath);
        } catch (FileAlreadyExistsException e) {
            System.out.println("|!| File already exists: " + filePath);
        } catch (IOException e) {
            System.out.println("|X| An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    public static void writeFilePath(String filePath, String content) {
        Path path = Paths.get(filePath);
        try {
            Files.write(path, content.getBytes(StandardCharsets.UTF_8));
            System.out.println("|>| Content written to file: " + content);
        } catch (IOException e) {
            System.out.println("|X| An error occurred while writing to the file");
            e.printStackTrace();
        }
    }

    public static void readFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            System.out.println("|>| Reading file: " + filePath);
            for (String line : lines) {
                System.out.println("|>| Content in: " + filePath + ":\n " + line);
            }
        } catch (NoSuchFileException e) {
            System.out.println("|!| File not found: " + filePath);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("|X| An error occurred while reading the file");
            e.printStackTrace();
        }
    }

    public static void appendToFile(String filePath, String content) {
        Path path = Paths.get(filePath);
        try {
            Files.write(path, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            System.out.println("|>| Content appended to file: " + content);
        } catch (IOException e) {
            System.out.println("|X| An error occurred while appending to the file");
            e.printStackTrace();
        }
    }

    public static void updateFile(String filePath, String newContent) {
        writeFilePath(filePath, newContent);
    }

    public static void copyFile(String sourceFilePath, String destinationFilePath) {
        Path sourcePath = Paths.get(sourceFilePath);
        Path destinationPath = Paths.get(destinationFilePath);
        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("|>| File copied from " + sourceFilePath + " to " + destinationFilePath);
        } catch (NoSuchFileException e) {
            System.out.println("|!| File not found: " + sourceFilePath);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("|X| An error occurred while copying the file");
            e.printStackTrace();
        }
    }

    public static void renameFile(String oldFilePath, String newFilePath) {
        Path oldPath = Paths.get(oldFilePath);
        Path newPath = Paths.get(newFilePath);
        try {
            Files.move(oldPath, newPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("|>| File renamed to: " + newFilePath);
        } catch (NoSuchFileException e) {
            System.out.println("|!| File not found: " + oldFilePath);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("|X| An error occurred while renaming the file");
            e.printStackTrace();
        }
    }

    public static void deleteFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.delete(path);
            System.out.println("|>| File " + filePath + " has been deleted.");
        } catch (NoSuchFileException e) {
            System.out.println("|!| File not found: " + filePath);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Failed to delete file.");
            e.printStackTrace();
        }
    }
}
