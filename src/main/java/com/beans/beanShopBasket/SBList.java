package com.beans.beanShopBasket;

import com.beans.beanCar.AdList;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by FlipBook TP300LD on 06.11.2016.
 */
public class SBList {
    private static LinkedHashMap<Integer, Integer> SBList = new LinkedHashMap<>();

    public void addItem(int id) {
        int v = 1;

        for(Map.Entry<Integer,Integer> entry: SBList.entrySet()) {

            if (entry.getKey() == id){
                v = entry.getValue();
                v++;
            }
        }
        SBList.put(id,v);
    }

    public void removeItem(int id) {
        int v = 1;
        for (Map.Entry<Integer, Integer> entry: SBList.entrySet())
        {
            if(entry.getKey()==id) {
                v = entry.getValue();
                if(v > 1) {
                    v--;
                    SBList.put(id,v);
                } else {
                    for(Iterator<Map.Entry<Integer, Integer>> it = SBList.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<Integer, Integer> entry1 = it.next();
                        if(entry1.getKey()== id) {
                            it.remove();
                        }
                    }
                }
                break;
            }
        }
    }




    public static LinkedHashMap<Integer, Integer> getSBList() {
        return new LinkedHashMap<>(SBList);
    }

    public static SBList get(HttpSession session) {
        SBList cart = (SBList) session.getAttribute("cart");
        if (cart == null) {
            cart = new SBList();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    public static int getSize() {
        int size = 0;
        for (int val : SBList.values()) {
            size+=val;
        }
        return size;
    }

    public static int getSum() {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry: SBList.entrySet()) {
            int id = entry.getKey();
            if(entry.getValue() > 1) {
                sum+= AdList.getAdList().get(id).getPrice()*entry.getValue();
            } else {
                sum+=AdList.getAdList().get(id).getPrice();
            }
        }
        return sum;
    }

    public void removeBasket(){
        SBList.clear();
    }

}
