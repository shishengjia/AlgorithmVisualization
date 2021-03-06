package CircleAnimation;

import java.awt.*;

/**
 * Created by shishengjia
 */

public class Circle {
    public int x, y;
    private int r;
    public int vx, vy;
    public boolean isFilled = false;

    public Circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }

    public int getRadius(){
        return r;
    }

    public void move(int minx, int miny, int maxx, int maxy){
        x += vx;
        y += vy;
        checkCollision(minx, miny, maxx, maxy);
    }

    private void checkCollision(int minx, int miny, int maxx, int maxy){
        // simple collision check
        // TODO collision between circles
        if(x - r < minx) {x = r; vx = -vx;}
        if(x + r >= maxx) {x = maxx - r; vx = -vx;}
        if(y - r < miny) {y = r; vy = -vy;}
        if(y + r >= maxy) {y = maxy - r; vy = -vy;}
    }

    public boolean contain(Point p){
        return (x - p.x) * (x - p.x) + (y - p.y) * (y - p.y) <= r * r;
    }
}
