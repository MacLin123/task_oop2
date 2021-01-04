package com.mycompany;

/**
 * This class is serve to test Ball class
 *
 * @author Mikhail Kurakin
 * @see Ball
 */
public class Container {
    int x1;
    int y1;
    int x2;
    int y2;

    public Container(int x, int y, int width, int height) {
        x1 = x;
        y1 = y;
        x2 = x + width;
        y2 = y + height;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return x2 - x1;
    }

    public int getHeight() {
        return y2 - y1;
    }

    public boolean collides(Ball ball) {
        float edgeX2 = ball.getX() + ball.getRadius();
        float edgeX1 = ball.getX() - ball.getRadius();
        float edgeY2 = ball.getY() + ball.getRadius();
        float edgeY1 = ball.getY() - ball.getRadius();
        if ((edgeX2 < x2) && (edgeY2 < y2) && (edgeX1 > x1) && (edgeY1 > y1)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Container[" +
                "(" + x1 + ", " + y1 + "), " +
                "(" + x2 + ", " + y2 + ")]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Container container = (Container) o;

        if (x1 != container.x1) return false;
        if (y1 != container.y1) return false;
        if (x2 != container.x2) return false;
        return y2 == container.y2;
    }

    @Override
    public int hashCode() {
        int result = x1;
        result = 31 * result + y1;
        result = 31 * result + x2;
        result = 31 * result + y2;
        return result;
    }
}
