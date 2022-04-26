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
    
    public Friend (String fname, String lname) {
        super(fname, lname); 

    }

    public static void main(String[] args) {
        Friend pav = new Friend("Pavek", "Tumber");
        pav.setBirthday();
        pav.setAddress();
        pav.addLikes();
        pav.removeLikes();
        pav.addHates();
        pav.removeHates();
        pav.printAllInformation();

    }

} 
