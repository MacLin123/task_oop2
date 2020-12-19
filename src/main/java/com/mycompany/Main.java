package com.mycompany;

/**
 * Entry point to test Ball class with Containter class
 * @see Ball
 * @see Container
 * @author Mikhail Kurakin
 */
public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball(6, 6, 5, 10, 45);
        Container container = new Container(0, 0, 20, 20);
        System.out.println(ball);
        System.out.println(container);
        System.out.println(container.collides(ball));
        ball.move();
        System.out.println("ball moving...");
        System.out.println(ball);
        System.out.println(container);
        System.out.println(container.collides(ball));

    }
}
