package Get_PI_with_MonteCarlo;

import java.awt.*;

public class MonteCarloExperiment {

    private int squearWidth;
    private int N;
    private int outputInterval;
    private MonteCarloPIData data;

    public MonteCarloExperiment(int squearWidth, int n, int ouputInterval) {
        this.squearWidth = squearWidth;
        N = n;
        this.outputInterval = ouputInterval;
        Circle circle = new Circle(squearWidth/2, squearWidth/2, squearWidth/2);
        data = new MonteCarloPIData(circle);
    }

    public void run(){
        for(int i = 0; i < N; i ++){
            if(i % outputInterval == 0 )
                System.out.println(data.extimatePi());

            int x = (int)(Math.random() * squearWidth);
            int y = (int)(Math.random() * squearWidth);
            data.addPoint(new Point(x, y));
        }
    }


    public static void main(String args[]){
        MonteCarloExperiment me = new MonteCarloExperiment(800, 10000000, 100000);
        me.run();
    }
}
