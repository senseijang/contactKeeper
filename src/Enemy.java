/*
 * Enemy.java
 *
 * Enemy is a child class of Person and represents enemies in the program.
 *
 * @version April 26, 2022
 * @author Sunwoo Jang
 */

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

}
