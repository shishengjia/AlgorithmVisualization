package MoneyAllocation;

import CircleAnimation.AlgoVisHelper;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.Arrays;

public class AlgoVisualizer {

    private int[] money;        // 数据
    private AlgoFrame frame;    // 视图
    public boolean isAnimated = true;

    public AlgoVisualizer(int sceneWidth, int sceneHeight){

        // 初始化数据
        money = new int[100];
        for(int i = 0 ; i < money.length; i ++)
            money[i] = 100;

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            // TODO: 根据情况决定是否加入键盘鼠标事件监听器
            frame.addKeyListener(new AlgoKeyListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){

        // TODO: 编写自己的动画逻辑
        while(true){
            Arrays.sort(money);
            frame.render(money);
            AlgoVisHelper.pause(40);

            if(isAnimated)
                for(int k = 0; k < 60; k ++)
                    for(int i = 0; i < money.length; i++) {
                        int j = (int) (Math.random() * money.length);
                        money[i] -= 1;
                        money[j] += 1;
                    }
        }
    }

    private class AlgoKeyListener extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent event){
            if(event.getKeyChar() == ' ')
                isAnimated = !isAnimated;
        }
    }

    public static void main(String[] args) {

        int sceneWidth = 1200;
        int sceneHeight = 1200;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
