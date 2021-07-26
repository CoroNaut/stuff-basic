/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocklandmining;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class BlocklandMining {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(getPick(65000, 65000));

        System.out.println(getMoneyForPicks(1, 18952,0));
        System.out.println(getMoneyForPicks(1, 65000,0));
        System.out.println(getUpgradePickAmountForMoney(3000000000L,1,0));
        System.out.println(getUpgradePickAmountForMoney(51053239741L,1,0));
//        for(int x=5; x<20; x++){
//            System.out.print(x);
//            firstTenRanks(x);
//        }
    }

    private static void firstNumRanksIntoFile() {
        int levels=65000;
        int ranks=15000;
        try {
            PrintWriter writer = new PrintWriter("out.txt", "UTF-8");
            System.out.println("Base Created");
            for (int x = 9; x<=levels; x++) {
                System.out.println(x);
                for (int c = 0; c<=ranks; c++) {
                    writer.print(getPick(x,c)+",");
                    //writer.printf("%12d ,  ", getPick(x, c));
                }
                writer.println();
            }
            writer.close();
        } catch (FileNotFoundException e) {

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(BlocklandMining.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void firstNumRanks(int level, int ranks) {
        for (int x = 0; x<=ranks; x++) {
            System.out.printf("%12d ,  ", getPick(level, x));
        }
        System.out.println();
    }

    private static long getPick(int level, int rank) {
        int ret = level+1;
        if (ret<10) {
            return 50;
        }
        if (rank>0) {
            return (long) (Math.floor(Math.pow(ret, 1.3))*rank);
        }
        return (long) (Math.floor(Math.pow(ret, 1.3))+50);
    }

    private static int getUpgradePickAmountForMoney(long money, int startPick, int rank) {
        int ret = 0;
        for (;;) {
            if (money<=0) {
                return ret-1;
            } else {
                money -= getPick(startPick, rank);
                startPick++;
                ret++;
            }
        }
    }

    private static long getMoneyForPicks(int startPick, int wantedPick, int rank) {
        long ret = 0;
        for (int x = startPick; x<=wantedPick; x++) {
            ret += getPick(x, rank);
        }
        return ret;
    }
// {
//   %num = %client.getPick() + 1;
//   if ( %num < 10)
//     {
//      return 50;
//     }
//   if ( %client.stats.rank > 0)
//     {
//      return mFloor( mPow(%num,1.3) ) * %client.stats.rank;
//     }
//   return mFloor( mPow(%num,1.3) ) + 50;
//  }   
}
