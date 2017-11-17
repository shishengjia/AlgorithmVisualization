package CircleAnimation;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by shishengjia
 */
public class AlgoVisualizer {

    private Circle[] circles;
    private AlgorithmFrame frame;
    private boolean isAnimated = true;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int radius, int n){


        //data preparation
        circles = new Circle[n];

        for(int i = 0 ; i < n ; i ++){
            // make sure that circles will be in the scene
            int x = (int)(Math.random()*(sceneWidth-2*radius)) + radius;
            int y = (int)(Math.random()*(sceneHeight-2*radius)) + radius;
            // [-5, 5]
            int vx = (int)(Math.random()*10) - 5;
            int vy = (int)(Math.random()*10) - 5;
            circles[i] = new Circle(x, y, radius, vx, vy);
        }

        //recommended way to create a window
        EventQueue.invokeLater(()->{
            frame = new AlgorithmFrame("Welcome", sceneWidth, sceneHeight);
            frame.addMouseListener(new AlgoMouseListener());
            frame.addKeyListener(new AlgoKeyListener());
            new Thread(() ->{
                run();
            }).start();

        });
    }

    public void run(){
        while(true){
            //draw circles
            frame.render(circles);
            AlgoVisHelper.pause(20);

            // update all circles' state
            if(isAnimated)
                for(Circle circle: circles)
                    circle.move(0 , 0, frame.getCanvasWidth(), frame.getCanvasHeight());
        }
    }

    private class AlgoKeyListener extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent event){
            if(event.getKeyChar() == ' ')
                isAnimated = !isAnimated;
        }
    }

    private class AlgoMouseListener extends MouseAdapter {

        @Override
        public void mouseReleased(MouseEvent event){

            event.translatePoint(
                    0,
                    -(frame.getBounds().height - frame.getCanvasHeight())
            );
            //System.out.println(event.getPoint());

            for(Circle circle : circles)
                if(circle.contain(event.getPoint()))
                    circle.isFilled = !circle.isFilled;
        }
    }

}
