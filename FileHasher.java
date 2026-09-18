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

            // Create the three files
            File notes = new File(directory, "notes.txt");
            File data = new File(directory, "data.txt");
            File log = new File(directory, "log.txt");

            // Write a sentence in each
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

            // make the Backup directory
            File backupDirectory = new File(directory, "Backup");
            if (!backupDirectory.exists()) {
                backupDirectory.mkdir();
            }

            // create the backup file and its writer
            File backup = new File(backupDirectory, "backup.txt");
            FileWriter backupWriter = new FileWriter(backup);

            // Read the file and write it into backup
            BufferedReader notesReader = new BufferedReader(new FileReader(notes));
            String line;

            // while the current line in the file that's being read isn't null, print it and write
            // it into backup
            while ((line = notesReader.readLine()) != null) {
                System.out.println(line);
                backupWriter.write(line + "\n");
            }

            // close the reader after printing and writing
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

            // close the backupWriter after done with writing
            backupWriter.close();

            // TODO (FH-4): print each file's name next to hashFile(path)

            System.out.println();
            System.out.println("--- SHA-256 ---");

            System.out.println(notes.getName() + "  " + hashFile(notes.getPath()));
            System.out.println(data.getName() + "   " + hashFile(data.getPath()));
            System.out.println(log.getName() + "    " + hashFile(log.getPath()));
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

        // Create the SHA-256 calculator
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("SHA-256 algorithm is not available");
            return "";
        }

        // create the file reader for filePath
        FileReader reader = new FileReader(filePath);

        int character;
        // while the current character being read is valid, convert it into a byte and digest that
        // specific byte
        while ((character = reader.read()) != -1) {
            digest.update((byte) character);
        }

        // close the reader
        reader.close();

        // finish hash calculations
        byte[] hashBytes = digest.digest();

        String hash = "";

        // write each hash byte into a String
        for (int i = 0; i < hashBytes.length; i++) {
            hash += String.format("%02x", hashBytes[i]);
        }

        return hash;
    }
}
