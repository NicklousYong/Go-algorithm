package com.nicklous.algorithm.Easy;

import java.util.HashMap;
import java.util.Map;

public class Fib_509 {

    public static void main(String[] args) {


    }
    // 0,1,1,2,
    Map<Integer,Integer> fibMap = new HashMap();

    public int fib(int n) {
        //每一项值为前两项和
        if(n==0 || n==1){
            return n;
        }
        if(fibMap.containsKey(n)){
            return fibMap.get(n);
        }else{
            fibMap.put(n,fib(n-1)+fib(n-2));
        }
        return fib(n-1)+fib(n-2);
    }

}
