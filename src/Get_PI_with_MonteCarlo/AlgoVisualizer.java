package Get_PI_with_MonteCarlo;

import java.awt.*;
import CircleAnimation.AlgoVisHelper;

public class AlgoVisualizer {

    private static int DELAY = 40;
    private MonteCarloPIData data;
    private AlgoFrame frame;    // 视图
    private int N;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){

        // 初始化数据
        Circle circle = new Circle(sceneWidth/2, sceneHeight/2, sceneWidth/2);
        data = new MonteCarloPIData(circle);
        this.N = N;

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Get PI with MonteCarlo", sceneWidth, sceneHeight);

            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){
        // 打入 N 个点
        for(int i = 0; i < N; i ++){

            if(i % 500 == 0) {
                frame.render(data);
                AlgoVisHelper.pause(DELAY);
                System.out.println(data.extimatePi());
            }

            int x = (int)(Math.random() * frame.getCanvasWidth());
            int y = (int)(Math.random() * frame.getCanvasHeight());
            data.addPoint(new Point(x, y));

        }

    }

    public static void main(String[] args) {

        int sceneWidth = 500;
        int sceneHeight = 500;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, 100000);
    }
}
