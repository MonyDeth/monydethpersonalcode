import java.io.*;

public class ioFileOperation {
    public static void main(String[] args) {
        String filePath = "FileIOExample.txt";
        String copyFilePath = "Copied_FileIOExample.txt";
        String renameFilePath = "Rename_FileIOExample.txt";

        // Create file named FileIOExample.txt
        createFile(filePath);

        // Write content to file
        writeFilePath(filePath, "//>Initial Content");

        // read file
        readFile(filePath);

        // append to file
        appendToFile(filePath, "//>Secondary Content");

        // read appended to file
        readFile(filePath);

        // update file
        updateFile(filePath, "<// Never Before Content.");

        // read updated file
        readFile(filePath);

        // copy the file
        copyFile(filePath, copyFilePath);

        // read copied file
        readFile(copyFilePath);

        // rename file
        renameFile(filePath, renameFilePath);

        // read content of renamed filed
        readFile(renameFilePath);

        // delete the originl file
        deleteFile(copyFilePath);

        // delete the renamed file
        deleteFile(renameFilePath);

    }

    public static void createFile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println("|>| File created:" + filePath);
            } else {
                System.out.println("|!| File already exist: " + filePath);
            }
        } catch (IOException e) {
            System.out.println("|X| An error occured while creating the file. !X!");
            e.printStackTrace();
        }
    }

    public static void writeFilePath(String filePath, String content) {
        File file = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("|>| Content to be writen to file: " + content);

        } catch (IOException e) {
            System.out.println("|X| An error occured while writing to the file");
            e.printStackTrace();
        }

    }

    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("|>| Reading file: " + filePath);
            while ((line = reader.readLine()) != null) {
                System.out.println("|>| Content in: " + filePath + ":" + "\n " + line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("|!| File not found: " + filePath);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("|X| An error occured while reading the file");
            e.printStackTrace();
        }
    }

    public static void appendToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            System.out.println("|>| Content Appended to file: " + content);
        } catch (IOException e) {
            System.out.println("|X| An error occured while appending to the file");
        }
    }

    public static void updateFile(String filePath, String newContent) {
        writeFilePath(filePath, newContent);
    }

    public static void copyFile(String sourceFilePath, String destinationFilePath) {
        try (InputStream in = new FileInputStream(sourceFilePath);
                OutputStream out = new FileOutputStream(destinationFilePath)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            System.out.println("|>|File copied from " + sourceFilePath + " to " + destinationFilePath);
        } catch (FileNotFoundException e) {
            System.out.println("|!| File not found: " + sourceFilePath);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("|X| An error occurred while copying the file");
            e.printStackTrace();
        }
    }

    public static void renameFile(String oldFilePath, String newFilePath) {
        File oldFile = new File(oldFilePath);
        File newFile = new File(newFilePath);
        if (oldFile.renameTo(newFile)) {
            System.out.println("|>| File renamed to: " + newFilePath);
        } else {
            System.out.println("Failed to rename file.");
        }
    }

    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("|>| File " + filePath + " has been deleted.");
        } else {
            System.out.println("Failed to delete file.");
        }
    }
}