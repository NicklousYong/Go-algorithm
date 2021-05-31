package com.nicklous.algorithm.atraman;/*
 * @AUTHOR   LiXiang
 * @Classname FindPoisonedDuration
 *
 * @Date 2021/5/21 下午1:24
 *
 * @userName
 */

import java.util.Arrays;

public class FindPoisonedDuration {

    public static void main(String[] args) {
        int[] timeTemp = {1,5,10,14,28};
        int duration = 2;
        System.out.println("result is : " + FindPoisonedDuration(timeTemp,duration));
    }
    public static int FindPoisonedDuration(int[] timeSeries,int duration){
        //持续时间
        int durationResult = duration;
        //指示循环到了哪个索引位置
        int indictor = 0;
        //指示前一个节点是否是连续的
        boolean isBreak = false;
        if(timeSeries.length<=1){
            durationResult = (timeSeries.length==0)?0:duration;
        }
        else{
            for(int i=1;i<timeSeries.length;i++){
                System.out.println("开始判断索引的位置为： "+i);
                int breakPoint = 0;
                indictor = i;
                //断开，或者到了数组末尾,都需要计算连续的时间
                if (timeSeries[i]-timeSeries[indictor]>=duration || i==timeSeries.length-1){
                    //此时是断开的，那么直接将持续时间添加进去
                    System.out.println("此时是断开的");
                    if(isBreak){
                        System.out.println("之前就是断开的");
                        //如果之前就是断开的,直接添加时间
                        durationResult = durationResult+duration;
                    }else{
                        //如果之前没断开，但是现在断开了，计算断开之前的持续时间
                        System.out.println("之前没断开，但是现在断开了");
                        // (连续空间的末尾值(timeSeries[i])减去连续空间的最初值(timeSeries[indictor])加上duration)
                        durationResult = durationResult+timeSeries[i]-timeSeries[indictor]+duration;
                        System.out.println("计算得连续时间为： "+durationResult);
                    }
                    breakPoint=timeSeries[indictor];
                    isBreak=true;
                }else{
                    //此时是连续的.
                    System.out.println("此时不是断开的");
                    isBreak = false;
                }
            }
        }
        return durationResult;
        }
    }

