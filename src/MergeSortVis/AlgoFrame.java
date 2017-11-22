package MergeSortVis;

import CircleAnimation.AlgoVisHelper;

import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.RenderingHints;

import javax.swing.*;

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

    private MergeSortData data;
    public void render(MergeSortData data){
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
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // 具体绘制
            int width = canvasWidth / data.length();

            for(int i = 0; i < data.length(); i++){
                if(i >= data.l && i <= data.r) // 正在处理的元素
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Green);
                else
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Grey);

                if(i >= data.l && i <= data.mergeIndex) // merge 过程中已经有序的部分
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.DeepOrange);

                AlgoVisHelper.fillRectangle(g2d,i * width, canvasHeight-data.get(i), width - 1, data.get(i));
            }

        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}


