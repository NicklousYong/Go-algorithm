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

    public static int coinChange(int[] coins,int amount){
        if(amount<0){
            return -1;
        }
        return coinChange(coins,amount,new int[amount]);
    }

    public  static int coinChange(int[] coins, int amount,int[] count) {
        // 最优子结构 逆向思维，从答案反推解决问题
        if(amount<0){
            return -1;
        }
        if(amount==0){
            return 0;
        }
        if(count[amount-1] != 0){
            return count[amount-1];
        }
        //结果
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = coinChange(coins,amount-coin,count);
            if(result>=0 && result< min){
                min = result+1;
            }
        }
        count[amount-1] = min==Integer.MAX_VALUE?-1:min;
        return count[amount-1];
    }



}
