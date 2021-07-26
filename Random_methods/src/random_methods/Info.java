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
public class Info {
    final private int info;
    private int access=0;
    public Info(int i){
        info=i;
        randAccess();
    }
    public void access(){
        access++;
    }
    private void randAccess(){
        Random rand=new Random();
        access=rand.nextInt(100);
    }
    public int getInfo(){
        return info;
    }
    public int getAccess(){
        return access;
    }
}
