import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by shishengjia
 */
public class AlgoVisHelper {

    private AlgoVisHelper(){}

    public static void pause(int t){
        try{
            Thread.sleep(t);
        }catch (InterruptedException e){
            System.out.println("Error in sleeping");
        }
    }

    public static void setColor(Graphics2D g2d, Color color){
        g2d.setColor(color);
    }

    public static void openAntiAliased(Graphics2D g2d, boolean isopen){
        if(isopen){
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }else{
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_OFF);
        }

    }

    public static void setStrokeWidth(Graphics2D g2d, int w){
        g2d.setStroke(new BasicStroke(w, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    public static void strokeCircle(Graphics2D g2d, int x, int y, int r){
        // notice difference between graphic coordinate system and mathematical coordinate system
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.draw(circle);
    }

    public static void fillCircle(Graphics2D g2d, int x, int y, int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.fill(circle);
    }

}
