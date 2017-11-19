package MontyHallproblem;

public class MontyHall {
    /*
        三门问题
        玩家从三个门（其中一个能中奖）选一个， 选定门后， 主持人会指定另一扇门，那扇门不会中奖， 并且通知玩家要不要更换选择
        玩家换与不换的中奖概率: 近似 2/3 1/3
     */

    private int N;
    private boolean change;

    private MontyHall(int N, boolean change){
        this.N = N;
        this.change = change;
    }

    private void run(){

        int wins= 0;
        for(int i = 0; i < N; i ++)
            if(play(change))
                wins ++;
        System.out.println(change ? "Change door" : "Not change door");
        System.out.println((double)wins / N);


    }

    private boolean play(boolean change){

        //doors 0, 1, 2
        int priceDoor = (int)(Math.random() * 3);
        int choiceDoor = (int)(Math.random() * 3);

        if(priceDoor == choiceDoor)
            return change ? false : true;
        else
            return change ? true : false;
    }


    public static void main(String args[]){
        MontyHall m1 = new MontyHall(10000, true);
        MontyHall m2 = new MontyHall(10000, false);

        m1.run();
        m2.run();

    }
}
