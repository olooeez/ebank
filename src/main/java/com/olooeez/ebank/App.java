package com.olooeez.ebank;

import java.util.ArrayList;
import java.util.Scanner;

import com.olooeez.ebank.account.BaseAccount;
import com.olooeez.ebank.account.OverdraftableAccount;
import com.olooeez.ebank.customer.Gender;
import com.olooeez.ebank.customer.Person;
import com.olooeez.ebank.institution.Bank;

public class App {
    private static Scanner in = new Scanner(System.in);
    private static ArrayList<Bank> listOfBanks = new ArrayList<>();
    private static ArrayList<BaseAccount> listOfAccounts = new ArrayList<>();

    public static void main(String [] args) {
        System.out.println("OOP online banking system interface");
        System.out.println("1-Create a bank");
        System.out.println("2-Create an account");
        System.out.println("3-Insert account into a bank");
        System.out.println("4-List informations");
        System.out.println("5-Exit");

        System.out.print("> ");
        
        int selectedOption;
        do {
            selectedOption = in.nextInt();
            switch (selectedOption) {
            case 1:
                listOfBanks.add(createBank());
                System.out.println("The bank was created successfully!");
                break;
            case 2:
                listOfAccounts.add(createAccount());
                System.out.println("The account was created successfully!");
                break;
            case 3:
                System.out.println("Select an account:");

                int accountCounter= 1;
                for (BaseAccount account : listOfAccounts) {
                    System.out.printf("%d-%s\n", accountCounter, account.getClient().getName());
                    accountCounter++;
                }

                System.out.print("> ");

                int selectedAccount;
                while (true) {
                    selectedAccount = in.nextInt();

                    if (selectedAccount < 1 || selectedAccount > listOfAccounts.size()) {
                        System.err.println("error: you need to select a valid option");
                        continue;
                    } else {
                        break;
                    }
                }

                System.out.println("Account selected successfully!");
                System.out.println("Select a bank to insert that account:");

                int bankCounter = 1;
                for (Bank bank : listOfBanks) {
                    System.out.printf("%d-%s\n", bankCounter, bank.getName());
                    bankCounter++;
                }

                System.out.print("> ");

                int selectedBank;
                while (true) {
                    selectedBank = in.nextInt();

                    if (selectedBank < 1 || selectedBank > listOfBanks.size()) {
                        System.err.println("error: you need to select a valid option");
                        continue;
                    } else {
                        break;
                    }
                }

                System.out.println("Bank selected successfully!");

                listOfBanks.get(selectedBank-1).insertClient(listOfAccounts.get(selectedAccount-1));

                System.out.println("The insertion of the account into the bank was successfull!");
                break;
            case 4:
                listInformation();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.err.println("error: you need to select a valid option");
            }
        } while (selectedOption != 5);

        in.close();
    }

    public static Bank createBank() {
        System.out.println("Create a bank interface");

        System.out.print("The bank name: ");
        String bankName = in.nextLine();

        return new Bank(bankName);
    }

    public static BaseAccount createAccount() {
        System.out.println("Create an account interface");

        System.out.println("1-Base account");
        System.out.println("2-Overdraftable account");
        System.out.println("3-Go back");

        System.out.print("> ");

        int selectedOption;
        do {
            selectedOption = in.nextInt();
            switch (selectedOption) {
            case 1:
                Person baseClient = createPerson();
                
                return new BaseAccount(baseClient);
            case 2:
                Person overdraftableClient = createPerson();

                return new OverdraftableAccount(overdraftableClient);
            case 3:
                return null;
            default:
                System.err.println("error: you need to select a valid option");
            }
        } while (selectedOption < 1 || selectedOption > 3);

        return null;
    }

    public static Person createPerson() {
        System.out.println("Create a person interface");

        System.out.println("1-Continue");
        System.out.println("2-Go back");

        int selectedOption;
        do {
            selectedOption = in.nextInt();
            switch (selectedOption) {
            case 1:
                System.out.print("Name: ");
                String name = in.nextLine();

                Gender gender = getGender();

                System.out.print("Age: ");
                int age = in.nextInt();
            
                return new Person(name, gender, age);
            case 2:
                return null;
            case 3:
                System.err.println("error: you need to select a valid option");
            }
        } while (selectedOption != 1 || selectedOption != 2);
        return null;
    }

    public static Gender getGender() {
        System.out.print("Select a gender:");

        System.out.println("1-Male");
        System.out.println("2-Female");
        System.out.println("3-Intergender");
        System.out.println("4-Agender");

        System.out.print("> ");

        int selectedOption;
        do {
            selectedOption = in.nextInt();
            switch (selectedOption) {
            case 1:
                return Gender.MALE;
            case 2:
                return Gender.FEMALE;
            case 3:
                return Gender.INTERGENDER;
            case 4:
                return Gender.AGENDER;
            default:
                System.err.println("error: you need to select a valid option");
            }
        } while (selectedOption < 1 || selectedOption > 4);

        return null;
    }

    public static void listInformation() {
        System.out.println("List of banks: ");

        int counter = 1;
        for (Bank bank : listOfBanks) {
            System.out.printf("%d-%s\n", counter, bank.getName());
            counter++;
        }

        System.out.println("List of accounts: ");

        counter = 1;
        for (BaseAccount account : listOfAccounts) {
            System.out.printf("%d-%s\n", counter, account.getClient().getName());
            counter++;
        }
    }
}
