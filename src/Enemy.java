/*
 * Enemy.java
 *
 * Enemy is a child class of Person and represents enemies in the program.
 *
 * @version April 26, 2022
 * @author Sunwoo Jang
 */

import java.util.*;

public class Enemy extends Person {
    private double enemyDuration = 0.0;
    EnemyStatus status = new EnemyStatus();

    public Enemy (String fname, String lname, String phoneNum, double duration) {
        super(fname, lname, phoneNum);
        enemyDuration = duration;

    }

    public void printAllInformation() {
        System.out.println("\nName: " + fname + " " + lname);
        System.out.println(status.getStatus());
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("You have been enemies for " + enemyDuration + " years!");
        this.printBirthday();
        this.printAddress();
        this.printLikes();
        this.printHates();

    }
    
     public void menu() {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\n-----Enemy Menu-----");
            System.out.println("1. Show all information\n2. Increase enemy status\n3. Decrease enemy status\n4. Get prank ideas\n5. Add likes\n6. Delete likes\n7. Add hates\n8. Delete hates\n9. Change birthday\n10. Change address\n11. Change phone number\n0. Go back");

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
                //this.getGifts();

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

            } else if (userInput.equals("0")) {
                keepGoing = false;

            } else {
                System.out.println("Please enter a valid input");

            }

        } // end while

    }

}
