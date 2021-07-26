/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathaddons;

/**
 *
 * @author Eric
 */
public class MathAddons {

    private int x;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] k={"Hello", "Good morning", "Wonderful", "Cant believe it", "Wow"};
        ListController<String> l=new ListController<>(k);
        for(int x=0; x<k.length*2; x++){
            System.out.println(l.getRandom());
        }
    }
    public void runLCMOFARRAY_TEST(){
        int[] n = {17, 27, 37, 54, 79};
        double avg = 0, low=0;
//        int lowest=lcmofarray(n,0,n.length);
//        for (int x = 0; x<n.length; x++) {
//            System.out.println(n[x]+": "+(double) lowest/n[x]);
//        }
//        System.out.println();
        long a;
        for (int z = 0; z<10000000; z++) {
            a = System.nanoTime();
            low = lcmofarray(n, 0);
            avg = ((avg*z)+((float) (System.nanoTime()-a)/1000))/(z+1);
        }
        System.out.printf("%.2es\n", (avg*Math.pow(10, -9)));
        System.out.println(low);
    }

    public static int lcmofarray(int[] arr, int start) {
        if ((arr.length-start)==1) {
            return arr[start];
        } else {
            return lcm(arr[start], lcmofarray(arr, start+1));
        }
    }

    public static int gcd(int a, int b) {
        if (a%b!=0) {
            return gcd(b, a%b);
        } else {
            return b;
        }
    }

    public static int lcm(int a, int b) {
        if (a<b) {
            return ((a*b)/gcd(b, a));
        } else {
            return ((a*b)/gcd(a, b));
        }
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n==0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i<n; i++) {
                permutation(prefix+str.charAt(i), str.substring(0, i)+str.substring(i+1, n));
            }
        }
    }

    public static int testForMultiples(int[] n) {
        int len = n.length;
        for (int x = 0; x<len; x++) {
            for (int c = x; c<len; c++) {
                if ((double) n[x]/n[c]==2) {
                    return n[c];
                } else if ((double) n[c]/n[x]==2) {
                    return n[x];
                }
            }
        }
        return 0;
    }

    public static int lowestCommonMultipleOf(int[] n) {
        int len = n.length;
        int[][] f = new int[len][];
        int[] hf = new int[15];
        for (int z = 0; z<len; z++) {
            f[z] = primeFactorsOf(n[z]);
        }
        int var, numRecurses, highest, mult = 1;
        for (int[] f2 : f) {
            for (int c = 0; c<f2.length; c++) {
                if (f2[c]!=1&&f2[c]!=0) {
                    var = f2[c];
                    boolean trip = false;
                    for (int v = 0; v<hf.length; v++) {
                        if (hf[v]==0) {
                            break;
                        } else if (hf[v]==var) {
                            trip = true;
                            break;
                        }
                    }
                    if (trip) {
                        continue;
                    }
                    highest = 0;
                    for (int[] f1 : f) {
                        numRecurses = 0;
                        for (int b = 0; b<f1.length; b++) {
                            if (f1[b]==var) {
                                numRecurses++;
                            }
                        }
                        if (numRecurses>highest) {
                            highest = numRecurses;
                        }
                    }
                    for (int v = 0; v<hf.length; v++) {
                        if (hf[v]==0) {
                            hf[v] = var;
                            break;
                        }
                    }
                    for (int v = 0; v<highest; v++) {
                        mult *= var;
                    }
                }
            }
        }
        return mult;
    }

    public static int lowestCommonMultipleOf(int n1, int n2) {
        int[] f1 = primeFactorsOf(n1);
        int[] f2 = primeFactorsOf(n2);
        for (int x = 0; x<f1.length; x++) {
            for (int c = 0; c<f2.length; c++) {
                if (f1[x]==f2[c]) {
                    f1[x] = 0;
                    f2[c] = 0;
                }
            }
        }
        int mult = 1;
        for (int v = 0; v<f1.length; v++) {
            if (f1[v]!=0) {
                mult *= f1[v];
            }
        }
        if ((double) mult/n2==mult/n2) {
            return mult;
        }
        return mult*n2;
    }

    public static void showFactorsOf(int n) {
        int[] factors = primeFactorsOf(n);
        System.out.println();
        System.out.print("Factors of "+n+" are ");
        for (int x = 0; x<factors.length; x++) {
            if (factors[x]!=0&&(x!=(factors.length-1))) {
                System.out.print(factors[x]+", ");
            } else {
                System.out.println(factors[x]);
            }
        }
    }

    private static int[] expandArray(int[] n) {
        int[] nn = new int[n.length+1];
        System.arraycopy(n, 0, nn, 0, n.length);
        return nn;
    }

    public static int[] primeFactorsOf(int n) {
        int[] factorList = new int[4];
        int nSave = n;
        int countFactors = 0;
        int divisor = 2;
        while (n>1) {
            if ((double) n/divisor==(int) (n/divisor)) {
                n /= divisor;
                if (countFactors>=factorList.length) {
                    factorList = expandArray(factorList);
                }
                factorList[countFactors] = divisor;
                countFactors++;
            } else {
                if (divisor>(int) (nSave/2)) {
                    break;
                }
                divisor++;
            }
        }
        if (countFactors==0) {
            int[] ret = {1, n};
            return ret;
        }
        int[] primeFactors = new int[countFactors];
        System.arraycopy(factorList, 0, primeFactors, 0, countFactors);
        return primeFactors;
    }

}
