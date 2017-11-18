package Get_PI_with_MonteCarlo;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MonteCarloPIData {
    private Circle circle;
    private LinkedList<Point> points;
    private int inSideCircle = 0;

    public MonteCarloPIData(Circle circle) {
        this.circle = circle;
        this.points = new LinkedList<Point>();
    }

    public Circle getCircle(){ return circle; }

    public LinkedList<Point> getPoints() {
        return points;
    }

    public int getPointNumber(){ return points.size(); }

    public Point getPoint(int i){
        if(i < 0 || i >= points.size())
            throw new IllegalArgumentException("out of bound in getPoint!");
        else
            return points.get(i);
    }

    public void addPoint(Point p){
        if(circle.contain(p))
            inSideCircle ++;
        points.add(p);
    }


    public double extimatePi(){

        // 正方形: 2r * 2r 圆形: pi * r * r
        //pi = 4 * 正方形面积 / 圆形面积
        //用点数来估计面积

        if(points.size() == 0)
            return 0.0;

        return (double)4 * inSideCircle / points.size();

    }
}
