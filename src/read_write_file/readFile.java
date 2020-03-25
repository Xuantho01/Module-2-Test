package read_write_file;
import menu.*;
import phoneBook.PhoneBook;

import java.io.*;

public class readFile {
    public static void readFromFile(String pathOfFile) {
        File file = new File(pathOfFile);
        try {

            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            String cutToChar = ",";
            String line = "";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(pathOfFile)));
            while ((line = bufferedReader.readLine()) != null) {

                String[] list = line.split(cutToChar);
                PhoneBook phoneBook = new PhoneBook();
                phoneBook.setPhoneName(list[0]);
                phoneBook.setPhoneNumber(list[1]);
                phoneBook.setPhoneGroup(list[2]);
                phoneBook.setEmail(list[3]);
                phoneBook.setSex(list[4]);
                phoneBook.setAddress(list[5]);
                phoneBook.setBirthDay(list[6]);
                MainControl.phoneList.add(phoneBook);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
