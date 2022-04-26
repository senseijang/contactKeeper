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

    }


}
