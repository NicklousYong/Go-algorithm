package com.nicklous.algorithm.atraman;/*
 * @AUTHOR   LiXiang
 * @Classname temp
 *
 * @Date 2021/5/28 下午4:55
 *

 * @userName
 */

public class Temp {

    public static  int[] a = {5,7,10,21,58,23};

    public static void main(String[] args) {
            Temp  temp= new Temp();
        System.out.println(getFirst(a));
    }

    public static int getFirst(int[] num) {
        int first = 0;
        for (int i = 0; i <num.length ; i++) {
            //思路：如果当前值大于最大值，则最大值为当前值，否则继续遍历
            if (num[i]>first)
                first=num[i];
        }

        return first;
    }

}
