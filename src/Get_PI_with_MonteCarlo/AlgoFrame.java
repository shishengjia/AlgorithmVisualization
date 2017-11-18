package Get_PI_with_MonteCarlo;

import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;

import CircleAnimation.AlgoVisHelper;

public class AlgoFrame extends JFrame{

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    public AlgoFrame(String title){

        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}

    //设置数据
    public MonteCarloPIData data;
    public void render(MonteCarloPIData data){
        this.data = data;
        repaint();
    }

    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            // 双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            // 抗锯齿
            AlgoVisHelper.openAntiAliased(g2d, true);

            // 具体绘制
            Circle circle = data.getCircle();
            AlgoVisHelper.setStrokeWidth(g2d, 3);
            AlgoVisHelper.setColor(g2d, AlgoVisHelper.Blue);
            AlgoVisHelper.strokeCircle(g2d, circle.getX(), circle.getY(), circle.getR());

            //圆内红点， 圆外绿点
            for(int i = 0 ; i < data.getPointNumber(); i ++) {
                Point p = data.getPoint(i);
                if (circle.contain(p))
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Black);
                else
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Yellow);

                AlgoVisHelper.fillCircle(g2d, p.x, p.y, 3);
            }
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}


