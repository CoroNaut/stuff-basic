/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random_methods;

import java.util.Random;

/**
 *
 * @author
 */
public class Random_methods {

    final static public Random rand = new Random(System.currentTimeMillis());
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BiasedRandomTest();
    }
    public static void BiasedRandomTest(){
        int[] stats=new int[100];
        for(int x=0; x<1000000; x++){
            double bRandom=nextSkewedBoundedDouble(0,100,50,1);
            stats[(int)bRandom]++;
        }
        for(int c=0; c<100; c++){
            System.out.println(c+", "+stats[c]);
        }
    }
    public static double nextBiasedRandom(double min, double max, double skewNum, double variance){
        double range=max-min;
        double r=(rand.nextDouble()*range)+min;
        return (r/skewNum);
    }
    static public double nextSkewedBoundedDouble(double min, double max, double skew, double bias) {
        double range = max - min;
        double mid = min + range / 2.0;
        double unitGaussian = rand.nextGaussian();
        double biasFactor = Math.exp(bias);
        double retval = mid+(range*(biasFactor/(biasFactor+Math.exp(-unitGaussian/skew))-0.5));
        return retval;
    }
}
