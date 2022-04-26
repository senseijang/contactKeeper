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

    public Enemy (String fname, String lname) {
        super(fname, lname);

    }

}
