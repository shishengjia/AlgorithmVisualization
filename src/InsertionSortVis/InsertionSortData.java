package InsertionSortVis;

import java.util.Arrays;

public class InsertionSortData {

    private int[] numbers;
    public int orderedIndex;
    public int currentIndex;

    public enum Type{
        Default,
        NearlyOrdered,
    }


    public InsertionSortData(int N, int randomBounds, Type type){
        numbers = new int[N];

        for(int i = 0; i < N; i++)
            numbers[i] = (int)(Math.random()*randomBounds) + 1;

        if(type == Type.NearlyOrdered){
            Arrays.sort(numbers);
            int swap_time = (int)(0.02*N);
            for(int i = 0; i < swap_time; i++){

                int x = (int)(Math.random()*N);
                int y = (int)(Math.random()*N);
                swap(x, y);
            }
        }
    }

    public int length(){
        return numbers.length;
    }

    public int get(int index){
        if(index < 0 || index >= numbers.length)
            throw new IllegalArgumentException("out of bounds");

        return numbers[index];
    }

    public void swap(int i, int j){

        if( i < 0 || i >= numbers.length || j < 0 || j >= numbers.length)
            throw new IllegalArgumentException("out of bounds");

//        numbers[i] = n想umbers[i] ^ numbers[j];
//        numbers[j] = numbers[i] ^ numbers[j];
//        numbers[i] = numbers[i] ^ numbers[j];
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

    public void print_data(){
        for(int i: numbers)
            System.out.println(i);
    }

}
