package com.mycompany;

/**
 * This class is serve to model the movement of the ball
 *
 * @author Mikhail Kurakin
 */
public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        double directionRadians = direction * (Math.PI / 180.0);
        xDelta = (float) (speed * Math.cos(directionRadians));
        yDelta = (float) (-speed * Math.sin(directionRadians));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getXDelta() {
        return xDelta;
    }

    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getYDelta() {
        return yDelta;
    }

    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal() {
        xDelta = -xDelta;

    }

    public void reflectVertical() {
        yDelta = -yDelta;

    }

    @Override
    public String toString() {
        return "Ball[" +
                "(" + x + ", " + y + "), " +
                "speed=(" + xDelta + ", " + yDelta + ")]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ball ball = (Ball) o;

        if (Float.compare(ball.x, x) != 0) return false;
        if (Float.compare(ball.y, y) != 0) return false;
        if (radius != ball.radius) return false;
        if (Float.compare(ball.xDelta, xDelta) != 0) return false;
        return Float.compare(ball.yDelta, yDelta) == 0;
    }

    @Override
    public int hashCode() {
        int result = (x != +0.0f ? Float.floatToIntBits(x) : 0);
        result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
        result = 31 * result + radius;
        result = 31 * result + (xDelta != +0.0f ? Float.floatToIntBits(xDelta) : 0);
        result = 31 * result + (yDelta != +0.0f ? Float.floatToIntBits(yDelta) : 0);
        return result;
    }
}
