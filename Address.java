/*
 * Address.java
 * 
 * Address is used to store the address of a contact
 *
 * @version April 25, 2022
 * @author Sunwoo Jang
 */

import java.io.*;

public class Address implements Serializable {
    private String streetAddress;
    private String streetOther;
    private String city;
    private String state;
    private String zipCode;

    public Address() {
        streetAddress = "123 Sesame Street";
        streetOther = "";
        city = "Random City";
        state = "Random State";
        zipCode = "00000";

    } // end null param constructor

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;

    }

    public void setStreetOther(String streetOther) {
        this.streetOther = streetOther;

    }

    public void setCity(String city) {
        this.city = city;

    }

    public void setState(String state) {
        this.state = state;

    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;

    }

    public String assembleAddress() {
        String s;
        if (streetOther.equals("")) {
            s = streetAddress + " " + city + ", " + state + " " + zipCode;

        } else {
            s = streetAddress + " " + streetOther + ", " + city + ", " + state + " " + zipCode;    
        
        }
        return s;

    }

    public void printAddress() {
        String s = this.assembleAddress();
        System.out.println(s);

    }

    public String getAddress() {
        return this.assembleAddress();

    }

    public static void main(String[] args) {
        Address a = new Address();
        a.printAddress();

        a.setStreetAddress("11375 Ruddy Lane");
        a.setCity("Fishers");
        a.setState("IN");
        a.setZipCode("46038");
        a.printAddress();

        a.setStreetOther("Apt. 614");
        a.printAddress();

    }

}
