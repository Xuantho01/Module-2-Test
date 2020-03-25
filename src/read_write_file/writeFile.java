package read_write_file;

import phoneBook.PhoneBook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class writeFile {

    public static void writeFileFromList(String pathOfFile, List<PhoneBook> PhoneList) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(pathOfFile)));
            for (PhoneBook list : PhoneList) {
                bufferedWriter.write(String.valueOf(list));
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e){
            e.getMessage();
        }
    }
}
