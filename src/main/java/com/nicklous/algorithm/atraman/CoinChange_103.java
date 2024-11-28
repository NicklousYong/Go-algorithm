package com.nicklous.algorithm.atraman;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.HashMap;
import java.util.Map;

public class CoinChange_103 {

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,5};
        int amount = 11;
        int result = coinChange(ints,amount);
        System.out.println("result is: "+result);
    }


   static Map<Integer,Integer> minMap = new HashMap<Integer, Integer>();

    public static int coinChange(int[]  coins,int amount){
        // 最优子结构 逆向思维，从答案反推解决问题
        if(amount<0){
            return -1;
        }
        if(amount==0){
            return 0;
        }
        //结果
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if(minMap.containsKey(amount)){
                return minMap.get(amount);
            }else {
                int result = coinChange(coins,amount-coin);
                if(result>=0 && result<= min){
                    min = result+1;
                    minMap.put(amount,min==Integer.MAX_VALUE?-1:min);
                }
                return minMap.get(amount);
            }
        }

    }






}
