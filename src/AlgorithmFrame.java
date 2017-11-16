import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;


/**
 * Created by shishengjia
 */
public class AlgorithmFrame extends JFrame{

    private int canvasWidth;
    private int canvasHeight;
    private Circle[] circles;

    public AlgorithmFrame(String title, int canvasWidth, int canvasHeight){
        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgorithmCanvas canvas = new AlgorithmCanvas();
        setContentPane(canvas);
        pack();

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public int getCanvasWidth() { return canvasWidth; }

    public int getCanvasHeight() { return canvasHeight; }

    public void render(Circle[] circles){
        this.circles = circles;
        repaint();
    }

    private class AlgorithmCanvas extends JPanel{

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            //Anti-aliased
            AlgoVisHelper.openAntiAliased(g2d, true);
            AlgoVisHelper.setStrokeWidth(g2d, 1);
            AlgoVisHelper.setColor(g2d, Color.RED);
            for(Circle circle: circles)
                AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getRadius());
        }

        @Override
        public Dimension getPreferredSize(){
            //decide the size of window
            return new Dimension(canvasWidth, canvasHeight);
        }
    }


}
