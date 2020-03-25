package menu;

import phoneBook.PhoneBook;
import read_write_file.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainControl {

    public static List<PhoneBook> phoneList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static String pathOfFile = "F:\\CodeGym\\Module2\\Test Module 2\\phoneBook.txt";

    public static void SearchPhoneCall() {
        readFile.readFromFile(pathOfFile);
        String name;
        do {
            System.out.println("Enter name to search:");
            name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Input Name is empty. Please try again!");
            } else {
                for (int i = 0; i < MainControl.phoneList.size(); i++) {
                    boolean hasName = MainControl.phoneList.get(i).getPhoneName().equalsIgnoreCase(name);
                    if (hasName) {
                        System.out.println(MainControl.phoneList.get(i));
                        break;
                    }
                }
            }
        } while (name.isEmpty());
    }
    public static void addNewPhone() {
        String PhoneName;
        String PhoneNumber;
        String PhoneGroup;
        String Email;
        String sex;
        String Address;
        String birthDay;
        String regexEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String regexPhoneNumber = "\\d{5}";
        boolean checkInput = true;
        do {
            System.out.println("enter phone Name: ");
            PhoneName = scanner.nextLine();
            System.out.println("Enter phone Number: ");
            PhoneNumber = scanner.nextLine();
            System.out.println("Enter Phone Group: ");
            PhoneGroup = scanner.nextLine();
            System.out.println("Enter Email: ");
            Email = scanner.nextLine();
            System.out.println("Enter sex: ");
            sex = scanner.nextLine();
            System.out.println("Enter address: ");
            Address = scanner.nextLine();
            System.out.println("Enter birthday");
            birthDay = scanner.nextLine();
            boolean isEmpty = PhoneGroup.isEmpty() || PhoneName.isEmpty() || sex.isEmpty()
                    || Address.isEmpty() || birthDay.isEmpty() || !Email.matches(regexEmail)
                    || !PhoneNumber.matches(regexPhoneNumber);
            if (isEmpty) {
                System.out.println("Input is empty or invalid Email, phone number. Please try again!");
                checkInput = false;
            } else {
                PhoneBook phoneBook = new PhoneBook(PhoneName, PhoneNumber, PhoneGroup, Email, sex, Address, birthDay);
                phoneList.add(phoneBook);
            }
        } while (!checkInput);
        System.out.println("add new Phone successfully");
        writeFile.writeFileFromList(pathOfFile,phoneList);
    }

    public static void editPhoneBook() throws IOException {
        readFile.readFromFile(pathOfFile);
        ChooseEditMenu();
    }
    private static void ChooseEditMenu() throws IOException {
        int choice;
        do {
            System.out.println("Enter your choice");
            System.out.println("1. edit Name");
            System.out.println("2. edit phone");
            System.out.println("3. edit email");
            System.out.println("0. Exit!");
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                choice = 10;
            }
            scanner.nextLine();
            switch (choice) {
                case 1:
                    editInformation.editPhoneName();
                    break;
                case 2:
                    editInformation.editPhoneNumber();
                    break;
                case 3:
                    editInformation.editEmail();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wrong Option. Please try again!");
                    break;
            }
        } while (choice != 0);
    }
    public static void display(){
        for (int i = 0; i < phoneList.size(); i++) {
            System.out.println("Phone name: " + phoneList.get(i).getPhoneName()
                    + "\n" +"Phone Number: "+phoneList.get(i).getPhoneNumber()
                    + "\n" +"Email: "+ phoneList.get(i).getEmail()
                    + "\n" + "Sex: "+ phoneList.get(i).getSex()
                    + "\n" + "Address:  " +phoneList.get(i).getAddress()
                    + "\n" + " Birthday: " + phoneList.get(i).getBirthDay()
                    + "\n"+ "Group: " + phoneList.get(i).getPhoneGroup());
        }
    }
    public static void removePhoneCall() {
        String nameOfPhoneNumber;
        do {
            System.out.println("Enter name to remove:");
            nameOfPhoneNumber = scanner.nextLine();
            if (nameOfPhoneNumber.isEmpty()) {
                System.out.println("input is empty");
            } else {
                for (int i = 0; i < phoneList.size(); i++) {
                    if (phoneList.get(i).getPhoneName().equalsIgnoreCase(nameOfPhoneNumber)) {
                        phoneList.remove(i);
                    }
                }
                System.out.println("remove successfully");
            }
        } while (nameOfPhoneNumber.isEmpty());
        writeFile.writeFileFromList(pathOfFile, phoneList);
    }
}
