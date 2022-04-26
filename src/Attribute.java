/*
 * Attribute.java
 *
 * Attribute is an abstract class that acts as a template for custom attributes
 * Quite similar to the one seen in A8
 *
 * @author Sunwoo Jang
 * @version April 26, 2022
 */

import java.util.*;

abstract class Attribute {
    protected int status;
    ArrayList<String> states = new ArrayList<String>();

    public Attribute() {
        status = 1;

    }

    public Attribute(int status, String s1, String s2, String s3) {
        this.status = status;
        states.add(s1);
        states.add(s2);
        states.add(s3);
    
    }

    public void setStatus(int status) {
        this.status = status;
        this.checkOverflow();

    }

    public int getStatusLevel() {
        this.checkOverflow();
        return status;
    
    }

    public String getStatus() {
        this.checkOverflow();
        return states.get(status);

    }

    public void checkOverflow() {
        if (status < 0) {
            status = 0;

        } else if (status > 2) {
            status = 2;

        }

    }

    public void increaseStatus() {
        status++;
        this.checkOverflow();

    }

    public void decreaseStatus() {
        status--;
        this.checkOverflow();

    }

}
