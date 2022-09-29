/*
 * Friend.java
 *
 * Friend is a child class of Person and represents those catagorized as friends in the contactbook
 *
 * @version April 26, 2022
 * @author Sunwoo Jang
 */

import java.util.*;
import java.io.*;

public class Friend extends Person {
    private double friendshipDuration = 0.0;
    FriendStatus status = new FriendStatus();

    public Friend(String fname, String lname, String phoneNum, double duration) {
        super(fname, lname, phoneNum);
        friendshipDuration = duration;

    }

    public void printAllInformation() {
        System.out.println("Name: " + fname + " " + lname);
        System.out.println("Relationship: " + status.getStatus());
        System.out.println("You have been " + status.getStatus() + " for " + friendshipDuration + " years!");
        System.out.println("Phone number: " + phoneNumber);
        this.printBirthday();
        this.printAddress();
        this.printLikes();
        this.printHates();

    }

    public void conversate() {
        try {
            List<String> msg = new ArrayList<String>();
            BufferedReader bf = new BufferedReader(new FileReader("friend.txt"));

            String line = bf.readLine();

            while (line != null) {
                msg.add(line);
                line = bf.readLine();

            }

            bf.close();

            int randIndex = (int) (Math.random() * msg.size());
            System.out.println(fname + " says, '" + msg.get(randIndex) + ".'");

        } catch (Exception e) {
            System.out.println(fname + " has nothing to say to you.");

        }

    }

    public void menu() {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\n-----Friend Menu-----");
            System.out.println(
                    "1. Show all information\n2. Increase friend status\n3. Decrease friend status\n4. Get gift ideas\n5. Add likes\n6. Delete likes\n7. Add hates\n8. Delete hates\n9. Change birthday\n10. Change address\n11. Change phone number\n12. Talk to "
                            + fname + "\n0. Go back");

            System.out.println("\nPick an option: ");
            userInput = input.nextLine();

            // time for the biggest if, else-if, else of the program
            if (userInput.equals("1")) {
                this.printAllInformation();

            } else if (userInput.equals("2")) {
                status.increaseStatus();

            } else if (userInput.equals("3")) {
                status.decreaseStatus();

            } else if (userInput.equals("4")) {
                this.getGifts();

            } else if (userInput.equals("5")) {
                this.addLikes();

            } else if (userInput.equals("6")) {
                this.removeLikes();

            } else if (userInput.equals("7")) {
                this.addHates();

            } else if (userInput.equals("8")) {
                this.removeHates();

            } else if (userInput.equals("9")) {
                this.setBirthday();

            } else if (userInput.equals("10")) {
                this.setAddress();

            } else if (userInput.equals("11")) {
                this.setPhoneNumber();

            } else if (userInput.equals("12")) {
                this.conversate();

            } else if (userInput.equals("0")) {
                keepGoing = false;

            } else {
                System.out.println("Please enter a valid input");

            }

        } // end while
        input.close();
    }

    public void getGifts() {
        int month = birthday.getMonth();

        System.out.println("-----Gift ideas-----");
        if (month <= 3) {
            System.out.println("- Hot cocoa bombs\n- Candles\n- Squishmellow\n- Blanket\n- Insulated mug");

        } else if (month <= 6) {
            System.out.println("- Vases\n- New Plant\n- A new tote\n- Hammock\n- Bird feeder");

        } else if (month <= 9) {
            System.out.println("- Shot glasses\n- A new float\n- Sunglasses\n- Bath bombs");

        } else if (month <= 12) {
            System.out.println("- Something pumpkin spice\n- Candles\n- New phone case");

        }

    }

    public static void main(String[] args) {
        Friend pav = new Friend("Pavek", "Tumber", "3123123121", 2.5);
        pav.setBirthday();
        pav.setAddress();
        pav.addLikes();
        pav.removeLikes();
        pav.addHates();
        pav.removeHates();
        pav.printAllInformation();

    }

}
