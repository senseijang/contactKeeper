/*
 * Friend.java
 *
 * Friend is a child class of Person and represents those catagorized as friends in the contactbook
 *
 * @version April 26, 2022
 * @author Sunwoo Jang
 */

public class Friend extends Person {
    private double friendshipDuration = 0.0;
    FriendStatus status = new FriendStatus();
    
    public Friend (String fname, String lname, String phoneNum, double duration) {
        super(fname, lname, phoneNum);
        friendshipDuration = duration;

    }

    public void printAllInformation() {
        System.out.println("Name: " + fname + " " + lname);
        System.out.println("Relationship: " + status.getStatus());
        System.out.println("Phone number: " + phoneNumber);
        this.printBirthday();
        this.printAddress();
        this.printLikes();
        this.printHates();

    }

    public static void main(String[] args) {
        Friend pav = new Friend("Pavek", "Tumber","3123123121", 2.5);
        pav.setBirthday();
        pav.setAddress();
        pav.addLikes();
        pav.removeLikes();
        pav.addHates();
        pav.removeHates();
        pav.printAllInformation();

    }

}
