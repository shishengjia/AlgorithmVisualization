package MergeSortVis;

import CircleAnimation.AlgoVisHelper;

import java.awt.*;
import java.util.Arrays;

public class AlgoVisualizer {

    public MergeSortData data;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){

        // 初始化数据
        data = new MergeSortData(N, sceneHeight, MergeSortData.Type.NearlyOrdered);

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

        setData(-1, -1, -1);
        mergeSort(0, data.length()-1);
        setData(0, data.length()-1, data.length()-1);
    }

    private void setData(int l, int r, int minIndex){
        data.l = l;
        data.r = r;
        data.mergeIndex = minIndex;

        frame.render(data);
        AlgoVisHelper.pause(40);
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private void mergeSort(int l, int r) {

        if (l >= r)
            return;

        setData(l, r, -1);

        int mid = l + (r - l) / 2;
        mergeSort(l, mid);
        mergeSort(mid + 1, r);
        // 不一定所有情况都要merge， 可能已经有序了
        if(data.numbers[mid] > data.numbers[mid+1] )
            merge(l, mid, r);
    }

    private void merge(int l, int mid, int r){
        int[] aux = Arrays.copyOfRange(data.numbers, l, r+1);

        int i = l;
        int j = mid + 1;

        //注意偏移量 l

        for(int k = l ; k <= r; k++){

            if(i > mid){ // 左半部分元素处理完毕
                data.numbers[k] = aux[j-l];
                j ++;
            }
            else if(j > r){ // 右半部分元素处理完毕
                data.numbers[k] = aux[i-l];
                i ++;
            }
            else if(aux[i-l] < aux[j-l]){ //左边元素小于右边，选择左边
                data.numbers[k] = aux[i-l];
                i ++;
            }else{
                data.numbers[k] = aux[j-l];
                j ++;
            }
            // 每一次循环都更新 mergeIndex
            setData(l, r, k);
        }
    }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, 100);
    }
}
