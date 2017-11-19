package SelectionSortVis;

public class SelectionSortData {

    private int[] numbers;
    public int orderedIndex;
    public int currentMinIndex;
    public int currentCompareIndex;


    public SelectionSortData(int N, int randomBounds){
        numbers = new int[N];

        for(int i = 0; i < N; i++)
            numbers[i] = (int)(Math.random()*randomBounds) + 1;
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

//        numbers[i] = numbers[i] ^ numbers[j];
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
