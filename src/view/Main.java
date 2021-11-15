package view;

import model.Phone;
import unit.ReadAndWrite;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Phone phone = new Phone();
    public static ArrayList<Phone> listPhone = new ArrayList<Phone>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        View.menu();
        String choice;
        choice = scanner.nextLine();
        switch (choice) {
            case "1":
                showListphone();
                break;
            case "2":
                addPhone();
                break;
            case "3":

                break;
            case "4":
                deletePhone();
                break;
            case "5":

                break;
            case "6":
                listPhone = ReadAndWrite.readFileToCsv();
                break;
            case "7":
                ReadAndWrite.writeFileToCSV(listPhone);
                break;
            case "0":

                break;
            default:
                break;

        }
    }

    private static void deletePhone() {
        System.out.println("Nhap so dien thoai muon xoa");
    }

    private static void showListphone() {
        listPhone = ReadAndWrite.readFileToCsv();
        System.out.println(phone.toString());
    }

    private static void addPhone() {

        System.out.println("Nhap so dien thoai:");
        phone.setNumberPhone(scanner.nextLine());
        System.out.println("Nhap nhom:");
        phone.setGroup(scanner.nextLine());
        System.out.println("Nhap ho va ten:");
        phone.setFullname(scanner.nextLine());
        System.out.println("Nhap gioi tinh:");
        phone.setGender(scanner.nextLine());
        System.out.println("Nhap dia chi:");
        phone.setAddress(scanner.nextLine());
        System.out.println("Nhap ngay sinh:");
        phone.setDateOfBirth(scanner.nextLine());
        System.out.println("Nhap email:");
        phone.setEmail(scanner.nextLine());
        listPhone.add(phone);
        ReadAndWrite.writeFileToCSV(listPhone);
        System.out.println("Da them thanh cong");
        scanner.nextLine();
        View.menu();
    }


}
