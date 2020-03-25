package menu;

import client.Main;

import java.io.IOException;
import java.util.Scanner;

public class Options {
    public static void chooseOptions() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Enter your choice");
            System.out.println("1. lookup");
            System.out.println("2. Add new Phone call");
            System.out.println("3. Remove phone call");
            System.out.println("4. Edit Phone Call");
            System.out.println("0. Exit!");

            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                choice = 10;
            }
            scanner.nextLine();
            switch (choice) {
                case 1:
                    MainControl.SearchPhoneCall();
                    break;
                case 2:
                    MainControl.addNewPhone();
                    break;
                case 3:
                    MainControl.removePhoneCall();
                    break;
                case 4:
                    MainControl.editPhoneBook();
                    break;
                case 5:
                    MainControl.display();
                case 0:
                    break;
                default:
                    System.out.println("Wrong Option. Please try again!");
                    break;
            }
        } while (choice != 0);
    }
}
