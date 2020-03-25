package menu;

import java.util.Scanner;
import read_write_file.*;
public class editInformation {

    static Scanner scanner = new Scanner(System.in);
    public static void editPhoneName(){
        String name;
        String newName;
        do {
            System.out.println("Enter name to Change: ");
            name = scanner.nextLine();
            System.out.println("Enter new Name: ");
            newName = scanner.nextLine();
            boolean isEmpty = name.isEmpty() || newName.isEmpty();
            if (isEmpty){
                System.out.println("input is empty. please try again!");
            }else {
                for (int i = 0; i < MainControl.phoneList.size(); i++) {
                    if (MainControl.phoneList.get(i).getPhoneName().equalsIgnoreCase(name)) {
                        MainControl.phoneList.get(i).setPhoneName(newName);
                    }
                }
            }
        }while (name.isEmpty() || newName.isEmpty());
        System.out.println("successfully edit phone Name");
        writeFile.writeFileFromList(MainControl.pathOfFile, MainControl.phoneList);
    }

    public static void editEmail(){
        boolean isValidEmail = true;
        String regexEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        do {
            System.out.println("Enter Email: ");
            String email = scanner.nextLine();
            System.out.println("Enter new name");
            String newEmail = scanner.nextLine();

            if (!newEmail.matches(regexEmail)) {
                System.out.println("");
                isValidEmail = false;
            } else {
                for (int i = 0; i < MainControl.phoneList.size(); i++) {
                    if (MainControl.phoneList.get(i).getSex().equalsIgnoreCase(email)) {
                        MainControl.phoneList.get(i).setSex(newEmail);
                    }
                }
            }
        } while (!isValidEmail);
        System.out.println("successfully edit Email");
        writeFile.writeFileFromList(MainControl.pathOfFile, MainControl.phoneList);
    }

    public static void editPhoneNumber(){
        boolean isValidPhoneNumber = true;
        String oldPhoneNumber;
        String newPhone;
        String regexNumber = "\\d{5}";
        do {
            try {
                System.out.println("Enter Phone of phone call: ");
                oldPhoneNumber = scanner.nextLine();
                System.out.println("Enter new phone Number");
                newPhone = scanner.nextLine();
                boolean checkRegexNumber = oldPhoneNumber.matches(regexNumber) || newPhone.matches(regexNumber);
                boolean isEmpty = newPhone.isEmpty() || !checkRegexNumber;
                if (isEmpty) {
                    System.out.println("input invalid. Please try again!");
                    isValidPhoneNumber = false;
                } else {
                    for (int i = 0; i < MainControl.phoneList.size(); ++i) {
                        if ((MainControl.phoneList.get(i)).getPhoneNumber().equals(oldPhoneNumber)) {
                            (MainControl.phoneList.get(i)).setPhoneNumber(newPhone);
                        }
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }
        } while (!isValidPhoneNumber);
        System.out.println("successfully edit phone number");
        writeFile.writeFileFromList(MainControl.pathOfFile, MainControl.phoneList);
    }
}
