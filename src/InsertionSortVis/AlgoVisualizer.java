package InsertionSortVis;

import CircleAnimation.AlgoVisHelper;

import java.awt.*;

public class AlgoVisualizer {

    private InsertionSortData data;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){

        // 初始化数据
        data = new InsertionSortData(N, sceneHeight, InsertionSortData.Type.NearlyOrdered);
        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){

        setData(-1, -1);

        for(int i = 0; i  < data.length(); i ++){

            setData(i, i);
            for(int j = i; j > 0 && data.get(j) < data.get(j-1); j --){
                data.swap(j, j-1);
                setData(i+1, j-1);
            }
        }

        setData(data.length(), -1);

    }

    private void setData(int orderedIndex, int currentIndex){
        data.orderedIndex = orderedIndex;
        data.currentIndex = currentIndex;
        frame.render(data);
        AlgoVisHelper.pause(10);
    }

    public static void main(String[] args) {

        int sceneWidth = 1000;
        int sceneHeight = 1000;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, 180);
    }
}
