/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathaddons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Eric
 */
public class ListController<E extends Object> {
    private ArrayList<E> list=new ArrayList<>();
    private boolean[] used;
    private int length, counter;
    public ListController(E[] l){
        list.clear();
        list.addAll(Arrays.asList(l));
        length=l.length;
        used=new boolean[length];
    }
    public boolean getUsed(int index){
        return used[index];
    }
    public E getElement(int index){
        return list.get(index);
    }
    public E getRandom(){
        if(counter==length){
            reset();
        }
        int ran;
        do{
            ran=(new Random()).nextInt(length);
        }while(!used[ran]);
        counter++;
        used[ran]=true;
        return list.get(ran);
    }
    private void reset(){
        Arrays.fill(used, false);
    }
}
