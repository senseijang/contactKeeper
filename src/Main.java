/*
 * Main.java
 *
 * Main is the engine of the program, it will be responsible for saving things as well.
 *
 * @author Sunwoo Jang
 * @version April 26, 2022
 */

import java.util.*;
import java.io.*;

public class Main {
    ArrayList<Person> contacts = new ArrayList<Person>();

    public static void main(String[] args) {
        Main main = new Main();
        main.loadContacts();
        //main.addFriend();
        //main.addEnemy();
        //main.showAllContactInfo();
        //main.showContacts();
        main.generalMenu();

    }

    public void showContacts() {
        this.loadContacts();

        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(i + ") " + contacts.get(i).getName());

        }

    }

    public void showAllContactInfo() {
        this.loadContacts();

        System.out.println();

        for (int i = 0; i < contacts.size(); i++) {
            contacts.get(i).printAllInformation();

        }

    }

    public void saveContacts() {
        try {
            FileOutputStream fos = new FileOutputStream("contacts.dat", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contacts);
            oos.flush();
            oos.close();

        } catch (Exception e) {
            System.out.println("Saving broke.");

        }

    } // end saveContacts

    public ArrayList<Person> loadContacts() {
        try {
            FileInputStream fis = new FileInputStream("contacts.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Person> loadedContacts = (ArrayList<Person>)ois.readObject();
            contacts = loadedContacts;
            return loadedContacts;

        } catch (Exception e) {
            System.out.println("You have no contacts!");
            return null;

        }

    } // end loadContacts

    public void addFriend() {
        this.loadContacts();
        Scanner input = new Scanner(System.in);
        String fname = "";
        String lname = "";
        String userInput = "";
        String phoneNum = "";
        double userDuration = 0.0;
        boolean keepGoing = true;

        System.out.println("\nAdding a new friend!");

        System.out.println("What is their first name? ");
        fname = input.nextLine();
        System.out.println("What is their last name? ");
        lname = input.nextLine();

        while (keepGoing) {
            System.out.println("What is their phone number? ");
            userInput = input.nextLine();

            if (userInput.length() == 10 || userInput.length() == 11 || userInput.length() == 0) {
                try {
                    Long.parseLong(userInput);
                    phoneNum = userInput;
                    keepGoing = false;

                } catch (Exception e) {
                    System.out.println("The input was not a phone number, please try again.");

                }

            } else {
                System.out.println("The phone number was too long please try again with a 10 or 11 digit number.");

            }

        }

        keepGoing = true;

        while (keepGoing) {
            System.out.println("How long have you guys been friends for? (years): ");
            userInput = input.nextLine();

            try {
                userDuration = Double.parseDouble(userInput);
                keepGoing = false;

            } catch (Exception e) {
                System.out.println("Duration input was invalid, please try again.");

            }

        } // end while

        Friend f = new Friend(fname, lname, phoneNum, userDuration);
        f.setBirthday();
        f.setAddress();
        
        contacts.add(f);
        this.saveContacts();

    } // end addFriend

    public void addEnemy() {
        this.loadContacts();
        Scanner input = new Scanner(System.in);
        String fname = "";
        String lname = "";
        String userInput = "";
        String phoneNum = "";
        double userDuration = 0.0;
        boolean keepGoing = true;

        System.out.println("\nAdding a new enemy!");
        System.out.println("What is their first name? ");
        fname = input.nextLine();
        System.out.println("What is their last name? ");
        lname = input.nextLine();

        while (keepGoing) {
            System.out.println("What is their phone number? ");
            userInput = input.nextLine();

            if (userInput.length() == 10 || userInput.length() == 11 || userInput.length() == 0) {
                try {
                    Long.parseLong(userInput);
                    phoneNum = userInput;
                    keepGoing = false;

                } catch (Exception e) {
                    System.out.println("The input was not a phone number, please try again.");

                }

            } else {
                System.out.println("The phone number was too long, please try again with a 10 or 11 digit number.");

            }

        }

        keepGoing = true;

        while (keepGoing) {
            System.out.println("How long have you guys been enemies for? (years): ");
            userInput = input.nextLine();

            try {
                userDuration = Double.parseDouble(userInput);
                keepGoing = false;

            } catch (Exception e) {
                System.out.println("Duration input was invalid, please try again.");

            }

        } // end while
        Enemy e = new Enemy(fname, lname, phoneNum, userDuration);
        e.setBirthday();
        e.setAddress();

        contacts.add(e);
        this.saveContacts();

    } // end addEnemy

    public void deleteContact() {
        this.loadContacts();
        System.out.println("\n-----Contact Deletion-----");
        this.showContacts();

        Scanner input = new Scanner(System.in);
        String userInput = "";
        int userIndex = -1;

        System.out.println("Which contact would you like to delete? (#): ");
        userInput = input.nextLine();

        try {
            userIndex = Integer.parseInt(userInput);
            contacts.remove(userIndex);
            this.saveContacts();

        } catch (Exception e) {
            System.out.println("The input was invalid, deletion has been aborted");

        }

    } // end deleteContact

    public void generalMenu() {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\n-----Contactbook-----");
            System.out.println("1. Show all contacts\n2. Add a new friend\n3. Add a new enemy\n4. Delete a contact\n0. Exit");
            System.out.println("\nSelect an option: ");

            userInput = input.nextLine();

            if (userInput.equals("1")) {
                this.contactSelection();

            } else if (userInput.equals("2")) {
                this.addFriend(); // saves

            } else if (userInput.equals("3")) {
                this.addEnemy(); // saves

            } else if (userInput.equals("4")) {
                this.deleteContact(); // saves

            } else if (userInput.equals("0")) {
                keepGoing = false;

            }

        }

    } // end generalMenu

    public void contactSelection() {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        int userIndex = -1;

        System.out.println("\n-----Contacts-----");
        this.showContacts();

        System.out.println("\nWhich contact would you like to interact with? (#): ");
        userInput = input.nextLine();

        try {
            userIndex = Integer.parseInt(userInput);
            contacts.get(userIndex).menu();
            this.saveContacts();

        } catch (Exception e) {
            System.out.println("\nThe input was invalid, you will be taken back to the main menu");

        }

    } // end contactSelection

}
