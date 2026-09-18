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

            //make the Backup directory
            File backupDirectory = new File(directory, "Backup");
            if (!backupDirectory.exists()) {
                backupDirectory.mkdir();
            }

            //create the backup file and its writer
            File backup = new File(backupDirectory, "backup.txt");
            FileWriter backupWriter = new FileWriter(backup);

            //Read the file and write it into backup
            BufferedReader notesReader = new BufferedReader(new FileReader(notes));
            String line;

            //while the current line in the file that's being read isn't null, print it and write it into backup
            while ((line = notesReader.readLine()) != null) {
                System.out.println(line);
                backupWriter.write(line + "\n");
            }

            //close the reader after printing and writing
            notesReader.close();

            BufferedReader dataReader = new BufferedReader(new FileReader(data));

            while ((line = dataReader.readLine()) != null) {
                System.out.println(line);
                backupWriter.write(line + "\n");
            }

            dataReader.close();

            BufferedReader logReader = new BufferedReader(new FileReader(log));

            while ((line = logReader.readLine()) != null) {
                System.out.println(line);
                backupWriter.write(line + "\n");
            }

            logReader.close();

            //close the backupWriter after done with writing
            backupWriter.close();

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
