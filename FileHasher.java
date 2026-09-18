import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileHasher {

    public static void main(String[] args) {
        try {
            // TODO (FH-1): create the JavaFileSystem directory
            File directory = new File("JavaSystemFile");
            if (!directory.exists()) {
                directory.mkdir();
            }

            // TODO (FH-2): create notes.txt, data.txt, log.txt and write a sentence into each

            //Create the three files
            File notes = new File(directory, "notes.txt");
            File data = new File(directory, "data.txt");
            File log = new File(directory, "log.txt");

            //Write a sentence in each
            FileWriter notesWriter = new FileWriter(notes);
            notesWriter.write("These are my notes");
            notesWriter.close();
        
            FileWriter dataWriter = new FileWriter(data);
            dataWriter.write("This is my data");
            dataWriter.close();

            FileWriter logWriter = new FileWriter(log);
            logWriter.write("This is my log");
            logWriter.close();

            // TODO (FH-3): read each file back, print it, and write all three into
            // Backup/backup.txt
            // TODO (FH-4): print each file's name next to hashFile(path)
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    /**
     * Reads the file at filePath and returns its SHA-256 hash as a lowercase 64-character
     * hexadecimal string.
     */
    public static String hashFile(String filePath) throws IOException {
        // TODO (FH-4): read the whole file, digest it, convert the bytes to hex
        return "";
    }
}
