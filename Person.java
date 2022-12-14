/*
 * Person.java
 *
 * Person is an abstract class that will also be in charge of user input management.
 * This will store most information about someone.
 *
 * @version April 26, 2022
 * @author Sunwoo Jang
 */

import java.util.*;
import java.io.*;

abstract class Person implements Serializable {
    protected ArrayList<String> likes = new ArrayList<String>();
    protected ArrayList<String> hates = new ArrayList<String>();
    // protected ArrayList<String> nicknames = new ArrayList<String>();

    protected Date birthday = new Date();
    protected Address address = new Address();

    protected String phoneNumber = "";
    protected String fname = "";
    protected String lname = "";

    public Person() {
        fname = "bob";
        lname = "saget";

    } // end null param

    public Person(String fname, String lname, String phoneNum) {
        this.fname = fname;
        this.lname = lname;
        phoneNumber = phoneNum;

    }

    public void setBirthday() {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        int month;
        int day;
        int year;
        boolean keepGoing = true;

        System.out.println("\nBirthday initializer");

        // set month, month has to be between 1 - 12
        while (keepGoing) {
            System.out.println("Month (number): ");
            userInput = input.nextLine();

            try {
                month = Integer.parseInt(userInput);

                if (month > 0 && month < 13) {
                    birthday.setMonth(month);
                    keepGoing = false;

                } else {
                    System.out.println("The value for the month was invalid, please try again. ");

                }

            } catch (Exception e) {
                System.out.println("The value for month was invalid, please try again.");

            }

        }

        keepGoing = true;

        // set day, day has to be between 1 - 31
        while (keepGoing) {
            System.out.println("Day: ");
            userInput = input.nextLine();

            try {
                day = Integer.parseInt(userInput);

                if (day > 0 && day < 32) {
                    birthday.setDay(day);
                    keepGoing = false;

                } else {
                    System.out.println("The value for the day was invalid, please try again. ");

                }

            } catch (Exception e) {
                System.out.println("The value for the day was invalid, please try again. ");

            }

        }

        keepGoing = true;
        // set year, just going to make year between 0 - 9999
        while (keepGoing) {
            System.out.println("Year ");
            userInput = input.nextLine();

            try {
                year = Integer.parseInt(userInput);

                if (year > 0 && year < 10000) {
                    birthday.setYear(year);
                    keepGoing = false;

                } else {
                    System.out.println("The value for the year was invalid, please try again. ");

                }

            } catch (Exception e) {
                System.out.println("The value for the day was invalid, please try again. ");

            }

        }
        System.out.println("Birthday has been set at " + birthday.getDate());

        input.close();
    } // setBirthday

    public void printBirthday() {
        System.out.println(fname + "'s birthday is on " + birthday.getDate());

    } // printBirthday

    public void setAddress() {
        boolean keepGoing = true;
        boolean keepZip = true;
        boolean keepState = true;
        boolean confirmation = true;

        Scanner input = new Scanner(System.in);
        String userInput = "";

        System.out.println("\nAddress initializer");

        while (keepGoing) {
            System.out.println("Street Address: ");
            userInput = input.nextLine();
            address.setStreetAddress(userInput);

            System.out.println("Street Other (If there is nothing, just press enter): ");
            userInput = input.nextLine();
            address.setStreetOther(userInput);

            System.out.println("City: ");
            userInput = input.nextLine();
            address.setCity(userInput);

            // state setter
            while (keepState) {
                System.out.println("State (Just initials): ");
                userInput = input.nextLine();

                if (userInput.length() == 2) {
                    address.setState(userInput.toUpperCase());
                    keepState = false;

                } else {
                    System.out.println("State value was not 2 characters long, please try again. ");

                }

            }

            // zip code setter, need to make sure its all numbers and 5 long
            while (keepZip) {
                System.out.println("Zip code: ");
                userInput = input.nextLine();

                try {
                    Integer.parseInt(userInput);

                    if (userInput.length() == 5) {
                        address.setZipCode(userInput);
                        keepZip = false;

                    } else {
                        System.out.println("Zip code was not 5 digits long");

                    }

                } catch (Exception e) {
                    System.out.println("Zip code input was invalid. ");

                }

            } // end zip setter

            System.out.println("Address to be set: " + address.getAddress());
            confirmation = true;

            while (confirmation) {
                System.out.println("Confirm address? (y/n): ");
                userInput = input.nextLine();
                userInput = userInput.toLowerCase();

                if (userInput.equals("y")) {
                    confirmation = false;
                    keepGoing = false;

                } else if (userInput.equals("n")) {
                    confirmation = false;
                    // go through the loop again

                } else {
                    System.out.println("Please enter a valid input.");

                }
            }

        }
        input.close();

    } // end of address setter

    public void printAddress() {
        System.out.println(fname + "'s address is " + address.getAddress());

    } // end of address printer

    public void printLikes() {
        System.out.println("\nCurrent likes: ");

        for (int i = 0; i < likes.size(); i++) {
            System.out.println(i + ") " + likes.get(i));

        }

    } // end print Likes

    public void printHates() {
        System.out.println("\nCurrent hates: ");

        for (int i = 0; i < hates.size(); i++) {
            System.out.println(i + ") " + hates.get(i));

        }

    }

    public void addLikes() {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        boolean keepGoing = true;
        boolean confirmation = true;

        while (keepGoing) {
            this.printLikes();

            System.out.println("Add a like: ");
            userInput = input.nextLine();
            likes.add(userInput);

            confirmation = true;

            while (confirmation) {
                System.out.println("Would you like to add another like? (y/n): ");
                userInput = input.nextLine();
                userInput = userInput.toLowerCase();

                if (userInput.equals("y")) {
                    confirmation = false;
                    // goes back through the loop

                } else if (userInput.equals("n")) {
                    confirmation = false;
                    keepGoing = false;

                } else {
                    System.out.println("Please enter a valid input");

                }

            }

        }
        System.out.println("\n*Updated*");
        this.printLikes();
        input.close();
    } // end addLikes

    public void addHates() {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        boolean keepGoing = true;
        boolean confirmation = true;

        while (keepGoing) {
            this.printHates();

            System.out.println("Add a hate: ");
            userInput = input.nextLine();
            hates.add(userInput);

            confirmation = true;

            while (confirmation) {
                System.out.println("Would you like to add another hate? (y/n): ");
                userInput = input.nextLine();
                userInput = userInput.toLowerCase();

                if (userInput.equals("y")) {
                    confirmation = false;
                    // goes back to loop

                } else if (userInput.equals("n")) {
                    confirmation = false;
                    keepGoing = false;

                } else {
                    System.out.println("Please enter a valid input. ");

                }

            }

        }
        input.close();
    } // end addHates

    public void removeLikes() {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        int userIndex = -1;
        boolean keepGoing = true;

        while (keepGoing) {
            this.printLikes();

            System.out.println("Which like would you like to remove? (#): ");
            userInput = input.nextLine();

            try {
                userIndex = Integer.parseInt(userInput);
                likes.remove(userIndex);

                System.out.println("Like #" + userIndex + " has been removed.");
                System.out.println("Would you like to remove another like? (y/n): ");
                userInput = input.nextLine();
                userInput = userInput.toLowerCase();

                if (userInput.equals("y")) {
                    // go back to the loop

                } else if (userInput.equals("n")) {
                    keepGoing = false;

                } else {
                    System.out.println("An invalid input was submitted, you will now be taken back. ");
                    break;

                }

            } catch (Exception e) {
                System.out.println("Please enter a numerical value for the like to be removed");

            }

        } // end while
        System.out.println("*Updated*");
        this.printLikes();
        input.close();
    } // end removeLikes

    public void removeHates() {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        int userIndex = -1;
        boolean keepGoing = true;

        while (keepGoing) {
            this.printHates();
            System.out.println("Which hate would you like to remove? (#): ");
            userInput = input.nextLine();

            try {
                userIndex = Integer.parseInt(userInput);
                hates.remove(userIndex);

                System.out.println("Hate #" + userIndex + " has been removed.");
                System.out.println("Would you like to remove another hate? (y/n): ");
                userInput = input.nextLine();
                userInput = userInput.toLowerCase();

                if (userInput.equals("y")) {
                    // go back

                } else if (userInput.equals("n")) {
                    keepGoing = false;

                } else {
                    System.out.println("An invalid input has been submitted, you will now be taken back.");
                    break;

                }

            } catch (Exception e) {
                System.out.println("Please enter a numerical value for the hate to be removed.");

            }

        }
        input.close();
    } // end removeHates

    public void conversate() {
        System.out.println("If you're seeing this, the function conversate has yet to be overwritten.");

    } // end conversate

    public void menu() {
        System.out.println("If you're seeing this, the function menu has yet to be overwritten.");

    }

    public void printAllInformation() {
        System.out.println("\nName: " + fname + " " + lname);
        this.printBirthday();
        this.printAddress();
        this.printLikes();
        this.printHates();

    }

    public String getName() {
        return fname + " " + lname;

    }

    public void setPhoneNumber() {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("What is their phone number? ");
            userInput = input.nextLine();

            if (userInput.length() == 10 || userInput.length() == 11 || userInput.length() == 0) {
                try {
                    Long.parseLong(userInput); // checks if its a number
                    phoneNumber = userInput;
                    keepGoing = false;

                } catch (Exception e) {
                    System.out.println("The input was not a phone number, please try again.");

                }

            } else {
                System.out.println("The inputted phone number was too long, please try again.");

            }

        }
        input.close();
    }
}
