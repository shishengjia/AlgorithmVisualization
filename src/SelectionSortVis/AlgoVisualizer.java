package SelectionSortVis;

import CircleAnimation.AlgoVisHelper;

import java.awt.*;

public class AlgoVisualizer {

    private SelectionSortData data;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){

        // 初始化数据
        data = new SelectionSortData(N, sceneHeight);
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

        setData(0, -1, -1);

        for(int i = 0; i < data.length(); i++){
            //更新有序索引
            int min_index = i;
            setData(i, min_index, -1);
            for(int j = i + 1; j < data.length(); j++ ) {
                //更新比较索引
                setData(i, min_index, j);
                if (data.get(j) < data.get(min_index)) {
                    min_index = j;
                    // 更新最小值索引
                    setData(i, min_index, j);
                }
            }

            data.swap(i, min_index);
            setData(i+1, -1, -1);

        }

        setData(data.length(), -1, -1);

    }

    private void setData(int orderedIndex, int currentMinIndex, int currentCompareIndex){
        data.orderedIndex = orderedIndex;
        data.currentMinIndex = currentMinIndex;
        data.currentCompareIndex = currentCompareIndex;
        frame.render(data);
        AlgoVisHelper.pause(10);
    }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, 100);
    }
}
