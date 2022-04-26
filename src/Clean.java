/*
 * Clean.java
 *
 * Clean's only purpose is to reset the data file without deleting it.
 * So basically, it's being overwritten with nothing
 *
 * @author Sunwoo Jang
 * @version April 26, 2022
 */

import java.io.*;

public class Clean {
    public static void main(String[] args) {
        Clean c = new Clean();
        c.cleanFile();

    }

    public void cleanFile() {
        try {
            FileOutputStream fos = new FileOutputStream("contacts.dat", false);
            fos.write(1);
            fos.flush();
            fos.close();

        } catch (Exception e) {
            System.out.println("File cleaning broke");

        }

    }

}
