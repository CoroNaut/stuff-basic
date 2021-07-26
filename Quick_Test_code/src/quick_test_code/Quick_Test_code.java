/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quick_test_code;

import java.util.ArrayList;

/**
 *
 * @author
 */
public class Quick_Test_code {

    public static ArrayList<Double> k = new ArrayList<>();

    public static void main(String[] args) {
        collatzConjecture();
    }

    public static void collatzConjecture() {
        int high = 0;
        for (int x = 1; x>-1; x++) {
            int t1 = 0;
            long t2 = x;
            while (t2!=1) {
                t1++;
                if (t2%2==0) {
                    t2 /= 2;
                } else {
                    t2 = 3*t2+1;
                }
            }
            if (t1>high) {
                high = t1;
                System.out.println("Init number: "+x+", "+high);
            }
        }
    }
}
